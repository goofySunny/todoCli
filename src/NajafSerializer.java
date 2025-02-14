import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

public class NajafSerializer {

    public <T> String WriteValueAsJson(T object) throws IllegalAccessException {
        Class<?> tClass = object.getClass();
        Field[] fields = tClass.getDeclaredFields();
        StringBuilder string = new StringBuilder();
        string.append("{\n");
        for (Field field : fields) {
            String fieldValue = "";
            try {
                fieldValue = field.get(object).toString();
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
            string.append('"')
                    .append(field.getName())
                    .append('"').append(": ");
            if (!fieldValue.isEmpty() && field.getType().toString().equalsIgnoreCase("long")) {
                string
                        .append(fieldValue)
                        .append(",\n");
            } else {
                string
                        .append('"')
                        .append(fieldValue)
                        .append("\",\n");
            }
        }
        string.deleteCharAt(string.length() - 2);
        string.append("}");
        System.out.println(string.toString());
        return string.toString();
    }
}
