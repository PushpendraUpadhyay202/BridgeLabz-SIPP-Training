import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "UI glitch on dashboard")
    public void run() {
        System.out.println("Running software...");
    }
}


public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("run");
        BugReport[] bugs = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugs) {
            System.out.println("Bug: " + bug.description());
        }
    }
}
