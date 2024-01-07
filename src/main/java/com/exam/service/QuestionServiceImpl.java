package com.exam.service;

import com.exam.dao.QuestionDAO;
import com.exam.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional
    public Question save(Question question) {
        return questionDAO.save(question);
    }

    @Override
    public List<Question> getQuestionByCategory(String category) {
        return questionDAO.getQuestionByCategory(category);
    }

    @Override
    public List<Question> getAll() {
        return questionDAO.getAll();
    }

    @Override
    public Question getQuestionById(int id) {
        return questionDAO.getQuestionById(id);
    }

    @Override
    @Transactional
    public void deleteQuestionById(int id) {
        questionDAO.deleteQuestionById(id);
    }
}
