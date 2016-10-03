import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class EndangeredTest {
  private Endangered endangered;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    endangered = new Endangered("deer", "good", 3);
  }

  @Test
  public void endangered_instantiatesCorrectly_true() {
    endangered = new Endangered("deer");
    assertEquals(true, endangered instanceof Endangered);
  }

  @Test
  public void getName_endangeredInstantiatesWithName_deer() {
    endangered = new Endangered("deer";
    assertEquals("deer", endangered.getName());
  }

  @Test
  public void getHealth_returnsCorrectHealth_String() {
    engandered = new Endangered("good");
    assertEquals("good", endangered.getHealth());
  }

  @Test
  public void getAge_returnsCorrectAge_int() {
    endangered = new Endangered(3);
    assertEquals(3, endangered.getAge());
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, endangered.getId()>0);
  }

  @Test
  public void find_returnsCorrectEndangered_true() {
    assertTrue(Endangered.find(endangered.getId()).getName().equals(endangered.getName());
  }

  @Test
  public void all_returnsAllInstances_true() {
    assertTrue(Endangered.all().size()>0);
  }

  @Test
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM endangereds *;";
      con.createQuery(sql).executeUpdate();
    }
  }

}
