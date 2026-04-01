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

    // Meme id, different nom et prenom
    etudiants.add(new Etudiant("242431430718", "Amalou", "Amine"));

    // Meme nom et prenom, different id
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

    // 6. Convertir la liste en Set<Etudiant> afin d’éliminer les doublons, puis
    // afficher le contenu obtenu.
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

  // 5. Écrire une méthode qui recherche un étudiant par son identifiant dans la
  // liste.
  public static Etudiant findById(List<Etudiant> etudiants, String id) {
    for (Etudiant etudiant : etudiants)
      if (etudiant.getId() == id)
        return etudiant;

    return null;
  }
}
