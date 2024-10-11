import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tWelcome to Todo Tracker CLI or TTC for short! \n\tuse the [help] command to view a list of all commands available");


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
                    if (rest == "") {
                        throw new Exception("norest");
                    }
                } catch (Exception e) {
                    System.out.println("Where rest?");
                }
            }

        }


    }
    public static void displayHelp() {
        System.out.println("This is a helper message");
    }
}