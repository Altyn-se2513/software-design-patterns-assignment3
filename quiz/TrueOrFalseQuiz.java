package quiz;

import channel.AnswerChannel;

public class TrueOrFalseQuiz extends Quiz {
    private final String statement;
    private final boolean expectedValue;

    public TrueOrFalseQuiz(String statement, boolean expectedValue, AnswerChannel answerChannel) {
        super(answerChannel);
        this.statement = statement;
        this.expectedValue = expectedValue;
    }

    @Override
    protected String getHeader() {
        return "True or False Quiz";
    }

    @Override
    protected String getPrompt() {
        return statement + " (True/False)";
    }

    @Override
    protected String evaluate(String answer) {
        Answer parsed = parseAnswer(answer);
        if (parsed == Answer.UNKNOWN) {
            return "Result: Invalid input. Please answer True or False.";
        }
        boolean userValue = (parsed == Answer.TRUE);
        return (userValue == expectedValue) ? "Result: Spot on!" : "Result: Oops, wrong.";
    }

    private Answer parseAnswer(String answer) {
        if (answer.isBlank()) { 
            return Answer.UNKNOWN;
        }
        if (answer.equalsIgnoreCase("true")) {
            return Answer.TRUE;
        }
        if (answer.equalsIgnoreCase("false")) {
            return Answer.FALSE;
        }
        return Answer.UNKNOWN;
    }

    private enum Answer {
        TRUE, FALSE, UNKNOWN
    }
}
