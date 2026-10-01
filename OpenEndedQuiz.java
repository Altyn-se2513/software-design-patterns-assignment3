public class OpenEndedQuiz extends Quiz {
    private final String taskDescription;

    public OpenEndedQuiz(String taskDescription, InputChannel inputChannel) {
        super(inputChannel);
        this.taskDescription = taskDescription;
    }

    @Override
    public void startQuiz() {
        System.out.println("\nOpen-Ended Assessment");
        String userAnswer = ask(taskDescription);
        int length = (userAnswer != null) ? userAnswer.length() : 0;
        System.out.println("Result: Answer saved successfully (" + length + " chars). Sent to review.");
    }
}