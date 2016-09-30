import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/index.vtl");
      //  model.put("animals", Animal.all());
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/animals", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       String name = request.queryParams("name");
       String type = request.queryParams("type");
       response.redirect("/");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("/animals", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       Animal animals = Animal.find(Integer.parseInt(request.params(":id")));
       model.put("template", "templates/index.vtl");
      //  model.put("animals", Animal.all());
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
   }
}
