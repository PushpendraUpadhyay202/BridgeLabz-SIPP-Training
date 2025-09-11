import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Users {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    public Users(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonFieldAnnotation {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                f.setAccessible(true);
                json.append("\"")
                    .append(jf.name())
                    .append("\":\"")
                    .append(f.get(obj))
                    .append("\",");
            }
        }
        return json.substring(0, json.length()-1) + "}";
    }

    public static void main(String[] args) throws Exception {
        Users u = new Users("Hemant", 21);
        System.out.println(toJson(u));
    }
}
