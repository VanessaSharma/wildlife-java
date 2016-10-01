import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.utl.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/index.vtl");
       model.put("animals", Animal.all());
       return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/animals", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/animal.vtl");
       model.put("animals", Animal.all());
       return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/sightings", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/sighting.vtl");
    model.put("sightings", Sighting.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/animals/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/animal-entry.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/animals/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    Animal animal = new Animal(name);
    response.redirect("/");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/sightings/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/sighting-entry.vtl");
    model.put("sightings", Animal.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/sightings/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    String location = request.queryParams("location");
    String rangerName = request.queryParams("rangerName");
    int animalId = Integer.parseInt(request.queryParams("animal"));
    Sighting sighting = new Sighting(location, rangerName, animalId);
    response.redirect("/");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}
