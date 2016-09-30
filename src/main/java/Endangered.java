import org.sql2o.*;
import java.util.List;

public class Endangered {
  public int id;
  public String name;
  public String health;
  public int age;

  public Endangered(String name, String health, int age) {
    this.name = name;
    this.health = health;
    this.age = id;
  }

  public String getName() {
    return name;
  }

  public String getHealth() {
    return health;
  }

  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }
}
