package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

class MathOps {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicInvoke {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        MathOps obj = new MathOps();
        Method m = MathOps.class.getMethod(name, int.class, int.class);
        System.out.println("Result: " + m.invoke(obj, 10, 5));
    }
}

