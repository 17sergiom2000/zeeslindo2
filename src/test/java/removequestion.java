import implementation.controller.Test;
import implementation.models.Question;
import implementation.models.QuestionNumeric;
import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.Assertions;

public class removequestion {

    /**
     * ID: RMP01 - Remover uma pergunta a um teste vazio(BLB) - válido
     * Input: 0
     * Expected Output: false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromEmptyTestShouldReturnFalse() {
        ITest test = new Test();

        Assertions.assertFalse(test.removeQuestion(0));

    }


    /**
     * ID: RMP03. Remover pergunta na posição -1(LB) - inválido
     * Input: -1
     * Expected Output: ArrayIndexOutOfBoundsException
     * Output: ArrayIndexOutOfBoundsException
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromNegativePositionShouldThrowAnException() {
        ITest test = new Test();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            test.removeQuestion(-1);
        });


    }


    /**
     * ID: RMP04. Remover pergunta na posição 0(ALB) - válido
     * Input: 0
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromPosition0ShouldReturnTrue() {
        ITest test = new Test();
        Question question = new QuestionNumeric(2.0, "Questão", "Quanto é 1+1");

        try {
            test.addQuestion(question);

        } catch (TestException e) {
        }

        Assertions.assertTrue(test.removeQuestion(0));

    }


    /**
     * ID: RMP05. Remover pergunta na posição 1(ALB) -válido
     * Input: 1
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionInPosition1ShouldReturnTrue() {
        ITest test = new Test();
        Question question = new QuestionNumeric(2.0, "Questão", "Quanto é 1+1");

        try {
            test.addQuestion(question);
            test.addQuestion(question);
        } catch (TestException e) {
        }

        Assertions.assertTrue(test.removeQuestion(1));

    }


    /**
     * ID: RMP06. Remover pergunta na posição 99(BUB) -válido
     * Input: 99
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromPosition99ShouldReturnTrue() {
        ITest test = new Test();
        Question question = new QuestionNumeric(2.0, "Questão", "Quanto é 1+1");

        try {
            for (int i = 0; i <= 99; i++) {
                test.addQuestion(question);
            }
        } catch (TestException e) {
        }
        Assertions.assertTrue(test.removeQuestion(99));
    }


    /**
     * ID: RMP07. Remover pergunta na posição 100(BUB) -inválido
     * Input: 100
     * Expected Output:ArrayIndexOutOfBoundsException
     * Output: ArrayIndexOutOfBoundsException
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromPosition100ShouldThrowAnException() {
        ITest test = new Test();


        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            test.removeQuestion(100);
        });


    }


    /**
     * ID: RMP08. Remover pergunta na posição 101(AUB) -inválido
     * Input: 101
     * Expected Output:ArrayIndexOutOfBoundsException
     * Output: ArrayIndexOutOfBoundsException
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromPosition101ShouldThrowAnException() {
        ITest test = new Test();


        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            test.removeQuestion(101);
        });


    }

    /**
     * ID: RMP09. Remover pergunta na posição 103(UB) -inválido
     * Input: 103
     * Expected Output:ArrayIndexOutOfBoundsException
     * Output: ArrayIndexOutOfBoundsException
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveQuestionFromPosition103ShouldThrowAnException() {
        ITest test = new Test();


        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            test.removeQuestion(101);
        });


    }


    /**
     * ID:RMP10. Remove pergunta nula pela posição -inválido
     * Input: 55
     * Expected Output:false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveNullQuestionShouldReturnFalse() {
        ITest test = new Test();
        Question question = new QuestionNumeric(2.0, "Questão", "Quanto é 1+1");
        try {
            test.addQuestion(question);
            test.addQuestion(question);
        } catch (TestException e) {
        }

        Assertions.assertFalse(test.removeQuestion(55));

    }


    /**
     * ID: RMP11. Remove pergunta que existe via referência -válido
     * Input: question2
     * Expected Output:true
     * Output: true
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveExistingQuestionByReferenceShouldReturnTrue() {
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

        Assertions.assertTrue(test.removeQuestion(question2));

    }


    /**
     * ID: RMP12. Remove pergunta que não existe via referência. -inválido
     * Input: question3
     * Expected Output:false
     * Output: false
     * Test result: PASSED
     **/
    @org.junit.jupiter.api.Test
    public void RemoveNonExistingQuestionByReferenceShouldReturnTrue() { // teste valido
        ITest test = new Test();
        Question question1 = new QuestionNumeric(2.0, "Questão-1", "Quanto é 1+1?");
        Question question2 = new QuestionNumeric(4.0, "Questão-2", "Quanto é 2+2?");
        Question question3 = new QuestionNumeric(6.0, "Questão-3", "Quanto é 3+3?");

        try {

            test.addQuestion(question1);
            test.addQuestion(question2);


        } catch (TestException e) {
        }

        Assertions.assertFalse(test.removeQuestion(question3));

    }

}
