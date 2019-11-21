import implementation.controller.Test;
import implementation.models.Question;
import implementation.models.QuestionNumeric;
import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.Assertions;


public class numberQuestions {

    /**
     * ID:  - válido
     * Input: -
     * Expected Output:3
     * Output: 3
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void CountingTheNumberOfQuestionsShouldReturn3(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        Question question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        Question question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");

        try {

            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);

        } catch (TestException e) {
        }

        Assertions.assertEquals(3,test.numberQuestions());

    }

    /**
     * ID:  - válido
     * Input: -
     * Expected Output:2
     * Output: 2
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void CountingTheNumberOfQuestionsShouldReturn2(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        Question question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        Question question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");

        try {

            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            test.removeQuestion(question2);

        } catch (TestException e) {
        }


        Assertions.assertEquals(2,test.numberQuestions());

    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output:0
     * Output: 0
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void CountingTheNumberOfQuestionsShouldReturn0(){
        ITest test = new Test();
        Assertions.assertEquals(0,test.numberQuestions());
    }

    /**
     * ID:  - válido
     * Input: -
     * Expected Output:100
     * Output: 100
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void CountingTheNumberOfQuestionsShouldReturn100(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");


        try {

            for (int i = 0; i <= 99; i++) {
                test.addQuestion(question1);
            }

        } catch (TestException e) {
        }


        Assertions.assertEquals(100,test.numberQuestions());

    }




}
