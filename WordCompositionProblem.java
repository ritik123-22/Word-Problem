import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCompositionProblem {
    //Reading the input file
    private static List<String> readWordsFromFile(String inputFile) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    //Creating function to find the compound words
    private static List<String> findCompoundWords(List<String> words, Set<String> wordSet) {
        List<String> compoundWords = new ArrayList<>();
        for (String word : words) {
            if (isCompound(word, wordSet)) {
                compoundWords.add(word);
            }
        }
        return compoundWords;
    }

    //Creating the function to check whether the wordset is compound
    private static boolean isCompound(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isCompound(suffix, wordSet))) {
                return true;
            }
        }
        return false;
    }

    //main function
    public static void main(String[] args) {
        String inputFile = "Input_02.txt"; // Path to input file
        long startTime = System.currentTimeMillis();
        List<String> words = readWordsFromFile(inputFile);
        Set<String> wordSet = new HashSet<>(words);
        List<String> compoundWords = findCompoundWords(words, wordSet);
        long endTime = System.currentTimeMillis();

        // Sort the compound words list by length
        compoundWords.sort(Comparator.comparing(String::length).reversed());

        // Output the longest and second longest compound words
        if (!compoundWords.isEmpty()) {
            System.out.println("Longest Compound Word: " + compoundWords.get(0));
            if (compoundWords.size() > 1) {
                System.out.println("Second Longest Compound Word: " + compoundWords.get(1));
            }
        } else {
            System.out.println("No compound words found.");
        }

        // Output the time taken to process the input file
        System.out.println("Time taken to process file " + inputFile + ": " + (endTime - startTime) + " milliseconds");
    }
}
