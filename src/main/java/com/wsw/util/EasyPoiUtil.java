package com.wsw.util;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wensw
 */

@Slf4j
public class EasyPoiUtil {

    /**
     * xls文件后缀
     */
    public static final String XLS = ".xls";

    /**
     * xlsx文件后缀
     */
    public static final String XLSX = ".xlsx";

    /**
     * 生成文件目录
     */
    private static final String CREATE_DIR = "/exceltemp/";

    /**
     * 临时文件名
     */
    private static final String TEMP_FILE_NAME = "temp_export_copy";


    /**
     * 注解类生成xls excel文件
     *
     * @param params        参数
     * @param pojoClass     自定义实体类
     * @param dataSet       数据列表
     * @param path          保存路径
     * @return 文件名
     */
    public static String createExcel(ExportParams params, Class<?> pojoClass, Collection<?> dataSet, String path) {
        return createExcel(params, pojoClass, dataSet, path, XLS);
    }


    /**
     * 注解类生成excel文件
     *
     * @param params        参数
     * @param pojoClass     自定义实体类
     * @param dataSet       数据列表
     * @param path          保存路径
     * @param suffix        文件类型
     *
     * @return 文件名
     */
    public static String createExcel(ExportParams params,
                                     Class<?> pojoClass,
                                     Collection<?> dataSet,
                                     String path,
                                     String suffix) {

        Workbook workbook = ExcelExportUtil.exportExcel(params, pojoClass, dataSet);
        String fileName = UUID.randomUUID().toString() + suffix;
        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        write(path + File.separator + fileName, workbook);
        return fileName;
    }


    /**
     * 注解类下载excel文件
     *
     * @param params        参数
     * @param pojoClass     自定义实体类
     * @param dataSet       数据列表
     * @param response      response
     * @param downloadName  下载文件名
     */
    public static void downloadExcel(ExportParams params,
                                     Class<?> pojoClass,
                                     Collection<?> dataSet,
                                     HttpServletResponse response,
                                     String downloadName) throws Exception {

        Workbook workbook = ExcelExportUtil.exportExcel(params, pojoClass, dataSet);
        initResponse(downloadName, response);
        workbook.write(response.getOutputStream());
    }


    /**
     * 利用模版生成xls excel文件
     *
     * @param tempPath      模版路径
     * @param sheetName     sheetName
     * @param dataList      列表数据
     * @param param         其他数据
     * @return 文件名
     */
    public static String createExcelOfTemp(String tempPath,
                                           String sheetName,
                                           List<Map> dataList,
                                           Map<String, Object> param) {

        return createExcelOfTemp(tempPath, sheetName, dataList, param, XLS);
    }

    /**
     * 利用模版生成excel文件
     *
     * @param tempPath      模版路径
     * @param sheetName     sheetName
     * @param dataList      列表数据
     * @param param         其他数据
     * @param suffix        文件格式
     * @return 文件名
     */
    public static String createExcelOfTemp(String tempPath,
                                           String sheetName,
                                           List<Map> dataList,
                                           Map<String, Object> param,
                                           String suffix) {

        Workbook workbook = createWorkBook(tempPath, sheetName, dataList, param);
        String basePath = EasyPoiUtil.class.getResource(CREATE_DIR).getPath();
        File saveFile = new File(basePath);

        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + suffix;
        write(basePath + File.separator + fileName, workbook);
        return fileName;
    }

    /**
     * 直接下载Excel，模板中有取dataList数据的话用 {{$fe: list
     *
     * @param tempPath      模版路径
     * @param sheetName     sheetName
     * @param dataList      数据列表
     * @param param         其他数据
     * @param response      response
     * @param downloadName  下载文件名
     */
    public static void downloadExcelOfTemp(String tempPath,
                                           String sheetName,
                                           List<Map> dataList,
                                           Map<String, Object> param,
                                           HttpServletResponse response,
                                           String downloadName) throws Exception {

        Workbook workbook = createWorkBook(tempPath, sheetName, dataList, param);
        initResponse(downloadName, response);
        workbook.write(response.getOutputStream());
    }


    /**
     *
     * @param tempPath      模版路径
     * @param sheetName     sheetName
     * @param pojoClass     数据类型
     * @param dataSet       数据
     * @param param         其他数据
     * @param response      response
     * @param downloadName  下载文件名
     * @throws Exception    Exception
     */
    public static void downloadExcelOfTemp(String tempPath,
                                           String sheetName,
                                           Class<?> pojoClass,
                                           Collection<?> dataSet,
                                           Map<String, Object> param,
                                           HttpServletResponse response,
                                           String downloadName,
                                           int headRows) throws Exception {

        Workbook workbook = createWorkBook(tempPath, sheetName, pojoClass, dataSet, param, headRows);
        initResponse(downloadName, response);
        workbook.write(response.getOutputStream());
    }


