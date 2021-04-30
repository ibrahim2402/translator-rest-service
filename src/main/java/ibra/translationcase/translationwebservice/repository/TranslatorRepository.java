package ibra.translationcase.translationwebservice.repository;

import ibra.translationcase.translationwebservice.models.Translator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Here is the interface repository layer that communicate between model class and the service layer for data access
 * It extends spring boot Java Persistence API (JPARepository)
 * Using H2 database for in-memory data store
 */

@Repository
public interface TranslatorRepository extends JpaRepository<Translator,Long> {

}
