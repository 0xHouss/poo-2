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
    System.out.println("Vertices: " + g.vertexSet());

    // 5. Afficher l’ensemble des arêtes du graphe.
    System.out.println("Edges: " + g.edgeSet());

    // 6. Effectuer un parcours en largeur (BFS) à partir de Alger.
    BreadthFirstIterator<String, DefaultEdge> it = new BreadthFirstIterator<>(g, "Alger");

    // 7. Afficher l’ordre de visite obtenu.
    while (it.hasNext())
      System.out.println(it.next());

    // Part D
    // 1. Ajouter une nouvelle ville Oran sans la relier aux autres villes.
    g.addVertex("Oran");

    // 2. Relancer le parcours BFS à partir de Alger.
    it = new BreadthFirstIterator<>(g, "Alger");

    while (it.hasNext())
      System.out.println(it.next());

    // 3. Observer si Oran apparaît dans le parcours.
    // On peut remarquer que Oran n'est pas visité, car il n'est pas connecté à
    // Alger ou à aucune autre ville du graphe.
    // Reformulation: Oran est un sommet isolé dans le graphe.

    // 4. Ajouter une nouvelle relation entre Tipaza et Medea.
    g.addEdge("Tipaza", "Medea");

    // 5. Relancer le parcours BFS et comparer le résultat avec le précédent.
    it = new BreadthFirstIterator<>(g, "Alger");

    while (it.hasNext())
      System.out.println(it.next());

    // On peut observer que l'ordre de visite a changé, car Tipaza est maintenant
    // connecté à Medea, ce qui permet d'accéder à Medea à partir de Tipaza lors du
    // parcours BFS.
  }
}
