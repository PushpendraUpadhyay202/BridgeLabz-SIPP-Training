import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Alice", priority = "HIGH")
    public void login() {}

    @Todo(task = "Fix logout bug", assignedTo = "Bob")
    public void logout() {}
}

public class TodoAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo todo = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + " → " +
                        todo.task() + " | " +
                        todo.assignedTo() + " | " +
                        todo.priority());
            }
        }
    }
}
