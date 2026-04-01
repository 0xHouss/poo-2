package exo3;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Part2 {
  static void run() {
    // Part C
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
