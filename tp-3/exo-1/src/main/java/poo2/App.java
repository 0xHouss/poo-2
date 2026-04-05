package poo2;

import java.util.List;

public class App {
  public static void main(String[] args) {
    Depot<Book> bookDepot = new Depot<>();
    bookDepot.add(new Book("B1", "The Great Gatsby", "F. Scott Fitzgerald", 180));
    bookDepot.add(new Book("B2", "To Kill a Mockingbird", "Harper Lee", 281));
    bookDepot.add(new Book("B3", "1984", "George Orwell", 328));

    Depot<VideoCourse> courseDepot = new Depot<>();
    courseDepot.add(new VideoCourse("C1", "Java Programming", "Alice Smith", 120));
    courseDepot.add(new VideoCourse("C2", "Python Programming", "Bob Johnson", 90));
    courseDepot.add(new VideoCourse("C3", "Data Structures", "Charlie Brown", 150));

    System.out.println("Books in the depot:");
    bookDepot.display();

    System.out.println();

    System.out.println("Video courses in the depot:");
    courseDepot.display();

    System.out.println();

    System.out.println("IDs of books:");
    List<String> bookIds = Util.extractIds(bookDepot.getItems());
    Util.displayList(bookIds);

    System.out.println();

    // Recherche de video course par ID
    String course1Id = "C2";
    VideoCourse course1 = courseDepot.getById(course1Id);
    if (course1 == null)
      System.out.println("No course with ID: " + course1Id);
    else
      System.out.println(course1);

    System.out.println();

    // Recherche de video course par ID
    String course2Id = "C5";
    VideoCourse course2 = courseDepot.getById(course2Id);
    if (course2 == null)
      System.out.println("No course with ID: " + course2Id);
    else
      System.out.println(course2);
  }
}
