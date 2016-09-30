import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;

public class Sighting extends Animal{
  public int id;
  public String location;
  public String rangerName;
  public Timestamp timeSighted;
  public int animalId;

  public Sighting(String location, String rangerName, int animalId) {
    this.location = location;
    this.rangerName = rangerName;
    this.animalId = animalId;
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

  public int getAnimalId() {
    return animalId;
  }

  public Timestamp getTimeSighted() {
    return timeSighted;
  }
}
