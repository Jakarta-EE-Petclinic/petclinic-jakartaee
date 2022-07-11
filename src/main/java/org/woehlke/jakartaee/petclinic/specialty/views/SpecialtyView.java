package org.woehlke.jakartaee.petclinic.specialty.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageSelectorView;
import org.woehlke.jakartaee.petclinic.application.framework.has.SearchView;
import org.woehlke.jakartaee.petclinic.application.framework.has.View2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyView extends CrudView<Specialty>,
        SearchView,
        LanguageSelectorView,
        View2Model,
        Serializable {

    long serialVersionUID = -3557696335568559475L;

    String showDetailsForm(Specialty o);
}
