package com.exam.dao;

import com.exam.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDAO extends JpaRepository<Result, Integer> {

    Result findByQuizId(int id);
}
