package pro.sky.coursework2.examQuestion.serviceImpl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.examQuestion.exception.NotEnoughQuestionsException;
import pro.sky.coursework2.examQuestion.model.Question;
import pro.sky.coursework2.examQuestion.service.ExaminerService;
import pro.sky.coursework2.examQuestion.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException("Запрошено слишком много вопросов");

        }

        Set<Question> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }

        return randomQuestions;

    }
}
