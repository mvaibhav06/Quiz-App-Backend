package com.exam.rest;

import com.exam.entity.Result;
import com.exam.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
@CrossOrigin
public class ResultRestController {

    private ResultService resultService;

    @Autowired
    public ResultRestController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<Result> findAllResults(){
        return resultService.getAll();
    }

    @GetMapping("/{id}")
    public Result getResultByQuizId(@PathVariable int id){
        return resultService.getResultByQuizId(id);
    }

    @PostMapping
    public Result addResult(@RequestBody Result result){
        return resultService.save(result);
    }
}
