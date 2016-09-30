import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class SightingTest {
  private Sighting sighting;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    sighting = new Sighting("Zone A", "Krishan");
  }

  @Test
  public void sighting_instantiatesCorrectly_true() {
    sighting = new Sighting("Zone A");
    assertEquals("Zone A", sighting instanceof Sighting);s
  }

  @Test
  public void getLocation_sightingInstantiatesWithName_String() {
    sighting = new Sighting("Zone A");
    assertEquals("Zone A", sighting.getLocation());
  }

  @Test
  public void getRangerName_returnsCorrectRangerName_Krishan() {
    sighting = new Sighting("Krishan");
    assertEquals("Krishan", sighting.getRangerName());
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, sighting.getId()>0);
  }

  @Test
  public void find_returnsCorrectSighting_true() {
    assertTrue(Sighting.find(sighting.getId()).getLocation().equals("Zone A"));
  }

  @Test
  public void all_returnsAllInstances_true() {
    assertTrue(Sighting.all().size()>0);
  }

  @Test
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings *;";
      con.createQuery(sql).executeUpdate();
    }
  }

}
