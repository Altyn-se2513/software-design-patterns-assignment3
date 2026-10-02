package quiz;

import channel.AnswerChannel;

public class MultipleChoiceQuiz extends Quiz {
    private final String question;
    private final String correctAnswer;

    public MultipleChoiceQuiz(String question, String correctAnswer, AnswerChannel answerChannel) {
        super(answerChannel);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    protected String getHeader() {
        return "Multiple Choice Quiz";
    }

    @Override
    protected String getPrompt() {
        return question;
    }

    @Override
    protected String evaluate(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return "Result: Correct!";
        }
        return "Result: Incorrect. The correct answer was: " + correctAnswer;
    }
}