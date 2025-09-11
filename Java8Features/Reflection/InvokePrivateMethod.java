package reflection;

import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) { return a * b; }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Method m = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);
        System.out.println("Result: " + m.invoke(c, 5, 4));
    }
}
