import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;


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
    model.put("template", "templates/animals.vtl");
    model.put("animals", Animal.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/sightings", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/sightings.vtl");
    model.put("sightings", Sighting.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/animals/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/animal-entry.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/animals/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    String type = request.queryParams("type");
    Animal animal = new Animal(name, type);
    animal.save();
    response.redirect("/animals");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/endangered/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("endangered", Endangered.all());
    model.put("template", "templates/endangered-entry.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/endangered/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    String health = request.queryParams("health");
    String age = request.queryParams("age");
    String type = "endangered";
    Endangered newEndangered = new Endangered(name, health, age, type);
    newEndangered.save();
    model.put("newEndangered", newEndangered);
    response.redirect("/animals");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  get("/sightings/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/sighting-entry.vtl");
    model.put("animals", Animal.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/sightings/new", (request, response)-> {
    Map<String, Object> model = new HashMap<String, Object>();
    String location = request.queryParams("location");
    String rangerName = request.queryParams("rangerName");
    int animalId = Integer.parseInt(request.queryParams("animal"));
    Sighting sighting = new Sighting(location, rangerName, animalId);
    sighting.save();
    model.put("animals", Animal.all());
    response.redirect("/sightings");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/animals/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("animal", Animal.find(Integer.parseInt(request.params(":id"))));
    model.put("endangered", Endangered.find(Integer.parseInt(request.params(":id"))));
    model.put("Sighting", Sighting.class);
    model.put("template", "templates/animal.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}
