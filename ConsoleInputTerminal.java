import java.util.Scanner;

public class ConsoleInputTerminal implements InputChannel {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String receiveAnswer(String prompt) {
        System.out.print("[Console] " + prompt + " -> ");
        return scanner.nextLine().trim();
    }
}