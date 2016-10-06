import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;

public class Sighting {
  public int id;
  public String location;
  public String rangerName;
  public Timestamp timeSighted;
  public int animalId;

  public Sighting(String location, String rangerName, int animalId) {
    this.location = location;
    this.rangerName = rangerName;
    this.animalId = animalId;
    this.save();
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
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public static List<Sighting> allbyAnimal(int animalId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE animalId=:animalId";
      return con.createQuery(sql)
        .addParameter("animalId", animalId)
        .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id=:id:";
       return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (location, rangerName, timeSighted, animalId) VALUES (:location, :rangerName, now(), :animalId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("location", this.location)
        .addParameter("rangerName", this.rangerName)
        .addParameter("animalId", this.animalId)
        .executeUpdate()
        .getKey();

    }
  }
  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE sightings SET location = :location, rangername = :rangername WHERE id = :id";
      con.createQuery(sql)
        .addParameter("location", location)
        .addParameter("rangername", rangerName)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings WHERE id=:id";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }


}
