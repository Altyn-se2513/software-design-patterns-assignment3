package quiz;

import channel.AnswerChannel;

public class OpenEndedQuiz extends Quiz {
    private final String taskDescription;

    public OpenEndedQuiz(String taskDescription, AnswerChannel answerChannel) {
        super(answerChannel);
        this.taskDescription = taskDescription;
    }

    @Override
    protected String getHeader() {
        return "Open-Ended Assessment";
    }

    @Override
    protected String getPrompt() {
        return taskDescription;
    }

    @Override
    protected String evaluate(String answer) {
        return "Result: Answer received (" + answer.length() + " chars).";
    }
}