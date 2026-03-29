public class Etudiant {
  private String id, nom, prenom;

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
