> Note: les réponses aux questions sont faits en forme de commentaires dans le code

# Exercice 1

## Classe Étudiant

```java
// 1. Créer une classe Étudiant contenant les attributs suivants :
// - id
// - nom
// - prénom
public class Etudiant {
  private String id, nom, prenom;

  // 2. Ajouter :
  // - un constructeur
  // - les accesseurs nécessaires 
  // - une méthode toString().
  public Etudiant(String id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public String getId() {
    return this.id;
  }

  public String getNom() {
    return this.nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  @Override
  public String toString() {
    return nom + " " + prenom + " (" + id + ")";
  }

  // 3. Redéfinir les méthodes equals() et hashCode() de manière
  // à considérer que deux étudiants sont identiques s’ils
  // possèdent le même id.
  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Etudiant))
      return false;

    Etudiant other = (Etudiant) obj;

    return this.id.equals(other.id);
  }
}
```

## Classe de test

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    // 4. Dans une classe de test, créer une List<Etudiant> puis :
    List<Etudiant> etudiants = new ArrayList<>();

    // — ajouter plusieurs étudiants,
    etudiants.add(new Etudiant("242431430718", "Takorabet", "Houssam"));
    etudiants.add(new Etudiant("242431574410", "Abderraouf", "Garid"));
    etudiants.add(new Etudiant("242431486908", "Tabouri", "Mehdi"));
    etudiants.add(new Etudiant("242431750012", "Saadbouzid", "Syliane"));

    // — ajouter volontairement au moins deux doublons logiques,

    // Meme id, different nom et prénom
    etudiants.add(new Etudiant("242431430718", "Amalou", "Amine"));

    // Meme nom et prénom, different id
    etudiants.add(new Etudiant("242431434567", "Takorabet", "Houssam"));

    // — afficher la liste complète.
    System.out.println("Liste des étudiants: (" + etudiants.size() + ")");
    for (Etudiant etudiant : etudiants)
      System.out.println("- " + etudiant);

    System.out.println();

    // Recherche d'un étudiant par id qui existe
    String sylianeId = "242431750012";
    Etudiant syliane = findById(etudiants, sylianeId);

    if (syliane != null)
      System.out.println("Etudiant avec l'id " + sylianeId + ": " + syliane);
    else
      System.out.println("Aucun étudiant trouvé avec l'id " + sylianeId);

    // Recherche d'un étudiant par id qui n'existe pas
    String anisId = "242431433220";
    Etudiant anis = findById(etudiants, anisId);

    if (anis != null)
      System.out.println("Etudiant avec l'id " + anisId + ": " + anis);
    else
      System.out.println("Aucun étudiant trouvé avec l'id " + anisId);

    System.out.println();

    // 6. Convertir la liste en Set<Etudiant> afin 
    // d’éliminer les doublons, puis afficher le contenu obtenu.
    Set<Etudiant> etudiantsSet = new HashSet<>(etudiants);

    System.out.println("Nouvelle liste d'étudiants (sans doublons): (" + etudiantsSet.size() + ")");

    for (Etudiant etudiant : etudiantsSet)
      System.out.println("- " + etudiant);

    System.out.println();

    // 7. Comparer la taille de la List et celle du Set.
    if (etudiantsSet.size() < etudiants.size())
      System.out.println("Il y a des doublons dans la liste d'étudiants.");
    else
      System.out.println("Il n'y a pas de doublons dans la liste d'étudiants.");

    System.out.println();

    // 8. Trier la liste :
    System.out.println("Tri par identifiant croissant:");

    // — une première fois par identifiant croissant,
    etudiants.sort(Comparator.comparing(Etudiant::getId));

    for (Etudiant etudiant : etudiants)
      System.out.println("- " + etudiant);

    System.out.println();

    // — une deuxième fois par nom alphabétique.
    System.out.println("Tri par nom alphabetiquement croissant:");

    etudiants.sort(Comparator.comparing(Etudiant::getNom));

    for (Etudiant etudiant : etudiants)
      System.out.println("- " + etudiant);

    System.out.println();
  }

  // 5. Écrire une méthode qui recherche un étudiant par
  // son identifiant dans la liste.
  public static Etudiant findById(List<Etudiant> etudiants, String id) {
    for (Etudiant etudiant : etudiants)
      if (etudiant.getId() == id)
        return etudiant;

    return null;
  }
}
```

## Résultats de l'exécution

```text
Liste des étudiants: (6)
- Takorabet Houssam (242431430718)
- Abderraouf Garid (242431574410)
- Tabouri Mehdi (242431486908)
- Saadbouzid Syliane (242431750012)
- Amalou Amine (242431430718)
- Takorabet Houssam (242431434567)

