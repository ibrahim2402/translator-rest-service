package ibra.translationcase.translationwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TranslationWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslationWebServiceApplication.class, args);
    }

}
