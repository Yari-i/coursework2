package pro.sky.coursework2.examQuestion.service;

import pro.sky.coursework2.examQuestion.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
