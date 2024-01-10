package com.exam.service;

import com.exam.entity.Question;
import com.exam.entity.Result;

import java.util.List;

public interface ResultService {

    Result save(Result result);

    List<Result> getAll();

    Result getResultById(int id);

    Result getResultByQuizId(int id);

    void deleteResultById(int id);
}
