import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class TodoAdditionService {

    NajafSerializer serializer = new NajafSerializer();
    Scanner scan = new Scanner(System.in);

    public Todo addTodo(String title) throws IllegalAccessException {
        Todo todo = new Todo();
        todo.setName(title);
        System.out.printf("%5s%n", "Enter a description for the Todo");
        todo.setDescription(scan.nextLine());
        System.out.printf("%5s%n", "In how many days do you plan to have it done");
        todo.setTargetDate(LocalDate.now().plusDays(scan.nextInt()));
        todo.setDateOfCreation(LocalDate.now());
        todo.setId((int) (Math.random() * 10));

        System.out.printf("Successfully Made Todo Called Titled : %s%n", todo.getName());
        serializer.WriteValueAsJson(todo);
        return todo;
    }
}
