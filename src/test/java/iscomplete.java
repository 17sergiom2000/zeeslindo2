import implementation.controller.Test;
import implementation.models.Question;
import implementation.models.QuestionNumeric;
import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.Assertions;


public class iscomplete {



    /**
     * ID:  - válido
     * Input: -
     * Expected Output:false
     * Output: false
     * Test result: PASSED
     **/
     @org.junit.jupiter.api.Test
    public void GivingAnTestWithOnly1DoneQuestion(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        Question question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        Question question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");

        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            question1.setDone(true);
            question2.setDone(true);


        } catch (TestException e) {
        }

        Assertions.assertFalse(test.isComplete());

    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void GivingAnTestWithAllQuestionsDone(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        Question question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        Question question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");

        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);

        } catch (TestException e) {
        }

        Assertions.assertTrue(test.isComplete());

    }

    /**
     * ID:  - válido
     * Input: -
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void GivingAnTestWihoutQquestions(){
        ITest test = new Test();

        Assertions.assertTrue(test.isComplete());

    }

    /**
     * ID:  - válido
     * Input: -
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void GivingAnTestdWiht100QquestionsDone(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");


        try {
            for (int i = 0; i <= 99; i++) {
                test.addQuestion(question1);
            }
            question1.setDone(true);

        } catch (TestException e) {
        }

        Assertions.assertTrue(test.isComplete());

    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output:false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void GivingAnTestdWiht100QquestionsNotDone(){
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");


        try {
            for (int i = 0; i <= 99; i++) {
                test.addQuestion(question1);
            }
            question1.setDone(false);

        } catch (TestException e) {
        }

        Assertions.assertFalse(test.isComplete());

    }








}
