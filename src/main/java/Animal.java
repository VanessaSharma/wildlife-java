import org.sql2o.*;
import java.util.List;

public abstract class Animal {
  public int id;
  public String name;
  public boolean type;

  //
  // public Animal(String name) {
  //   this.name = name;
  //   this.save();
  //   this.type = type;
  // }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public boolean getType() {
    return type;
  }

  public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Animal.class);
    }
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
      String sql = "INSERT INTO animals (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }
}
