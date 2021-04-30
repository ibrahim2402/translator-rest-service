package ibra.translationcase.translationwebservice.errorHandler;

// Error handler class if NO translate_value found
public class TranslatorNotFound extends RuntimeException{

    public TranslatorNotFound(String search_key){
        super("Translation for <" + search_key + "> Not found!");
    }
}
