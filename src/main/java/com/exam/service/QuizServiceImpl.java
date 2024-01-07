package com.exam.service;

import com.exam.dao.QuestionDAO;
import com.exam.dao.QuizDAO;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizDAO quizDAO;
    private QuestionDAO questionDAO;

    @Autowired
    public QuizServiceImpl(QuizDAO quizDAO, QuestionDAO questionDAO) {
        this.quizDAO = quizDAO;
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional
    public void save(Quiz quiz) {
         quizDAO.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return quizDAO.getAll();
    }

    @Override
    public Quiz getQuizById(int id) {
        return quizDAO.getQuizById(id);
    }

    @Override
    @Transactional
    public void deleteQuizById(int id) {
        quizDAO.deleteQuizById(id);
    }

    @Override
    @Transactional
    public Quiz createQuiz(String category) {
        Quiz quiz = new Quiz(category, new Date());
        List<Question> questions = questionDAO.getQuestionByCategory(category);
        quiz.setQuestions(questions);
        Quiz dbQuiz = quizDAO.save(quiz);

        return dbQuiz;
    }
}
