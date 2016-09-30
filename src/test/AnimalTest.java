import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class AnimalTest {
  private Animal animal;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    animal = new Animal("deer");
  }

  @Test
  public void animal_instantiatesCorrectly_true() {
    animal = new Animal("deer");
    assertEquals("deer", animal instanceof Animal);s
  }

  @Test
  public void getName_animalInstantiatesWithName_deer() {
    animal = new Animal("deer");
    assertEquals("deer", animal.getName());
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, animal.getId()>0);
  }

  @Test
  public void find_returnsCorrectAnimal_true() {
    assertTrue(Animal.find(animal.getId()).getName().equals("deer"));
  }

  @Test
  public void all_returnsAllInstances_true() {
    assertTrue(Animal.all().size()>0);
  }

  @Test
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM animals *;";
      con.createQuery(sql).executeUpdate();
    }
  }

}
