package reflection;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author { String name(); }

@Author(name="John Doe")
class Book {}

public class AnnotaionDemo {
    public static void main(String[] args) {
        Author a = Book.class.getAnnotation(Author.class);
        System.out.println("Author: " + a.name());
    }
}

