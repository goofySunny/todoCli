import com.sun.source.tree.UsesTree;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class NajafSerializer {

    public <T> String writeValueAsJson(T object) throws IllegalAccessException {
        Class<?> tClass = object.getClass();
        Field[] fields = tClass.getDeclaredFields();

        StringBuilder string = new StringBuilder();
        if (object instanceof List) {
            for (Object obj : (List<?>) object) {
                string.append(writeValueAsJson(obj));
                string.append(",\n");
            }
        } else {
            string.append("{\n");
            for (Field field : fields) {
                String fieldValue = "";
                try {
                    fieldValue = field.get(object).toString();
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
                string.append("\t\"")
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
        }
        string.deleteCharAt(string.length() - 2);
        if (object instanceof List) {
        } else {
            string.append("}");
        }
        return string.toString();
    }
}
