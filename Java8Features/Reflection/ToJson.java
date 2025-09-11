package reflection;

import java.lang.reflect.*;

class Product {
    public String name = "Laptop";
    public double price = 75000.5;
}

public class ToJson {
    public static String toJson(Object o) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":\"").append(f.get(o)).append("\",");
        }
        sb.setLength(sb.length()-1);
        return sb.append("}").toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toJson(new Product()));
    }
}

