package poo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    System.out.println("Inspection de la classe CompteUtilisateur:");
    MiniInspecteur.inspecterClasse(CompteUtilisateur.class);

    System.out.println();

    System.out.println("Inspection d'une instance de CompteUtilisateur:");
    MiniInspecteur.inspecter(new CompteUtilisateur("123", "Alice", "alice@gmail.com"));

    System.out.println();

    System.out.println("Inspection de la classe CompteUtilisateur par son nom:");
    String className = "poo2.CompteUtilisateur";
    try {
      MiniInspecteur.inspecter(className);
    } catch (Exception e) {
      System.out.println("Aucune classe trouvée pour le nom: " + className);
    }

    System.out.println();

    Class<CompteUtilisateur> classe = CompteUtilisateur.class;

    try {
      Constructor<CompteUtilisateur> emptyConstructor = classe.getDeclaredConstructor();
      System.out.println("Constructeur par défaut trouvé: " + emptyConstructor);
      CompteUtilisateur compte = emptyConstructor.newInstance();
      System.out.println("Instance créée avec le constructeur par défaut:");
      System.out.println(compte);
    } catch (NoSuchMethodException e) {
      System.out.println("Aucun constructeur par défaut trouvé");
    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
      System.out.println("Erreur lors de l'instanciation avec le constructeur par défaut: " + e.getMessage());
    }

    System.out.println();

    try {
      Constructor<CompteUtilisateur> valuedConstructor = classe.getDeclaredConstructor(String.class, String.class,
          String.class);

      System.out.println("Constructeur avec paramètres trouvé: " + valuedConstructor);

      CompteUtilisateur compte = valuedConstructor.newInstance("456", "Bob", "bob@gmail.com");

      System.out.println("Instance créée avec le constructeur par défaut:");
      System.out.println(compte);
    } catch (NoSuchMethodException e) {
      System.out.println("Aucun constructeur avec paramètres trouvé");
    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
      System.out.println("Erreur lors de l'instanciation avec le constructeur avec paramètres: " + e.getMessage());
    }

    System.out.println();

    try {
      Method method = classe.getDeclaredMethod("presentation");
      System.out.println("Méthode presentation trouvée: " + method);

      CompteUtilisateur compte = new CompteUtilisateur("789", "Charlie", "charlie@gmail.com");
      method.invoke(compte);
    } catch (NoSuchMethodException e) {
      System.out.println("Méthode presentation non trouvée");
    } catch (InvocationTargetException | IllegalAccessException e) {
      System.out.println("Erreur lors de l'invocation de la méthode presentation: " + e.getMessage());
    }

    System.out.println();

    try {
      Method method = classe.getDeclaredMethod("desactiver");
      System.out.println("Méthode desactiver trouvée: " + method);

      CompteUtilisateur compte = new CompteUtilisateur("101", "Dave", "dave@gmail.com");

      System.out.println("État du compte avant désactivation:");
      System.out.println(compte);

      method.invoke(compte);

      System.out.println("État du compte après désactivation:");
      System.out.println(compte);
    } catch (NoSuchMethodException e) {
      System.out.println("Méthode desactiver non trouvée");
    } catch (InvocationTargetException | IllegalAccessException e) {
      System.out.println("Erreur lors de l'invocation de la méthode desactiver: " + e.getMessage());
    }

    System.out.println();

    try {
      Field field = classe.getDeclaredField("email");
      System.out.println("Champ email trouvé: " + field);

      CompteUtilisateur compte = new CompteUtilisateur("202", "Eve", "eve@gmail.com");

      System.out.println("Valeur initiale du champ email:");
      System.out.println(compte);

      field.setAccessible(true);
      field.set(compte, "new_eve@gmail.com");
      field.setAccessible(false);

      System.out.println("Nouvelle valeur du champ email:");
      System.out.println(compte);
    } catch (NoSuchFieldException e) {
      System.out.println("Champ email non trouvé");
    } catch (IllegalAccessException e) {
      System.out.println("Erreur lors de l'accès au champ email: " + e.getMessage());
    }

    System.out.println();

    MiniInspecteur.inspecterClasse(ArrayList.class);
  }
}
