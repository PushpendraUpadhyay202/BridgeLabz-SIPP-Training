import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}


class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Hemant")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo task = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + task.priority());
        System.out.println("Assigned To: " + task.assignedTo());
    }
}
