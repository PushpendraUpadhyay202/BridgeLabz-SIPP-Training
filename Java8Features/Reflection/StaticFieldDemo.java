package reflection;
import java.lang.reflect.*;

class Config {
    private static String API_KEY = "OLD_KEY";
}

public class StaticFieldDemo {
    public static void main(String[] args) throws Exception {
        Field f = Config.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        f.set(null, "NEW_KEY");
        System.out.println("API_KEY: " + f.get(null));
    }
}

