package com.wsw.util;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author wensw
 */
public class XmlParseUtil {

    /**
     * 解析xml字符成文档对象.
     * @param xmlStr xml字符.
     * @param charset 字符编码.
     * @return
     */
    public static Document parseDoc(String xmlStr, String charset) {
        ByteArrayInputStream bi = null;
        try {
            bi = new ByteArrayInputStream(xmlStr.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            System.out.println("系统不支持" + charset + "的字符编码：" + e.getMessage());
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bi);
        } catch (SAXException e) {
            System.out.println("SAXException出错：" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取输入流出错：" + e.getMessage());
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("解析xml字符出现验证的错误：" + e.getMessage());
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 根据节点名称获取该节点的第一个值.
     * @param doc 文档对象.
     * @param tagName 节点名称.
     * @return
     */
    public static String getValueByTagName(Document doc, String tagName) {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        Node node = null;
        if (nodeList != null) {
            node = nodeList.item(0);
        }
        if (node == null) {
            return "";
        } else {
            return node.getTextContent();
        }
    }

    /**
     * 将xml字符解析成Key-Value的形式,保存至Map对象.
     * @param xmlStr xml字符.
     * @param charset 字符编码.
     * @return
     */
    public static Map<String, String> parseXmlToMap(String xmlStr, String charset) {
        Document doc = parseDoc(xmlStr, charset);
        return parseDocumentToMap(doc, charset);
    }

    /**
     * 将文档对象解析成Key-Value的形式,保存至Map对象.
     * @param doc 文档对象
     * @param charset 字符编码.
     * @return
     */
    private static Map<String, String> parseDocumentToMap(Document doc, String charset) {
        doc.normalize();
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        return parseNodeListToMap(nodeList, charset);
    }

    /**
     * 将节点列表解析成Key-Value的形式,保存至Map对象.
     * @param nodeList 节点列表.
     * @param charset 字符编码.
     * @return
     */
    private static Map<String, String> parseNodeListToMap(NodeList nodeList, String charset) {
        Map<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            hashMap.put(node.getNodeName(), StringUtils.trim(node.getTextContent()));
        }
        return hashMap;
    }

    public static NodeList getNodeListByTagName(Document doc, String tagName) {
        return doc.getElementsByTagName(tagName);
    }

    /**
     * 将节点列表解析成Key-Value的形式,保存至Map对象.
     * @param nodeList 节点列表.
     * @param charset 字符编码.
     * @return
     */
    public static Map<String, Object> parseNodeListToList(NodeList nodeList, String charset) {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            hashMap.put(node.getNodeName() + i, StringUtils.trim(node.getTextContent()));
        }
        return hashMap;
    }

}
