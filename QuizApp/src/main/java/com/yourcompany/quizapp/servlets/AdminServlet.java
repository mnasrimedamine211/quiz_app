package com.yourcompany.quizapp.servlets;

import com.yourcompany.quizapp.dao.QuizDao;
import com.yourcompany.quizapp.model.Quiz;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private QuizDao quizDao = new QuizDao();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Example: Create a new quiz
        String quizData = request.getParameter("quiz");
        Quiz quiz = gson.fromJson(quizData, Quiz.class);
        quizDao.addQuiz(quiz);
        response.getWriter().write("Quiz added successfully");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Example: Display all quizzes (or other admin functionalities)
        response.getWriter().write("Admin functionalities here");
    }
}
