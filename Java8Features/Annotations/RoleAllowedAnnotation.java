import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteData() {
        System.out.println("Data deleted!");
    }
}

public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER";

        SecureService service = new SecureService();
        Method m = SecureService.class.getMethod("deleteData");

        if (m.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed role = m.getAnnotation(RoleAllowed.class);
            if (role.value().equals(currentUserRole)) {
                m.invoke(service);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
