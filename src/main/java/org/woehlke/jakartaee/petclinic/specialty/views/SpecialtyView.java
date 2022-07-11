package org.woehlke.jakartaee.petclinic.specialty.views;

import org.woehlke.jakartaee.petclinic.application.views.CrudViewFlow;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasLanguage;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasSearch;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasViewModelOperations;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyView extends CrudViewFlow<Specialty>,
        HasSearch,
        HasLanguage,
        HasViewModelOperations,
        Serializable {

    long serialVersionUID = -3557696335568559475L;

    String showDetailsForm(Specialty o);
}
