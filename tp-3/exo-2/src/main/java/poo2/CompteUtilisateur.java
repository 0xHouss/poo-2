package poo2;

public class CompteUtilisateur {
  private String id, nom, email;
  private boolean actif;

  public CompteUtilisateur() {
    System.out.println("Constructeur par défaut appelé");
  }

  public CompteUtilisateur(String id, String nom, String email) {
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.actif = true;
  }

  public String getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getEmail() {
    return email;
  }

  public boolean isActif() {
    return actif;
  }

  public void activer() {
    actif = true;
  }

  public void desactiver() {
    actif = false;
  }

  public void presentation() {
    System.out.println("Présentation du compte utilisateur:");
    System.out.println("ID: " + id);
    System.out.println("Nom: " + nom);
    System.out.println("Email: " + email);
    System.out.println("Actif: " + actif);
  }

  @Override
  public String toString() {
    return "CompteUtilisateur{id='" + id + "', nom='" + nom + "', email='" + email + "', actif=" + actif + "}";
  }
}
