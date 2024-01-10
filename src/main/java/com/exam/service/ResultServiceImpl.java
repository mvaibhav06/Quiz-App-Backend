package com.exam.service;

import com.exam.dao.ResultDAO;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{

    private ResultDAO resultDAO;

    @Autowired
    public ResultServiceImpl(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    @Transactional
    public Result save(Result result) {
        return resultDAO.save(result);
    }

    @Override
    public List<Result> getAll() {
        return resultDAO.findAll();
    }

    @Override
    public Result getResultById(int id) {
        return resultDAO.findById(id).orElseThrow(() -> new RuntimeException("Result not found for the given Quiz"));
    }

    @Override
    public Result getResultByQuizId(int id) {
        return resultDAO.findByQuizId(id);
    }

    @Override
    @Transactional
    public void deleteResultById(int id) {
        resultDAO.deleteById(id);
    }
}
