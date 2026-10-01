public abstract class Quiz {
    private InputChannel inputChannel;

    protected Quiz(InputChannel inputChannel) {
        this.inputChannel = inputChannel;
    }

    public void setInputChannel(InputChannel inputChannel) {
        this.inputChannel = inputChannel;
    }

    protected String ask(String prompt) {
        return inputChannel.receiveAnswer(prompt);
    }

    public abstract void startQuiz();
}