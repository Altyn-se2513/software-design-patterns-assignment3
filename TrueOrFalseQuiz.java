public class TrueOrFalseQuiz extends Quiz {
    private final String statement;
    private final boolean expectedValue;

    public TrueOrFalseQuiz(String statement, boolean expectedValue, InputChannel inputChannel) {
        super(inputChannel);
        this.statement = statement;
        this.expectedValue = expectedValue;
    }

    @Override
    public void startQuiz() {
        System.out.println("\n--- True or False Quiz ---");
        String userAnswer = ask(statement + " (True/False)");
        Boolean parsed = parseBoolean(userAnswer);
        if (parsed == null) {
            System.out.println("Result: Invalid input. Please answer True or False.");
            return;
        }
        if (parsed == expectedValue) {
            System.out.println("Result: Spot on!");
        } else {
            System.out.println("Result: Oops, wrong.");
        }
    }

    private Boolean parseBoolean(String answer) {
        if (answer == null) return null;
        if (answer.equalsIgnoreCase("true")) return true;
        if (answer.equalsIgnoreCase("false")) return false;
        return null;
    }
}