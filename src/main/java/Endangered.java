// import org.sql2o.*;
// import java.util.List;
//
// public class Endangered extends Animal{
//   public int id;
//   public String name;
//   public String health;
//   public String age;
//   public int animalId;
//
//   public static final String HEALTHY = "healthy";
//   public static final String ILL = "ill";
//   public static final String OKAY = "okay";
//
//   public static final String NEWBORN = "newborn";
//   public static final String YOUNG = "young";
//   public static final String OLD = "old";
//
//
//   public Endangered(String name, String health, String age, int animalId) {
//     this.name = name;
//     this.health = health;
//     this.age = age;
//     this.animalId = animalId;
//   }
//
//   public String getName() {
//     return name;
//   }
//
//   public String getHealth() {
//     return health;
//   }
//
//   public String getAge() {
//     return age;
//   }
//
//   public int getId() {
//     return id;
//   }
//
//   public static List<Endangered> all() {
//    String sql = "SELECT * FROM animals WHERE type = 'endangered';";
//    try(Connection con = DB.sql2o.open()) {
//      return con.createQuery(sql)
//      .throwOnMappingFailure(false)
//      .executeAndFetch(Endangered.class);
//    }
//  }
//   public static Endangered find(int id) {
//     try(Connection cn = DB.sql2o.open()) {
//       String sql = "SELECT * FROM animals WHERE id=:id:";
//       Endangered endangered = cn.createQuery(sql)
//         .addParameter("id", id)
//         .throwOnMappingFailure(false)
//         .executeAndFetchFirst(Endangered.class);
//       return endangered;
//     }
//   }
//
//   public List<Sighting> getSightings() {
//      try(Connection con = DB.sql2o.open()) {
//        String sql = "SELECT * FROM sightings WHERE animalId = :id;";
//        return con.createQuery(sql)
//        .addParameter("id", this.id)
//        .throwOnMappingFailure(false)
//        .executeAndFetch(Sighting.class);
//      }
//  }
//
//   // public void save() {
//   //   try(Connection con = DB.sql2o.open()) {
//   //     String sql = "INSERT INTO endangereds (name, health, age, animalId) VALUES (:name, :health, :age, :animalId)";
//   //     this.id = (int) con.createQuery(sql, true)
//   //       .addParameter("name", this.name)
//   //       .addParameter("health", this.health)
//   //       .addParameter("age", this.age)
//   //       .addParameter("animalId", this.animalId)
//   //       .executeUpdate()
//   //       .getKey();
//   //
//   // }
//   // }
// }
