package ibra.translationcase.translationwebservice.controller;
import ibra.translationcase.translationwebservice.models.Translator;
import ibra.translationcase.translationwebservice.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// Controller class for processing the REST API request
// Preparing the model and to return the view render as response
// It also hold the end-point for landing page as well both GET & POST

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class TranslatorController {

    @Autowired
    private TranslatorService translatorService;

    //Landing page end-point with information
    //Run this application on port 8080 -> localhost:8080/api
    @GetMapping("")
    public String getInfo(){

        String welcome = "<h1> Welcome to Translation Service </h1>";
        String URL = "localhost:8080/api";
        String clientTest = "<h2> Use an API client to test this application e.g, www.postman.com; H2 in-memory database is used for the implementation! <h2>";
        String getTranslation = "<h3> To Get translation value use this end point: /getTranslate?language_Id=en&search_key=buy-chips </h3>";
        String addNew = "<h3> To ADD new data use this end point: /addTranslate?language_Id=fn&search_key=chips-home&translation_value=chips-translate_home </h3>";;

        return welcome + "\n" + URL + "\n" + clientTest + "\n" + addNew + "\n" + getTranslation;
    }


    // Customization for just returning the translation value
    @GetMapping("/getTranslate")
    public String get(@RequestParam String language_Id, @RequestParam String search_key){

        return translatorService.getTranslator(language_Id, search_key);
    }

    //Using String class to create new Id, key & translate-value
    @PostMapping("/addTranslate")
    public String addNewTranslation(@RequestParam String language_Id, @RequestParam String search_key, @RequestParam String translation_value){

        Translator t = translatorService.createRecord(language_Id, search_key, translation_value);
        return t.toString();

    }


}
