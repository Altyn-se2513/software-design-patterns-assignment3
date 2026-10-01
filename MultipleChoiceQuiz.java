public class MultipleChoiceQuiz extends Quiz {
    private final String question;
    private final String correctAnswer;

    public MultipleChoiceQuiz(String question, String correctAnswer, InputChannel inputChannel) {
        super(inputChannel);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void startQuiz() {
        System.out.println("\nMultiple Choice Quiz");
        String userAnswer = ask(question);
        if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Result: Correct!");
        } else {
            System.out.println("Result: Incorrect. The correct answer was: " + correctAnswer);
        }
    }
}