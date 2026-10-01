public class Main {
    public static void main(String[] args) {
        InputChannel consoleTerminal = new ConsoleInputTerminal();

        InputChannel webFormForMcq = new WebFormInput("B");
        InputChannel webFormForTf = new WebFormInput("false");

        InputChannel voiceAI = new VoiceAssistantInput(
                "The Dependency Inversion Principle states that high-level modules should not depend on low-level modules; both should depend on abstractions."
        );

        Quiz mcq = new MultipleChoiceQuiz(
                "What is the time complexity of binary search? [A) O(n) B) O(log n)]",
                "B",
                consoleTerminal);
        mcq.startQuiz();

        System.out.println("\n[Switching input channel to Web Form at runtime...]");
        mcq.setInputChannel(webFormForMcq);
        mcq.startQuiz();

        Quiz openQuiz = new OpenEndedQuiz(
                "Explain the Dependency Inversion Principle in 1 sentence.",
                voiceAI);
        openQuiz.startQuiz();

        Quiz tfQuiz = new TrueOrFalseQuiz(
                "Design patterns are finished pieces of code you can copy-paste directly.",
                false,
                webFormForTf);
        tfQuiz.startQuiz();

        System.out.println("\n[Switching True/False quiz to Voice AI...]");
        tfQuiz.setInputChannel(new VoiceAssistantInput("false"));
        tfQuiz.startQuiz();
    }
}