package com.exam.rest;

import com.exam.entity.Question;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionRestController {

    private QuestionService questionService;

    @Autowired
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/questions/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @GetMapping("/questions/id/{id}")
    public Question getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question){
        question.setId(0);
        return questionService.save(question);
    }

    @PutMapping("/questions")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.save(question);
    }

    @DeleteMapping("/questions/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionService.deleteQuestionById(id);

        return "Question deleted...";
    }
}
