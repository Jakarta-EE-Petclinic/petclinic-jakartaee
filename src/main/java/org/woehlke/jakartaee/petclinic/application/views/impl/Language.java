package org.woehlke.jakartaee.petclinic.application.views.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Language {

    ENGLISH(Locale.ENGLISH),
    GERMAN(Locale.GERMAN);

    private Locale locale;

    public static Map<String, String> getCountries() {
        Map<String, String> countries = new HashMap<>();
        for (Language language : Language.values()) {
            countries.put(
                    language.getLocale().getDisplayLanguage(),
                    language.getLocale().getLanguage()
            );
        }
        return countries;
    }

    public static Language getDefault(){
        return Language.ENGLISH;
    }

    public Locale getLocale(){
        return locale;
    }

    private Language(Locale locale){
        this. locale =  locale;
    }
}
