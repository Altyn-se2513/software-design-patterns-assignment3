package channel;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class SimulatedAnswerChannel implements AnswerChannel {
    private final Deque<String> answers = new ArrayDeque<>();

    protected SimulatedAnswerChannel(String... answers) {
        for (String answer : answers) {
            this.answers.add(answer);
        }
    }

    @Override
    public String receiveAnswer(String prompt) {
        String answer = answers.isEmpty() ? "" : answers.poll();
        System.out.println("[" + getName() + "] " + prompt
                + " (" + getSimulationLabel() + ") -> " + answer);
        return answer;
    }

    @Override
    public void showMessage(String message) {
        System.out.println("[" + getName() + "] " + message);
    }

    protected abstract String getName();
    protected abstract String getSimulationLabel();
}
