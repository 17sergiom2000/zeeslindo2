import implementation.controller.Test;
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
    public void TestingWithUserAwnserNull() {
        ITest test = new Test();
        QuestionYesNo question3 = new QuestionYesNo("Questao yes or no?", "1 + 3 = 4 ?");
        question3.setCorrect_answer("Yes");



          Assertions.assertThrows(QuestionException.class, question3::evaluateAnswer);




    }
}
