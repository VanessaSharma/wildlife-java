import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class AnimalTest {
  private Animal animal;
  private Animal animal2;

  @Rule
  public DatabaseRule = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    animal = new Animal("deer");
    assertEquals("deer", animal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_deer() {
    animal = new Animal("deer");
    assertEquals("deer", animal.getName());
  }

  @Test
  public void find_returnsCorrectAnimal() {
    animal = new Animal("deer");
    animal2 = new Animal("squirrel");
    assertEquals(Animal.find(animal.getId()), Animal.find(animal2.getId()).getId());
  }

  @Test
  public void all_returnsAllInstances() {
    animal = new Animal("deer");
    animal2 = new Animal("squirrel");
    assertEquals(2, Animal.all().size());
  }

  @Test
  public void delete() {
    animal = new Animal("deer");
    animal.delete();
    assertEquals(0, Animal.all().size());
  }

}
