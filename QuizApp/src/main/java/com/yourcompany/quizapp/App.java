package com.yourcompany.quizapp;

import com.yourcompany.quizapp.util.MongoUtil;
import com.mongodb.client.MongoDatabase;

public class App {
    public static void main(String[] args) {
        System.out.println("Running database connectivity test...");

        try {
            MongoDatabase db = MongoUtil.getDB();
            System.out.println("Connected to MongoDB: " + db.getName());
            // Additional checks or operations can be added here
        } catch (Exception e) {
            System.out.println("Failed to connect to MongoDB: " + e.getMessage());
        }
    }
}
