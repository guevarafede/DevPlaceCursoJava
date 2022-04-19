package org.example;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class Connect {
    private String dbName;
    private  MongoClient mongoClient;
    private List<Document> database;

    public Connect(String db){

        mongoClient = MongoClients.create();
        database = mongoClient.listDatabases().into(new ArrayList<Document>());
        //	database.forEach(db-> System.out.println(db.toJson()));
        dbName = db;

    }

    public  MongoDatabase getDb()
    {
        return mongoClient.getDatabase(dbName);
    }

}
