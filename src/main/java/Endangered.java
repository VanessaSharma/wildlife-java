import org.sql2o.*;
import java.util.List;

public class Endangered extends Animal{
  public int id;
  public String name;
  public String health;
  public String age;
  public int animalId;

  public static final String HEALTHY = "healthy";
  public static final String ILL = "ill";
  public static final String OKAY = "okay";
  public static final String NEWBORN = "newborn";
  public static final String YOUNG = "young";
  public static final String OLD = "old";


  public Endangered(String name, String health, String age, int animalId) {
    this.name = name;
    this.health = health;
    this.age = age;
    this.animalId = animalId;
  }

  public String getName() {
    return name;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

}
