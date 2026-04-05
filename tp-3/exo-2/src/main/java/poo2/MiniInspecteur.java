package poo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MiniInspecteur {
  public static Class<?> getClass(String name) throws ClassNotFoundException {
    Class<?> c = Class.forName(name);
    return c;
  }

  public static Class<?> getClass(Object obj) {
    return obj.getClass();
  }

  public static void inspecter(Object obj) {
    inspecterClasse(getClass(obj));
  }

  public static void inspecter(String name) throws ClassNotFoundException {
    Class<?> c = getClass(name);
    inspecterClasse(c);
  }

  public static void inspecter(Class<?> c) {
    inspecterClasse(c);
  }

  public static void inspecterClasse(Class<?> c) {
    System.out.println("Nom complet: " + c.getName());
    System.out.println("Nom simple: " + c.getSimpleName());
    System.out.println("Package: " + c.getPackage());
    System.out.println("Superclasse: " + c.getSuperclass());

    Class<?>[] interfaces = c.getInterfaces();
    System.out.println("Interfaces implémentées:");
    for (Class<?> i : interfaces)
      System.out.println("- " + i.getName());

    Constructor<?>[] constructors = c.getConstructors();
    System.out.println("Constructeurs:");
    for (Constructor<?> cons : constructors)
      System.out.print("- " + cons.getName() + "("
          + Arrays.stream(cons.getParameterTypes())
              .map(Class::getSimpleName)
              .collect(Collectors.joining(", "))
          + ")\n");

    Method[] methods = c.getMethods();
    System.out.println("Méthodes:");
    for (Method m : methods)
      System.out.println("- " + m.getName() + "("
          + Arrays.stream(m.getParameterTypes())
              .map(Class::getSimpleName)
              .collect(Collectors.joining(", "))
          + "): " + m.getReturnType().getSimpleName());

    Field[] fields = c.getDeclaredFields();
    System.out.println("Champs:");
    for (Field f : fields)
      System.out.println("- " + f.getName() + ": " + f.getType().getSimpleName());
  }
}
