package reflection;

import java.lang.reflect.*;

class Person {
    private int age = 25;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        f.set(p, 30);
        System.out.println("Age: " + f.get(p));
    }
}
