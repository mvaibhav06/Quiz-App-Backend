package com.exam.dao;

import com.exam.entity.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class QuizDAOImpl implements QuizDAO{

    private EntityManager entityManager;

    @Autowired
    public QuizDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Quiz save(Quiz quiz) {
        return entityManager.merge(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        TypedQuery<Quiz> query = entityManager.createQuery("from Quiz", Quiz.class);
        return query.getResultList();
    }

    @Override
    public Quiz getQuizById(int id) {
        return entityManager.find(Quiz.class, id);
    }

    @Override
    public void deleteQuizById(int id) {
        Quiz quiz = entityManager.find(Quiz.class, id);
        entityManager.remove(quiz);
    }



}
