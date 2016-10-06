import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class SightingTest {
  private Sighting sighting;
  private Sighting sighting2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_test", null, null);
    sighting = new Sighting("Zone A", "Krishan", 1;
  }
  // @Rule
  // public DatabaseRule = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    assertTrue(sighting instanceof Sighting);
  }

  @Test
  public void getLocation_sightingInstantiatesWithName_String() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    assertEquals("Zone A", sighting.getLocation());
  }

  @Test
  public void getRangerName_returnsCorrectRangerName_Krishan() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    assertEquals("Krishan", sighting.getRangerName());
  }

  @Test
  public void getAnimalId_AnimalIdFromDatabase_int() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    assertEquals(1, sighting.getAnimlId());
  }

  @Test
  public void find_returnsCorrectSighting() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    sighting2 = new Sighting("Zone B", "Vanessa", 2);
    assertEquals(sighting2.getId(), Sighting.find(sighting2.getId()).getId());
  }

  @Test
  public void allByAnimal_returnsAllInstances_true() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    sighting2 = new Sighting("Zone B", "Vanessa", 2);
    assertEquals(1, Sighting.allByAnimal(1).size());
  }

  @Test
  public void delete() {
    sighting = new Sighting("Zone A", "Krishan", 1);
    sighting2 = new Sighting("Zone B", "Vanessa", 2);
    sighting.delete();
    assertEquals(0, sighting.all().size());
  }

}
