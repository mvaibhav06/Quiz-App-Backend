package com.exam.dao;

import com.exam.entity.Quiz;

import java.util.List;

public interface QuizDAO {
    Quiz save(Quiz quiz);

    List<Quiz> getAll();

    Quiz getQuizById(int id);

    void deleteQuizById(int id);

}
