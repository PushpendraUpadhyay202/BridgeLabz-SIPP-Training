
import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourcePath = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destUnbuffered)) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
