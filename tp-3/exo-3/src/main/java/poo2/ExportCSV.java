package poo2;

public class ExportCSV implements Operation {
  private String description;

  public ExportCSV() {
    this.description = "Default export CSV";
  }

  public ExportCSV(String description) {
    this.description = description;
  }

  @Override
  public void executer() {
    System.out.println("Export CSV: " + description);
  }

  @Override
  public String description() {
    return "Export CSV: " + description;
  }
}
