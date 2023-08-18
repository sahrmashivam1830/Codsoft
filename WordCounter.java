import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text or provide a file path: ");
        String input = scanner.nextLine();

        String text = "";
        try {
            if (input.endsWith(".txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append(" ");
                    }
                    text = stringBuilder.toString();
                }
            } else {
                text = input;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        String[] words = text.split("\\s+|\\p{Punct}+");
        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }

        System.out.println("Total words: " + wordCount);
    }
}
