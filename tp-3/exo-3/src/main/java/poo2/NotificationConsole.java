package poo2;

public class NotificationConsole implements Operation {
  private String description;

  public NotificationConsole() {
    this.description = "Default notification";
  }

  public NotificationConsole(String description) {
    this.description = description;
  }

  @Override
  public void executer() {
    System.out.println("Notification console: " + description);
  }

  @Override
  public String description() {
    return "Notification console: " + description;
  }
}
