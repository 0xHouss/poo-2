package poo2;

import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RegistreOperations<T extends Operation> {
  private Map<String, Class<? extends T>> operations = new HashMap<>();

  public void enregistrerOperation(String nom, Class<? extends T> operationClass) {
    operations.put(nom, operationClass);
  }

  public void listerOperations() {
    System.out.println("Opérations enregistrées:");
    for (String nom : operations.keySet())
      System.out.println("- " + nom);
  }

  public T creerOperation(String nom)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    Class<? extends T> operationClass = operations.get(nom);

    if (operationClass == null)
      throw new IllegalArgumentException("Opération non trouvée: " + nom);

    return operationClass.getDeclaredConstructor().newInstance();
  }

  public T creerOperation(String nom, Class<?>[] parameterTypes, Object[] initargs)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    Class<? extends T> operationClass = operations.get(nom);

    if (operationClass == null)
      throw new IllegalArgumentException("Opération non trouvée: " + nom);

    if (parameterTypes.length != initargs.length)
      throw new IllegalArgumentException("parameterTypes et initargs doivent avoir la même taille");

    for (int i = 0; i < parameterTypes.length; i++) {
      if (initargs[i] != null && !parameterTypes[i].isInstance(initargs[i]))
        throw new IllegalArgumentException(
            "Argument " + i + " attendu: " + parameterTypes[i].getName() +
                ", reçu: " + initargs[i].getClass().getName());
    }

    return operationClass.getDeclaredConstructor(parameterTypes).newInstance(initargs);
  }

  public void inspecterOperation(String nom) {
    Class<? extends T> operationClass = operations.get(nom);

    if (operationClass == null)
      throw new IllegalArgumentException("Opération non trouvée: " + nom);

    System.out.println("Inspecting operation: " + nom);
    System.out.println("Class: " + operationClass.getName());

    Field[] fields = operationClass.getDeclaredFields();
    System.out.println("Attributs:");
    for (Field f : fields)
      System.out.println("- " + f.getName() + ": " + f.getType().getSimpleName());

    Method[] methods = operationClass.getMethods();
    System.out.println("Méthodes:");
    for (Method m : methods)
      System.out.println("- " + m.getName() + "("
          + Arrays.stream(m.getParameterTypes())
              .map(Class::getSimpleName)
              .collect(Collectors.joining(", "))
          + "): " + m.getReturnType().getSimpleName());

    Constructor<?>[] constructors = operationClass.getConstructors();
    System.out.println("Constructeurs:");
    for (Constructor<?> cons : constructors)
      System.out.print("- " + cons.getName() + "("
          + Arrays.stream(cons.getParameterTypes())
              .map(Class::getSimpleName)
              .collect(Collectors.joining(", "))
          + ")\n");
  }

  public void executerToutes(List<? extends T> operations) {
    for (T operation : operations)
      operation.executer();
  }
}
