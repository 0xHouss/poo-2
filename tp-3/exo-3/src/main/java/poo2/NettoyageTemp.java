package poo2;

public class NettoyageTemp implements Operation {
  private String description;

  public NettoyageTemp() {
    this.description = "Default nettoyage temporaire";
  }

  public NettoyageTemp(String description) {
    this.description = description;
  }

  @Override
  public void executer() {
    System.out.println("Nettoyage temporaire: " + description);
  }

  @Override
  public String description() {
    return "Nettoyage temporaire: " + description;
  }
}
