import org.sql2o.*;
import java.util.List;

public class Sighting {
  public int id;
  public String location;
  public String rangerName;

  public Sighting(String location, String rangerName) {
    this.location = location;
    this.rangerName = rangerName;
  }

  public String getLocation() {
    return location;
  }

  public String getRangerName() {
    return rangerName;
  }

  public int getId() {
    return id;
  }
}
