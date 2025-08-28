
import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String file = "students.dat";

        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            System.out.println("Student data saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
