package poo2;

import java.util.ArrayList;
import java.util.List;

class Depot<T extends Identifiable> {
  private List<T> items = new ArrayList<>();

  public void add(T item) {
    items.add(item);
  }

  public void display() {
    for (T item : items)
      System.out.println(item);
  }

  public T getById(String id) {
    for (T item : items)
      if (item.getId().equals(id))
        return item;

    return null; // or throw an exception
  }

  public void removeById(String id) {
    items.removeIf(item -> item.getId().equals(id));
  }

  public int size() {
    return items.size();
  }

  public List<T> getItems() {
    return items;
  }
}
