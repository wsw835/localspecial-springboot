package com.wsw.util;

import com.wsw.entity.db.Goods;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;
import java.util.List;

public class LuceneUtil {

    /*指定存放索引目录*/
    private Directory directory;

    /*获取IndexWriter实例*/
    private IndexWriter getIndexWriter() throws Exception {
        /*创建索引在E盘下面的index目录*/
        directory = FSDirectory.open(Paths.get("E:/index"));
        /*生成中文分词器实例*/
        SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();
        /*索引分词器配置*/
        IndexWriterConfig config = new IndexWriterConfig(smartChineseAnalyzer);
        IndexWriter writer = new IndexWriter(directory, config);
        return writer;
    }

    /* 添加索引:
     * 实际开发的时候需要在新增数据那里再生成一份索引，
     * 就直接调用addIndex方法传入实体即可，
     * 再做更新、删除操作的时候也同样需要对索引做操作。*/
    public void addIndex(List<Goods> list) throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        Document document = new Document();
        /*将商品名存入索引，可以用于查询*/
        for(Goods goods:list) {
            document.add(new StringField("gid", String.valueOf(goods.getgId()), Field.Store.YES));
            document.add(new TextField("goodsName", goods.getgName(), Field.Store.YES));
        }
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    /* 更新索引*/
    public void updateIndex(Goods goods) throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        Document document = new Document();
        /*将商品名存入索引，可以用于查询*/
        document.add(new StringField("gid", String.valueOf(goods.getgId()), Field.Store.YES));
        document.add(new TextField("goodsName", goods.getgName(), Field.Store.YES));
        indexWriter.updateDocument(new Term("goodName", goods.getgName()), document);
        indexWriter.close();
    }

    /*删除指定索引*/
    public void deleteIndex(String gid) throws Exception {
        IndexWriter writer = getIndexWriter();
        writer.deleteDocuments(new Term("gid", gid));
        writer.forceMergeDeletes(); // 强制删除
        writer.commit();
        writer.close();
    }

    /* 查询关键字*/
    public List<String> searchGoods(String keyword) throws Exception {
        directory = FSDirectory.open(Paths.get("E:/index"));
        IndexReader indexReader= DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        return null;
    }

}
