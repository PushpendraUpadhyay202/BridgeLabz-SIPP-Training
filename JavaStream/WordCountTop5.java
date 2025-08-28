
import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) {
        String filePath = "textfile.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            wordCount.entrySet().stream()
                     .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                     .limit(5)
                     .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
