package com.yourcompany.quizapp.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.yourcompany.quizapp.model.Quiz;
import org.bson.types.ObjectId;

public class QuizDao {
    private final MongoCollection<Quiz> quizzes;

    public QuizDao() {
        MongoDatabase db = MongoUtil.getDB();
        quizzes = db.getCollection("quizzes", Quiz.class);
    }

    public void addQuiz(Quiz quiz) {
        quizzes.insertOne(quiz);
    }

    public Quiz findQuizById(String id) {
        return quizzes.find(Filters.eq("_id", new ObjectId(id))).first();
    }
}
