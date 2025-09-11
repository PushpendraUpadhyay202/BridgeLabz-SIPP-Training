package reflection;

import java.lang.reflect.*;
import java.util.*;

class Employee {
    public String name;
    public int age;
}

public class ObjectMapper {
    public static <T> T toObject(Class<T> c, Map<String,Object> map) throws Exception {
        T obj = c.getDeclaredConstructor().newInstance();
        for (var e : map.entrySet()) {
            Field f = c.getDeclaredField(e.getKey());
            f.setAccessible(true);
            f.set(obj, e.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String,Object> data = Map.of("name","Alice","age",30);
        Employee emp = toObject(Employee.class, data);
        System.out.println(emp.name + " " + emp.age);
    }
}
