package com.exam.rest;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin
public class QuizRestController {

    private QuestionService questionService;
    private QuizService quizService;

    @Autowired
    public QuizRestController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @GetMapping("/create")
    public Quiz getQuestionsForQuiz(@RequestParam String category){

        return quizService.createQuiz(category);
    }

    @GetMapping("/")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getQuizbyId(@PathVariable int id){
        return quizService.getQuizById(id);
    }
}
