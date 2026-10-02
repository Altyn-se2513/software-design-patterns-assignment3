package channel;

public class WebFormAnswerChannel extends SimulatedAnswerChannel {
    public WebFormAnswerChannel(String... answers) {
        super(answers);
    }

    @Override
    protected String getName() {
        return "WebForm";
    }

    @Override
    protected String getSimulationLabel() {
        return "simulated form submission";
    }
}
