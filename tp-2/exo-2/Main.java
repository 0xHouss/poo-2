import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Entrez une phrase: ");
    String sentece = sc.nextLine();
    sentece = sentece.toLowerCase().trim();
    String[] words = sentece.split("\\s+");

    Map<String, Integer> wordCount = new HashMap<>();

    for (String word : words)
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

    System.out.println("Fréquence des mots:");
    for (Map.Entry<String, Integer> entry : wordCount.entrySet())
      System.out.println(entry.getKey() + ": " + entry.getValue());

    System.out.println("Nombre total de mots: " + words.length);
    System.out.println("Nombre de mots distincts: " + wordCount.size());

    String mostFrequentWord = null;

    for (Map.Entry<String, Integer> entry : wordCount.entrySet())
      if (mostFrequentWord == null || entry.getValue() > wordCount.get(mostFrequentWord))
        mostFrequentWord = entry.getKey();

    System.out
        .println("Le mot le plus fréquent: " + mostFrequentWord + " (" + wordCount.get(mostFrequentWord) + " fois)");

    TreeMap<String, Integer> sortedWordCount = new TreeMap<>(wordCount);

    System.out.println("Fréquence des mots (triée):");
    for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet())
      System.out.println(entry.getKey() + ": " + entry.getValue());

    sc.close();
  }
}
