import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tWelcome to Todo Tracker CLI or TTC for short! \n\tuse the [help] command to view a list of all commands available");

        TodoAdditionService todoAdditionService = new TodoAdditionService();

        while (true) {

            System.out.println("Awaiting Command Input ...........");
            String fullCommand = scanner.nextLine();
            String[] commandParts = fullCommand.split(" ", 2);
            String keyWord = commandParts[0];
            String rest = "";


            if (keyWord.equalsIgnoreCase("help")) {
                displayHelp();
            } else {
                try {
                        rest = commandParts[1];
                } catch (IndexOutOfBoundsException e) {
                    System.out.printf("%10s%n", "Where Rest?");
                }
            }

            if (keyWord.equalsIgnoreCase("exit")) {
                return;
            } else if (keyWord.equalsIgnoreCase("add")) {
                todoAdditionService.addTodo(commandParts[1]);
            }

        }


    }
    public static void displayHelp() {
        System.out.println("This is a helper message");
    }
}