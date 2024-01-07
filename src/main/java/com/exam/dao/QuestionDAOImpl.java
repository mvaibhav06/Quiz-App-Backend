package com.exam.dao;

import com.exam.entity.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO{

    private EntityManager entityManager;

    @Autowired
    public QuestionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Question save(Question question) {
        return entityManager.merge(question);
    }

    @Override
    public List<Question> getQuestionByCategory(String category) {
        TypedQuery<Question> query = entityManager.createQuery("from Question where category=:data", Question.class);

        if (category.equals("java")){
            query.setParameter("data","Java Programming");
        } else if (category.equals("string")) {
            query.setParameter("data","String Handling");
        } else if (category.equals("python")) {
            query.setParameter("data","Python Programming");
        }
        else{
            query.setParameter("data", "Current Affairs");
        }
        return query.getResultList();
    }

    @Override
    public List<Question> getAll() {
        TypedQuery<Question> query = entityManager.createQuery("from Question", Question.class);

        return query.getResultList();
    }

    @Override
    public Question getQuestionById(int id) {
        TypedQuery<Question> query = entityManager.createQuery("from Question where id=:data", Question.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public void deleteQuestionById(int id) {
        Question question = entityManager.find(Question.class, id);
        entityManager.remove(question);
    }

}
