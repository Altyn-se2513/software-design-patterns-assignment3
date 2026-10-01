import java.util.ArrayDeque;
import java.util.Deque;

public class WebFormInput implements InputChannel {
    private final Deque<String> answers;

    public WebFormInput(String... answers) {
        this.answers = new ArrayDeque<>();
        for (String answer : answers) {
            this.answers.add(answer);
        }
    }

    @Override
    public String receiveAnswer(String prompt) {
        String answer = answers.isEmpty() ? "" : answers.poll();
        System.out.println("[WebForm] " + prompt + " (simulated form submission) -> " + answer);
        return answer;
    }
}