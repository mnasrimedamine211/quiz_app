package com.yourcompany.quizapp.servlets;

import com.google.gson.Gson;
import com.yourcompany.quizapp.dao.QuizDao;
import com.yourcompany.quizapp.model.Quiz;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private QuizDao quizDao = new QuizDao();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        // Assume JSON string of questions is sent in request
        String questionsJson = request.getParameter("questions");
        Quiz quiz = gson.fromJson(questionsJson, Quiz.class);
        quiz.setTitle(title);
        quizDao.addQuiz(quiz);
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(quiz));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Quiz quiz = quizDao.findQuizById(id);
        String quizJson = gson.toJson(quiz);
        response.setContentType("application/json");
        response.getWriter().write(quizJson);
    }
}
