package poo2;

import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;

public class Util {
  public static void displayList(List<?> list) {
    for (Object item : list)
      System.out.println(item);
  }

  public static <T extends Comparable<T>> T max(List<T> list) {
    if (list.isEmpty())
      return null;

    T max = list.get(0);

    for (T item : list)
      if (item.compareTo(max) > 0)
        max = item;

    return max;
  }

  public static <T> void swap(List<T> list, int i, int j) {
    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  public static List<String> extractIds(List<? extends Identifiable> items) {
    List<String> ids = new ArrayList<>();

    for (Identifiable item : items)
      ids.add(item.getId());

    return ids;
  }
}
