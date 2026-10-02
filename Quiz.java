package quiz;

import channel.AnswerChannel;
import java.util.Objects;

public abstract class Quiz {
    private AnswerChannel answerChannel;

    protected Quiz(AnswerChannel answerChannel) {
        this.answerChannel = Objects.requireNonNull(answerChannel, "answerChannel must not be null");
    }

    public final void startQuiz() {
        display(getHeader());
        String answer = ask(getPrompt());
        display(evaluate(answer));
    }

    public void setAnswerChannel(AnswerChannel answerChannel) {
        this.answerChannel = Objects.requireNonNull(answerChannel, "answerChannel must not be null");
    }

    protected String ask(String prompt) {
        String raw = answerChannel.receiveAnswer(prompt);
        return raw == null ? "" : raw.trim(); 
    }

    protected void display(String message) {
        answerChannel.showMessage(message);
    }

    protected abstract String getHeader();
    protected abstract String getPrompt();
    protected abstract String evaluate(String answer);
}