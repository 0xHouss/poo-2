package poo2;

public class Book implements Identifiable {
  private String id, title, author;
  private int nbPages;

  public Book(String id, String title, String author, int nbPages) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.nbPages = nbPages;
  }

  @Override
  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getNumberOfPages() {
    return nbPages;
  }

  @Override
  public String toString() {
    return title + " by " + author + " (" + nbPages + " pages) [" + id + "]";
  }
}