    /**
     * 模版多sheet导出
     *
     * @param params            模版参数
     * @param map               数据 key sheet索引
     * @param downloadName      下载文件名
     * @param response          response
     * @throws Exception        Exception
     */
    public static void downloadExcelOfTemp(TemplateExportParams params,
                                           Map<Integer, List<Map<String, Object>>> map,
                                           String downloadName,
                                           HttpServletResponse response) throws Exception {

        Workbook workbook = ExcelExportUtil.exportExcelClone(map, params);
        initResponse(downloadName, response);
        workbook.write(response.getOutputStream());
    }


    /**
     * 注解多sheet导出
     *
     * @param list              数据列表   [{"list": List<PojoClass>, "param": ExportParams, "pojoClass": 注解实体类}]
     * @param downloadName      下载文件名
     * @param response          response
     * @throws Exception        Exception
     */
    public static void downloadExcel(List<Map> list, String downloadName, HttpServletResponse response)
        throws Exception {

        if (list == null || list.isEmpty()) {
            return;
        }

        Workbook workbook = new HSSFWorkbook();
        ExcelExportService excelExportService = new ExcelExportService();
        for (Map e : list) {
            Class<?> pojoClass = (Class<?>) e.get("pojoClass");
            List<ExcelExportEntity> excelParams = Lists.newArrayList();
            Field[] fields = PoiPublicUtil.getClassFields(pojoClass);
            ExcelTarget target = pojoClass.getAnnotation(ExcelTarget.class);
            String targetId = target == null ? null : target.value();
            ExportParams exportParams = (ExportParams) e.get("param");
            excelExportService.getAllExcelField(exportParams.getExclusions(), targetId, fields, excelParams, pojoClass,
                null, null);

            excelExportService.createSheetForMap(workbook, exportParams, excelParams, (Collection<?>) e.get("list"));
        }

        initResponse(downloadName, response);
        workbook.write(response.getOutputStream());
    }

    /**
     * 创建workbook
     *
     * @param tempPath      模板路径
     * @param sheetName     sheetName
     * @param dataList      数据列表
     * @param param         其他数据
     * @return Workbook
     */
    private static Workbook createWorkBook(String tempPath,
                                           String sheetName,
                                           List<Map> dataList,
                                           Map<String, Object> param) {

        TemplateExportParams params = new TemplateExportParams(
            tempPath,
            sheetName,
            0
        );

        param.put("list", dataList);
        return ExcelExportUtil.exportExcel(params, param);
    }

    /**
     * 创建workbook
     *
     * @param tempPath      模板路径
     * @param sheetName     sheetName
     * @param pojoClass     注解类
     * @param dataSet       数据
     * @param param         其他数据
     * @return Workbook
     */
    private static Workbook createWorkBook(String tempPath,
                                           String sheetName,
                                           Class<?> pojoClass,
                                           Collection<?> dataSet,
                                           Map<String, Object> param,
                                           int headRows) {

        TemplateExportParams params = new TemplateExportParams(
            tempPath,
            sheetName,
            0
        );
        params.setHeadingRows(headRows);
        return ExcelExportUtil.exportExcel(params, pojoClass, dataSet, param);
    }


    /**
     * 下载指定目录中的文件
     *
     * @param filePath      要下载的文件路径
     * @param fileName      要下载的文件名
     * @param response      response
     */
    public static void downloadExcelWithDelete(String filePath, String fileName, HttpServletResponse response) {
        initResponse(fileName, response);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(filePath + fileName, outputStream, true);
    }


    /**
     * 在临时目录创建文件，并在程序退出时自动删除
     *
     * @param tempPath          现有的文件路径
     * @param suffix            文件格式
     *
     * @return 临时目录中文件地址
     * @throws IOException      IOException
     */
    public static String getTempPath(String tempPath, String suffix) throws IOException {
        File somethingFile;

        try (
            InputStream resourceAsStream = EasyPoiUtil.class.getResourceAsStream(tempPath)
        ) {
            somethingFile = File.createTempFile(TEMP_FILE_NAME, suffix);
            FileUtils.copyInputStreamToFile(resourceAsStream, somethingFile);
        }

        somethingFile.deleteOnExit();
        return somethingFile.getPath();
    }


    private static void write(String savePath, Workbook workbook) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(savePath));
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error("创建excel失败：{}, sheetName：{}", savePath, workbook.getSheetAt(1).getSheetName());
            throw new RuntimeException("创建excel失败");
        } finally {
            if (null != workbook) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            close(outputStream, null);
        }
    }


    private static void writeFile(OutputStream output, InputStream inputStream) {
        byte[] b = new byte[2048];
        int len;
        try {
            while ((len = inputStream.read(b)) > 0) {
                output.write(b, 0, len);
            }
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(output, inputStream);
        }
    }


    private static void writeFile(String filePath, OutputStream output, boolean delete) {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            writeFile(output, inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (delete) {
                File file = new File(filePath);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private static void close(OutputStream outputStream, InputStream inputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initResponse(String downloadName, HttpServletResponse response) {
        response.reset();
        response.setCharacterEncoding("UTF-8");
        try {
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(downloadName, "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("下载excel失败！");
        }
    }
}
