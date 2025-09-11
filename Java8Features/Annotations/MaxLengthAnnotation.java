import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    public User(String username) throws Exception {
        this.username = username;

        Field f = User.class.getDeclaredField("username");
        MaxLength ml = f.getAnnotation(MaxLength.class);

        if (username.length() > ml.value()) {
            throw new IllegalArgumentException("Username too long!");
        }
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) throws Exception {
        User u1 = new User("Hemant");   
        User u2 = new User("VeryLongUsername"); 
    }
}
