package org.woehlke.jakartaee.petclinic.application.views;

import java.io.Serializable;

/**
 *
 */
public interface HasLanguageView extends Serializable {

    long serialVersionUID = -7665952921129558730L;

    LanguageView getLanguageView();

    void setLanguageView(LanguageView languageView);
}