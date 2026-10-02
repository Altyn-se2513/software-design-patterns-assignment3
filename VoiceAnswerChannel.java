package channel;

public class VoiceAnswerChannel extends SimulatedAnswerChannel {
    public VoiceAnswerChannel(String... answers) {
        super(answers);
    }

    @Override
    protected String getName() {
        return "VoiceAI";
    }

    @Override
    protected String getSimulationLabel() {
        return "simulated voice recognition";
    }
}