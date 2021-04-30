package ibra.translationcase.translationwebservice.service;

import ibra.translationcase.translationwebservice.errorHandler.TranslatorNotFound;
import ibra.translationcase.translationwebservice.models.Translator;
import ibra.translationcase.translationwebservice.repository.TranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Service component with @Service annotation
// This layer handled the business logic between the controller class and repository layer interface

@Service
public class TranslatorService {

    @Autowired
    private TranslatorRepository translatorRepository;
    private Optional<Translator> findValue;

    // Implementing Example marcher in-built class to search corresponding value of id & key
    public Optional<Translator> retrieveOneTranslation(final String language_id, final String search_key) {
        Translator t = new Translator();
        t.setSearch_Key(language_id);
        t.setTranslation_value(search_key);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths(language_id).withIgnorePaths(search_key);

        Example <Translator> ex = Example.of(t, exampleMatcher);

        findValue = translatorRepository.findOne(ex);
        return findValue;
    }

    /**
     *
     * @param lang_key
     * @param search_key
     * @return one translate_value from the model class
     */
    public  String getTranslationBySearchKey(final String lang_key, final String search_key){
        Translator t = new Translator();
        t.setSearch_Key(search_key);
        t.setLanguage_Id(lang_key);
        Optional<Translator> translators = translatorRepository.findOne(Example.of(t));

        if (translators.isPresent()){

                  // Query method to loop through the model class to get the id & key for
                 // its corresponding translate_value or present error message
            /* for(int i=0;i <translators.size();i++){
                if(translators.get(i).getSearch_Key().equalsIgnoreCase(search_key)
                        && translators.get(i).getLanguage_Id().equalsIgnoreCase(lang_key)){
                    return translators.get(i).getTranslation_value();
                }
            }*/
           return translators.get().getTranslation_value();
        }
        return  "No translation found ";
    }

    /**
     * @param language_id
     * @param search_key
     * @return the found corresponding translate-value to the language_id & key is retrieved
     */
    @Transactional
    public String getTranslator(final String language_id, final String search_key){

        return getTranslationBySearchKey(language_id, search_key);
        /*
        Optional <Translator> transValue = retrieveOneTranslation(key, text);
        System.out.println(transValue.toString());
        if(transValue.isEmpty()){
            throw  new TranslatorNotFound(text);
        }
        return transValue.get().getTranslation_value();
         */

    }
    /**
     *
     * @param language_Id
     * @param search_key
     * @param translation_value
     * @return will create a new translator model
     */
    @Transactional
    public Translator createRecord(String language_Id, String search_key, String translation_value) {

        return translatorRepository.save(new Translator(language_Id, search_key, translation_value));
    }
}