Etudiant avec l'id 242431750012: Saadbouzid Syliane (242431750012)
Aucun étudiant trouvé avec l'id 242431433220

Nouvelle liste d'étudiants (sans doublons): (5)
- Abderraouf Garid (242431574410)
- Takorabet Houssam (242431434567)
- Takorabet Houssam (242431430718)
- Tabouri Mehdi (242431486908)
- Saadbouzid Syliane (242431750012)

Il y a des doublons dans la liste d'étudiants.

Tri par identifiant croissant:
- Takorabet Houssam (242431430718)
- Amalou Amine (242431430718)
- Takorabet Houssam (242431434567)
- Tabouri Mehdi (242431486908)
- Abderraouf Garid (242431574410)
- Saadbouzid Syliane (242431750012)

Tri par nom alphabetiquement croissant:
- Abderraouf Garid (242431574410)
- Amalou Amine (242431430718)
- Saadbouzid Syliane (242431750012)
- Tabouri Mehdi (242431486908)
- Takorabet Houssam (242431430718)
- Takorabet Houssam (242431434567)
```


# Exercice 2

## Classe de test

```java
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

    System.out.println("Fréquence des mots (par ordre alphabetique):");
    for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet())
      System.out.println(entry.getKey() + ": " + entry.getValue());

    sc.close();
  }
}
```

## Résultats de l'exécution

```test
Entrez une phrase: Java est simple et java est puissant
Fréquence des mots:
puissant: 1
java: 2
est: 2
simple: 1
et: 1
Nombre total de mots: 7
Nombre de mots distincts: 5
Le mot le plus fréquent: java (2 fois)
Fréquence des mots (par ordre alphabetique):
est: 2
et: 1
java: 2
puissant: 1
simple: 1
```

# Exercice 3

## Classe de test

```java
package exo3;

