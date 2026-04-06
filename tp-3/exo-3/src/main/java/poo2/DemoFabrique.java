package poo2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DemoFabrique {
  public static void handleException(Exception e) {
    if (e instanceof IllegalArgumentException) {
      System.out.println(e.getMessage());
    } else if (e instanceof NoSuchMethodException) {
      System.out.println("Aucun constructeur avec cette signature n'a été trouvé");
    } else if (e instanceof IllegalAccessException) {
      System.out.println("Le constructeur en question n'est pas accessible");
    } else if (e instanceof InstantiationException) {
      System.out.println("La classe ne peut pas être instanciée (peut-être est-elle abstraite ou une interface)");
    } else if (e instanceof InvocationTargetException) {
      System.out.println("Une erreur s'est produite lors de l'exécution du constructeur : " + e.getCause());
    } else {
      System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    RegistreOperations<Operation> registre = new RegistreOperations<>();

    registre.enregistrerOperation("Exporter", ExportCSV.class);
    registre.enregistrerOperation("Notification", NotificationConsole.class);
    registre.enregistrerOperation("Nettoyage", NettoyageTemp.class);

    registre.listerOperations();

    System.out.println();

    try {
      Operation o = registre.creerOperation("Notification");
      o.executer();
    } catch (Exception e) {
      handleException(e);
    }

    System.out.println();

    try {
      Operation o = registre.creerOperation("Exporter", new Class<?>[] { String.class },
          new Object[] { "Custom export CSV" });
      o.executer();
    } catch (Exception e) {
      handleException(e);
    }

    System.out.println();

    List<Operation> operations = new ArrayList<>();

    operations.add(new ExportCSV("Batch export CSV"));
    operations.add(new NotificationConsole("Batch notification"));
    operations.add(new NettoyageTemp());
    operations.add(new ExportCSV());

    System.out.println("Exécution de toutes les opérations du batch:");
    registre.executerToutes(operations);

    System.out.println();

    registre.inspecterOperation("Exporter");

    System.out.println();

    try {
      Operation o = registre.creerOperation("Test");
      o.executer();
    } catch (Exception e) {
      handleException(e);
    }

    System.out.println();

    try {
      Operation o = registre.creerOperation("Exporter", new Class<?>[] { String.class },
          new Object[] { 2 });
      o.executer();
    } catch (Exception e) {
      handleException(e);
    }
  }
}
