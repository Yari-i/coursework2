package pro.sky.coursework2.examQuestion.serviceImpl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examQuestion.exception.NotEnoughQuestionsException;
import pro.sky.coursework2.examQuestion.model.Question;
import pro.sky.coursework2.examQuestion.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void correctlyGetRandomQuestions() {

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(new Question("question" + i, "answer" + i));

        }


        when(questionService.getAll()).thenReturn(questions);

        when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0), questions.get(0),
                questions.get(1), questions.get(1),
                questions.get(1), questions.get(2)
        );


        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        assertEquals(randomQuestions.size(), amount);
        assertTrue(randomQuestions.containsAll(questions));

        verify(questionService, times(6)).getRandomQuestion();
    }

    @Test
    void correctlyThrowNotEnoughQuestionsException() {

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount / 2; i++) {
            questions.add(new Question("question" + i, "answer" + i));

        }

        when(questionService.getAll()).thenReturn(questions);


        assertThrows(
                NotEnoughQuestionsException.class,
                () -> examinerService.getQuestions(amount)

        );
    }
}