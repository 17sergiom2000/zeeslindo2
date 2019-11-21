import implementation.controller.Test;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.controller.ITest;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import org.junit.jupiter.api.Assertions;

public class evaluateAnswer {

    /**
     * ID:  - válido
     * Input: -
     * Expected Output: question exception
     * Output: no exception throwed
     * Test result: FAILDED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerNull() {
        ITest test = new Test();
        QuestionYesNo question3 = new QuestionYesNo("Questao yes or no?", "1 + 3 = 4 ?");
        question3.setCorrect_answer("Yes");

          Assertions.assertThrows(QuestionException.class, question3::evaluateAnswer);

    }
    /**
     * ID:  - válido
     * Input: -
     * Expected Output: true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerCorrectYesOrNo() {
        ITest test = new Test();
        QuestionYesNo question3 = new QuestionYesNo("Questao yes or no?", "1 + 3 = 4 ?");
        question3.setCorrect_answer("Yes");


        question3.setUser_answer("Yes");


        Assertions.assertTrue(question3.evaluateAnswer());





    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerCorrectNumeric() {
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");



        question1.setUser_answer(2.0);


        Assertions.assertTrue(question1.evaluateAnswer());
    }



    /**
     * ID:  - válido
     * Input: -
     * Expected Output: true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerCorrect() {
        ITest test = new Test();
        String[] options = {"4","5","6","7"};
        QuestionMultipleChoice question2 = new QuestionMultipleChoice("Escolha a opcao correta", "Quanto é 3+3?",options,"6");



        question2.setUser_answer("6");


        Assertions.assertTrue(question2.evaluateAnswer());
    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerInCorrectYesOrNo() {
        ITest test = new Test();
        QuestionYesNo question3 = new QuestionYesNo("Questao yes or no?", "1 + 3 = 4 ?");
        question3.setCorrect_answer("Yes");


        question3.setUser_answer("No");


        Assertions.assertFalse(question3.evaluateAnswer());





    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerInCorrectNumeric() {
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");



        question1.setUser_answer(3.0);


        Assertions.assertFalse(question1.evaluateAnswer());
    }



    /**
     * ID:  - válido
     * Input: -
     * Expected Output: false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithUserAnswerInCorrect() {
        ITest test = new Test();
        String[] options = {"4","5","6","7"};
        QuestionMultipleChoice question2 = new QuestionMultipleChoice("Escolha a opcao correta", "Quanto é 3+3?",options,"6");



        question2.setUser_answer("7");


        Assertions.assertFalse(question2.evaluateAnswer());
    }

}
