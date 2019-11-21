import implementation.controller.Test;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.controller.ITest;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import org.junit.jupiter.api.Assertions;


public class answer {
    /**
     * ID:  - válido
     * Input: -
     * Expected Output: question exception
     * Output: no exception throwed
     * Test result: FAILDED
     **/
    @org.junit.jupiter.api.Test
    public void TestingAnswerwithinvalidinput() {
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");

        Assertions.assertThrows(java.lang.NumberFormatException.class, () -> {
            question1.answer("string");
        });


    }
    @org.junit.jupiter.api.Test
    public void Testingwithvalidinput() {
        ITest test = new Test();
        QuestionNumeric question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");

        question1.answer("2.0");

        Assertions.assertEquals(2.0,question1.getUser_answer());

    }




}
