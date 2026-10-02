package channel;

import java.util.Scanner;

public class ConsoleAnswerChannel implements AnswerChannel {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String receiveAnswer(String prompt) {
        System.out.print("[Console] " + prompt + " -> ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine(); 
        }
        return "";
    }

    @Override
    public void showMessage(String message) {
        System.out.println("[Console] " + message);
    }
}