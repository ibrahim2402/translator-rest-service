package ibra.translationcase.translationwebservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Objects;

/**
 * This the Translator Entity with the three attributes:
 * language_Id, search_key, translate_value
 * Also is an auto generated Id for the JpaRepository layer (interface)
 */
@Entity
public class Translator {
    private @Id @GeneratedValue Long id;
    private String language_Id;
    private String  search_Key;
    private String  translation_value;


    public Translator(){ }

    public Translator(String language_Id, String search_Key, String translation_value) {
        this.language_Id = language_Id;
        this.search_Key = search_Key;
        this.translation_value = translation_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage_Id() {
        return language_Id;
    }

    public void setLanguage_Id(String language_Id) {
        this.language_Id = language_Id;
    }

    public String getSearch_Key() {
        return search_Key;
    }

    public void setSearch_Key(String search_Key) {
        this.search_Key = search_Key;
    }

    public String getTranslation_value() {
        return translation_value;
    }

    public void setTranslation_value(String translation_value) {
        this.translation_value = translation_value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translator that = (Translator) o;
        return getId().equals(that.getId()) &&
                getLanguage_Id().equals(that.getLanguage_Id()) &&
                getSearch_Key().equals(that.getSearch_Key()) &&
                getTranslation_value().equals(that.getTranslation_value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLanguage_Id(), getSearch_Key(), getTranslation_value());
    }

    @Override
    public String toString() {
        return "Translator{" +
                "id=" + id +
                ", language_Id='" + language_Id + '\'' +
                ", search_Key='" + search_Key + '\'' +
                ", translation_value='" + translation_value + '\'' +
                '}';
    }
}

/*

Translation Web Service Test Protocol
Implement a REST service that will serve translated strings.
Clients should be able to query with a key
(String) and a language id (also String), as well as insert new translations. The Server should return the
translation string associated with that key. The client should be able to add new keys and strings for
language id’s. Keys and their translations should be persisted.

Example:
Client adds for language code ‘en’, buy-chips = “Buy chips”
Clients can then query buy-chips for language ‘en’ and retrieve “Buy chips”

API:s, protocols, persistence store etc. are all to be chosen freely. There does not need to be any
graphical UI or admin capabilities. No client implementation is needed. We will use a HTTP client to
exercise the API.
Deliverable is the complete project that compiles and some simple instructions on how to access the
service

 */