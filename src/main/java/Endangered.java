import org.sql2o.*;
import java.util.List;

public class Endangered extends Animal{
  public String health;
  public String age;

  public static final String HEALTHY = "healthy";
  public static final String ILL = "ill";
  public static final String OKAY = "okay";

  public static final String NEWBORN = "newborn";
  public static final String YOUNG = "young";
  public static final String OLD = "old";


  public Endangered(String name,String health, String age) {
    this.health = health;
    this.age = age;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", name)
        .addParameter("health", health)
        .addParameter("age", age)
        .executeUpdate()
        .getKey();
    }
  }
  public static Endangered find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id:";
      Endangered endangered = cn.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(Endangered.class);
      return endangered;
    }
  }
  @Override
  public void update() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE animals SET name = :name, health = :health, age = :age WHERE id = :id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("health", health)
      .addParameter("age", age)
      .addParameter("id", id)
      .executeUpdate();
  }
}
