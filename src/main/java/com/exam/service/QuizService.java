package com.exam.service;

import com.exam.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    void save(Quiz quiz);

    List<Quiz> getAll();

    Quiz getQuizById(int id);

    void deleteQuizById(int id);

    Quiz createQuiz(String category);
}
