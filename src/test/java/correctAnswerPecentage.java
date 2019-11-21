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
     * Expected Output: 1
     * Output: 0
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithAllQuestionCorrect(){
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        QuestionNumeric question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        QuestionNumeric question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");
        QuestionNumeric question4 = new QuestionNumeric(8.0, "Questão-3", "Quanto é 4+4?");
        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            test.addQuestion(question4);
            question1.setUser_answer(2.0); //certa
            question2.setUser_answer(4.0); //certa
            question3.setUser_answer(6.0); // certa
            question4.setUser_answer(8.0); //certa
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);
            question4.setDone(true);
            System.out.println(test.getTestStatistics().correctAnswer());

            Assertions.assertEquals(1.0,test.getTestStatistics().correctAnswerPecentage());
        } catch (TestException e) {
        }
    }


    /**
     * ID:  - válido
     * Input: -
     * Expected Output: 0
     * Output: 0
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithAllTheQuestionInCorrect(){
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        QuestionNumeric question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        QuestionNumeric question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");
        QuestionNumeric question4 = new QuestionNumeric(8.0, "Questão-3", "Quanto é 4+4?");
        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            test.addQuestion(question4);
            question1.setUser_answer(1.0); //errada
            question2.setUser_answer(2.0); //errada
            question3.setUser_answer(4.0); // errada
            question4.setUser_answer(9.0); //errada
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);
            question4.setDone(true);
            System.out.println(test.getTestStatistics().correctAnswer());

            Assertions.assertEquals(0,test.getTestStatistics().correctAnswerPecentage());
        } catch (TestException e) {
        }
    }

    /**
     * ID:  - válido
     * Input: -
     * Expected Output: 0.5
     * Output: 0.5
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void TestingWithAllHalfofTheQuestionCorrect(){
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        QuestionNumeric question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        QuestionNumeric question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");
        QuestionNumeric question4 = new QuestionNumeric(8.0, "Questão-3", "Quanto é 4+4?");
        try {
            test.addQuestion(question1);
            test.addQuestion(question2);
            test.addQuestion(question3);
            test.addQuestion(question4);
            question1.setUser_answer(1.0); //errada
            question2.setUser_answer(4.0); //certa
            question3.setUser_answer(4.0); // errada
            question4.setUser_answer(8.0); //certa
            question1.setDone(true);
            question2.setDone(true);
            question3.setDone(true);
            question4.setDone(true);
            System.out.println(test.getTestStatistics().correctAnswer());

            Assertions.assertEquals(0.5,test.getTestStatistics().correctAnswerPecentage());
        } catch (TestException e) {
        }
    }





}
