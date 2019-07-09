package com.learn.springmongo.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class CustomMongoConfig {


    private CustomMongoConfig(){}

    private static CustomMongoConfig config = null;

    public static CustomMongoConfig getMongoInstance(){
        if(config == null){
            config = new CustomMongoConfig();
        }
        return config;
    }

    public MongoDatabase getMongoDatabase(){

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient client = new MongoClient("localhost",27017);
        return client.getDatabase("book-store").withCodecRegistry(pojoCodecRegistry);
    }
}
