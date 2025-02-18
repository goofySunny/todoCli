import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Todo {
    long id;
    String name;
    String description;
    LocalDate dateOfCreation;
    LocalDate targetDate;

    public Todo() {}

    public Todo(String name, String description, LocalDate targetDate) {
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && Objects.equals(name, todo.name) && Objects.equals(description, todo.description) && Objects.equals(dateOfCreation, todo.dateOfCreation) && Objects.equals(targetDate, todo.targetDate);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", targetDate=" + targetDate +
                '}';
    }
}
