package com.m.baf.jdbc;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSONSerializers;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDbConnector {

    public static void main(String[] args) {
        try {

            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            createCollection(mongoDatabase);

            MongoCollection<Document> collection = getCollection(mongoDatabase);

            doInsert(collection);

        }catch (Exception e){
            System.err.println(e.getClass().getName()+":"+e.getMessage());
        }
    }

    /**
     * 创建集合
     * @param mongoDatabase
     */
    public static void createCollection(MongoDatabase mongoDatabase){
        mongoDatabase.createCollection("newCollection");
    }


    /**
     * 获取集合
     * @param mongoDatabase
     * @return
     */
    public static MongoCollection<Document> getCollection(MongoDatabase mongoDatabase){
       return mongoDatabase.getCollection("newColelction");
    }

    /**
     * 插入文档
     * @param collection
     */
    public static void doInsert(MongoCollection<Document> collection){
        Document document = new Document("title","MongoDB")
                .append("description","database")
                .append("likes",100)
                .append("by","Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("文档插入成功");
    }
}
