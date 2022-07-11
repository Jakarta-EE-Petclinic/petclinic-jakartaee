package org.woehlke.jakartaee.petclinic.application.framework.views;

import org.woehlke.jakartaee.petclinic.application.views.LanguageView;

import java.io.Serializable;

/**
 *
 */
public interface LanguageSelectorView extends Serializable {

    long serialVersionUID = -7665952921129558730L;

    LanguageView getLanguageView();

    void setLanguageView(LanguageView languageView);
}
