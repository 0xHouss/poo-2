package poo2;

public class VideoCourse implements Identifiable {
  private String id, title, teacher;
  private int duration; // in minutes

  public VideoCourse(String id, String title, String teacher, int duration) {
    this.id = id;
    this.title = title;
    this.teacher = teacher;
    this.duration = duration;
  }

  @Override
  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getTeacher() {
    return teacher;
  }

  public int getDuration() {
    return duration;
  }

  @Override
  public String toString() {
    return title + " by " + teacher + " (" + duration + " minutes) [" + id + "]";
  }
}
