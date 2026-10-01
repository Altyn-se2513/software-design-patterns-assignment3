import java.util.ArrayDeque;
import java.util.Deque;

public class VoiceAssistantInput implements InputChannel {
    private final Deque<String> answers;

    public VoiceAssistantInput(String... answers) {
        this.answers = new ArrayDeque<>();
        for (String answer : answers) {
            this.answers.add(answer);
        }
    }

    @Override
    public String receiveAnswer(String prompt) {
        String answer = answers.isEmpty() ? "" : answers.poll();
        System.out.println("[VoiceAI] " + prompt + " (simulated voice recognition) -> " + answer);
        return answer;
    }
}