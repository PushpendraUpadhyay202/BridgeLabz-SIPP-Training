
import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "image.jpg";
        String destImage = "image_copy.jpg";

        try (FileInputStream fis = new FileInputStream(sourceImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destImage)) {
                byte[] buf = new byte[1024];
                int read;
                while ((read = bais.read(buf)) != -1) {
                    fos.write(buf, 0, read);
                }
            }

            System.out.println("Image copied. Bytes length: " + imageBytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