public class App {
  public static void main(String[] args) {
    // Execution de la partie 1
    System.out.println("--- Partie 1 ---");
    Part1.run();

    // Execution de la partie 2
    System.out.println("\n--- Partie 2 ---");
    Part2.run();
  }
}
```

## Partie 1 de l'exercice: (C & D)

```java
package exo3;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class Part1 {
  static void run() {
    // Part C
    // 1. Créer un graphe non orienté représentant ce réseau.
    Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    // 2. Ajouter tous les sommets.
    g.addVertex("Alger");
    g.addVertex("Blida");
    g.addVertex("Tipaza");
    g.addVertex("Boumerdes");
    g.addVertex("Medea");

    // 3. Ajouter toutes les relations sous forme d’arêtes.
    g.addEdge("Alger", "Blida");
    g.addEdge("Alger", "Tipaza");
    g.addEdge("Alger", "Boumerdes");
    g.addEdge("Blida", "Medea");

    // 4. Afficher l’ensemble des sommets du graphe.
    System.out.println("Sommets: " + g.vertexSet());

    // 5. Afficher l’ensemble des arêtes du graphe.
    System.out.println("Arêtes: " + g.edgeSet());

    // 6. Effectuer un parcours en largeur (BFS) à partir de Alger.
    System.out.println("Parcours BFS à partir de Alger:");
    BreadthFirstIterator<String, DefaultEdge> it = new BreadthFirstIterator<>(g, "Alger");

    // 7. Afficher l’ordre de visite obtenu.
    while (it.hasNext())
      System.out.println(it.next());

    // Part D
    // 1. Ajouter une nouvelle ville Oran sans la relier aux autres villes.
    g.addVertex("Oran");

    // 2. Relancer le parcours BFS à partir de Alger.
    System.out.println("Parcours BFS après ajout de Oran:");
    it = new BreadthFirstIterator<>(g, "Alger");

    while (it.hasNext())
      System.out.println(it.next());

    // 3. Observer si Oran apparaît dans le parcours.
    // On peut remarquer que Oran n'est pas visité, car elle n'est pas connecté à
    // Alger ou à aucune autre ville du graphe.
    // Reformulation: Oran est un sommet isolé dans le graphe.

    // 4. Ajouter une nouvelle relation entre Tipaza et Medea.
    g.addEdge("Tipaza", "Medea");

    // 5. Relancer le parcours BFS et comparer le résultat avec le précédent.
    System.out.println("Parcours BFS après ajout de l'arête Tipaza-Medea:");
    it = new BreadthFirstIterator<>(g, "Alger");

    while (it.hasNext())
      System.out.println(it.next());

    // On peut observer que l'ordre de visite n'a pas changé, car 
    // Tipaza et Medea étaient déjà accessibles à partir de Alger
    // via d'autres chemins (Alger -> Blida -> Medea et Alger -> Tipaza). 
    // Cependant, l'ajout de l'arête Tipaza-Medea a renforcé la 
    // connectivité du graphe, offrant une nouvelle route
    // entre ces deux villes.
  }
}
```

## Partie 2 de l'exercice: (E)

```java
package exo3;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Part2 {
  static void run() {
    // Part E
    // 1. Créer un graphe pondéré.
    Graph<String, DefaultWeightedEdge> wg = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

    // 2. Ajouter les sommets.
    wg.addVertex("Alger");
    wg.addVertex("Blida");
    wg.addVertex("Tipaza");
    wg.addVertex("Boumerdes");
    wg.addVertex("Medea");

    // 3. Ajouter les arêtes avec leurs poids.
    DefaultWeightedEdge e1 = wg.addEdge("Alger", "Blida");
    wg.setEdgeWeight(e1, 50);

    DefaultWeightedEdge e2 = wg.addEdge("Alger", "Tipaza");
    wg.setEdgeWeight(e2, 70);

    DefaultWeightedEdge e3 = wg.addEdge("Alger", "Boumerdes");
    wg.setEdgeWeight(e3, 45);

    DefaultWeightedEdge e4 = wg.addEdge("Blida", "Medea");
    wg.setEdgeWeight(e4, 90);

    DefaultWeightedEdge e5 = wg.addEdge("Boumerdes", "Tipaza");
    wg.setEdgeWeight(e5, 80);

    DefaultWeightedEdge e6 = wg.addEdge("Tipaza", "Medea");
    wg.setEdgeWeight(e6, 60);

    // 4. Calculer le plus cours chemin entre:
    // Alger et Boumerdes
    GraphPath<String, DefaultWeightedEdge> path1 = DijkstraShortestPath.findPathBetween(wg, "Alger", "Boumerdes");

    // Boumerdes et Blida
    GraphPath<String, DefaultWeightedEdge> path2 = DijkstraShortestPath.findPathBetween(wg, "Boumerdes", "Blida");

    // 5. Afficher pour chaque cas: le chemin trouvé et son coût total.
    System.out.println("Chemin trouvé: " + path1.getVertexList());
    System.out.println("Coût total: " + path1.getWeight());

    System.out.println("Chemin trouvé: " + path2.getVertexList());
    System.out.println("Coût total: " + path2.getWeight());
  }
}
```

## Résultats de l'exécution

```test
Sommets: [Alger, Blida, Tipaza, Boumerdes, Medea]
Arêtes: [(Alger : Blida), (Alger : Tipaza), (Alger : Boumerdes), (Blida : Medea)]
Parcours BFS à partir de Alger:
Alger
Blida
Tipaza
Boumerdes
Medea
Parcours BFS après ajout de Oran:
Alger
Blida
Tipaza
Boumerdes
Medea
Parcours BFS après ajout de l'arête Tipaza-Medea:
Alger
Blida
Tipaza
Boumerdes
Medea

--- Partie 2 ---
Chemin trouvé: [Alger, Boumerdes]
Coût total: 45.0
Chemin trouvé: [Boumerdes, Alger, Blida]
Coût total: 95.0
```
