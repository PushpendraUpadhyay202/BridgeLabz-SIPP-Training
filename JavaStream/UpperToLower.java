
import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        String source = "uppercase.txt";
        String dest = "lowercase.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted to lowercase.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
