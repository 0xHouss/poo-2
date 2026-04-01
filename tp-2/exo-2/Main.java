import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 1. Demander à l’utilisateur de saisir une phrase.
    System.out.print("Entrez une phrase: ");
    String sentence = sc.nextLine();

    // 2. Convertir la phrase en minuscules.
    sentence = sentence.toLowerCase().trim();

    // 3. Découper la phrase en mots.
    String[] words = sentence.split("\\s+");

    // 4. Stocker les occurrences dans une Map<String, Integer>.
    Map<String, Integer> wordCount = new HashMap<>();

    for (String word : words)
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

    // 5. Afficher chaque mot avec son nombre d’occurrences.
    System.out.println("Fréquence des mots:");
    for (Map.Entry<String, Integer> entry : wordCount.entrySet())
      System.out.println(entry.getKey() + ": " + entry.getValue());

    // 6. Afficher :
    // — le nombre total de mots,
    // — le nombre de mots distincts.
    System.out.println("Nombre total de mots: " + words.length);
    System.out.println("Nombre de mots distincts: " + wordCount.size());

    // 7. Déterminer et afficher le mot le plus fréquent.
    String mostFrequentWord = null;

    for (Map.Entry<String, Integer> entry : wordCount.entrySet())
      if (mostFrequentWord == null || entry.getValue() > wordCount.get(mostFrequentWord))
        mostFrequentWord = entry.getKey();

    System.out
        .println("Le mot le plus fréquent: " + mostFrequentWord + " (" + wordCount.get(mostFrequentWord) + " fois)");

    // 8. Afficher les mots triés par ordre alphabétique.
    TreeMap<String, Integer> sortedWordCount = new TreeMap<>(wordCount);

    System.out.println("Fréquence des mots (triée):");
    for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet())
      System.out.println(entry.getKey() + ": " + entry.getValue());

    sc.close();
  }
}
