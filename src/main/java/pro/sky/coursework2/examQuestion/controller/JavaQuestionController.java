package pro.sky.coursework2.examQuestion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.examQuestion.model.Question;
import pro.sky.coursework2.examQuestion.service.QuestionService;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public void add(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam String question, @RequestParam String answer) {
        questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
