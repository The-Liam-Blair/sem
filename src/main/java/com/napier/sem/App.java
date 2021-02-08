package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        // Connect to MongoDb locally on port 27000
        MongoClient mongoClient = new MongoClient("mongo-dbserver");

        // Init database
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Retrieve MongoDb collection
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a stored document
        Document doc = new Document("name", "Liam Blair")
            .append("class", "Software Engineering Methods")
            .append("year", "2012")
            .append("result", new Document("CW", 95).append("EX", 85));

        // Document added to the collection
        collection.insertOne(doc);

        // Check for document in the collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
