package com.pascher.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    public static MongoDatabase getDBConnection(final String dbName){
    	// Since 2.10.0, uses MongoClient
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        return mongo.getDatabase(dbName);
    }
}
