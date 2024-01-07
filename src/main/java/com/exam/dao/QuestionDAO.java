package com.exam.dao;

import com.exam.entity.Question;

import java.util.List;

public interface QuestionDAO {

    Question save(Question question);

    List<Question> getQuestionByCategory(String category);

    List<Question> getAll();

    Question getQuestionById(int id);

    void deleteQuestionById(int id);
}
