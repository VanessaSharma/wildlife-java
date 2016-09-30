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

  public static List<Sighting> all() {
    String sql = "SELECT * FROM sightings";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id=:id:";
      Sighting sighting = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (name, location, rangerName, timeSighted, animalId) VALUES (:name, :location, :rangerName, :timeSighted, :animalId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("location", this.location)
        .addParameter("rangerName", this.rangerName)
        .addParameter("animalId", this.animalId)
        .executeUpdate()
        .getKey();

  }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings WHERE id=:id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
