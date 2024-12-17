package pro.sky.coursework2.examQuestion.serviceImpl;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.examQuestion.model.Question;
import pro.sky.coursework2.examQuestion.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private final QuestionService questionService = new JavaQuestionServiceImpl();

    @Test
    void correctlyAdd() {

        Question expectedQuestion = new Question("question", "answer");

        Question actualQuestion = questionService.add(expectedQuestion);

        assertEquals(expectedQuestion, actualQuestion);

    }

    @Test
    void testAdd() {
        Question expectedQuestion = new Question("question", "answer");

        Question actualQuestion = questionService.add(expectedQuestion);

        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void correctlyRemove() {
        Question expectedQuestion = new Question("question", "answer");

        questionService.add(expectedQuestion);

        Question actualQuestion = questionService.remove(expectedQuestion);

        assertEquals(expectedQuestion, actualQuestion);

    }

    @Test
    void correctlyGetAll() {
        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question", "answer");


        questionService.add(question1);
        questionService.add(question2);


        Set<Question> expectedQuestion = new HashSet<>() {{
            add(question1);
            add(question2);
        }};


        Collection<Question> actualCollections = questionService.getAll();

        assertEquals(expectedQuestion, actualCollections);


    }

    @Test
    void correctlyGetRandomQuestion() {

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question", "answer");
        Question question3 = new Question("question", "answer");

        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        Set<Question> questions = new HashSet<>() {{
            add(question1);
            add(question2);
            add(question3);
        }};
        Question randomQuestion = questionService.getRandomQuestion();

        assertTrue(questions.contains(randomQuestion));

    }

    @Test
    void uniqueQuestionAndAnswer() {

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("q", "a");

        questionService.add(question1);
        questionService.add(question2);

        assertNotEquals(question1, question2);


    }
}