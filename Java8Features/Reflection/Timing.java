package reflection;

import java.lang.reflect.*;

class Task {
    public void work() throws InterruptedException { Thread.sleep(400); }
}

public class Timing {
    public static void main(String[] args) throws Exception {
        Task t = new Task();
        Method m = Task.class.getMethod("work");
        long start = System.nanoTime();
        m.invoke(t);
        long end = System.nanoTime();
        System.out.println("Time: " + (end-start)/1_000_000 + " ms");
    }
}
