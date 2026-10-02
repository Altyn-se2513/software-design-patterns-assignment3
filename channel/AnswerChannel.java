package channel;

public interface AnswerChannel {
    String receiveAnswer(String prompt);
    void showMessage(String message);
}
