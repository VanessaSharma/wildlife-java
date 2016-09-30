import org.sql2o.*;
import java.util.List;

public abstract class Animal {
  public int id;
  public String name;
  public String type;


  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public static Animal find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id:";
      Animal animal = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return animal;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("type", this.type)
        .executeUpdate()
        .getKey();
    }
  }
}
