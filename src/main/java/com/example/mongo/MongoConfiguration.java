package com.example.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.data.mongodb.core.ReactiveMongoClientFactoryBean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

//@Configuration
public class MongoConfiguration {

//    @Bean or
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://containerHostName:27017");
    }

//    @Bean or
    ReactiveMongoClientFactoryBean clientFactoryBean() throws Exception {
        ReactiveMongoClientFactoryBean bean = new ReactiveMongoClientFactoryBean();
        ConnectionString cs = new ConnectionString("");
        bean.setConnectionString("mongodb://containerHostName:27017");
        MongoClient client = bean.getObject();
        client.listDatabaseNames();
        return bean;
    }

//    @Bean or
    MongoClientSettingsBuilderCustomizer builderCustomizer(@Value("${spring.data.mongodb.uri1}") String url) {
        return set -> set.applyConnectionString(new ConnectionString(url));
    }

    ReactiveMongoOperations mongoTemplate(MongoClient client) {
        return new ReactiveMongoTemplate(mongoClient(), "dbName");
    }
}
