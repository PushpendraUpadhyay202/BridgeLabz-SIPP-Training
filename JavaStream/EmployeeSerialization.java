
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id; this.name = name; this.department = department; this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "IT", 50000),
            new Employee(2, "Jane", "HR", 45000)
        );

        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> list = (List<Employee>) ois.readObject();
            System.out.println("Employees retrieved:");
            list.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
