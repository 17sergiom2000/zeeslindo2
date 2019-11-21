import implementation.controller.Test;
import implementation.models.Question;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.Assertions;

public class correctAnswerPecentage {


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: array with 3 questions
     * Output: array with 3 questions
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithAllanswersCorrectforQuestionNumeric(){
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        QuestionNumeric question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        QuestionNumeric question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");
        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            question1.setUser_answer(2.0);
            question2.setUser_answer(4.0);
            question3.setUser_answer(6.0);
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);
            Question[] array = {question1,question2,question3};
            Assertions.assertArrayEquals(array, test.getTestStatistics().correctAnswers() );
        } catch (TestException e) {
        }
    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: array with 3 questions
     * Output: array with 3 questions
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void testingwithDiferentTypesOfQuestions(){
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");

        String[] options = {"4","5","6","7"};
        QuestionMultipleChoice question2 = new QuestionMultipleChoice("Escolha a opcao correta", "Quanto é 3+3?",options,"6");

        QuestionYesNo question3 = new QuestionYesNo("Questao yes or no?","1 + 3 = 4 ?");

        question3.setCorrect_answer("Yes");

        try {

            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            question1.setUser_answer(2.0);
            question2.setUser_answer("6");
            question3.setUser_answer("Yes");
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);
            Question[] array = {question1,question2,question3};
            Assertions.assertArrayEquals(array, test.getTestStatistics().correctAnswers() );
        } catch (TestException e) {
        }
    }


}
