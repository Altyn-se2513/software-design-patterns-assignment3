import channel.ConsoleAnswerChannel;
import channel.VoiceAnswerChannel;
import channel.WebFormAnswerChannel;
import quiz.MultipleChoiceQuiz;
import quiz.OpenEndedQuiz;
import quiz.Quiz;
import quiz.TrueOrFalseQuiz;

public class Main {
    public static void main(String[] args) {
        runMultipleChoiceWithSwitch();
        runOpenEndedWithVoice();
        runTrueFalseWithSwitch();
    }

    private static void runMultipleChoiceWithSwitch() {
        Quiz quiz = new MultipleChoiceQuiz(
                "What is the time complexity of binary search? [A) O(n) B) O(log n)]",
                "B",
                new ConsoleAnswerChannel());
        quiz.startQuiz();

        System.out.println("\n[Switching answer channel to Web Form at runtime...]");
        quiz.setAnswerChannel(new WebFormAnswerChannel("B"));
        quiz.startQuiz();
    }

    private static void runOpenEndedWithVoice() {
        Quiz quiz = new OpenEndedQuiz(
                "Explain the Dependency Inversion Principle in 1 sentence.",
                new VoiceAnswerChannel(
                        "High-level modules should not depend on low-level modules; both should depend on abstractions."));
        quiz.startQuiz();
    }

    private static void runTrueFalseWithSwitch() {
        Quiz quiz = new TrueOrFalseQuiz(
                "Design patterns are finished pieces of code you can copy-paste directly.",
                false,
                new WebFormAnswerChannel("false"));
        quiz.startQuiz();

        System.out.println("\n[Switching True/False quiz to Voice AI...]");
        quiz.setAnswerChannel(new VoiceAnswerChannel("false"));
        quiz.startQuiz();
    }
}