package org.woehlke.jakartaee.petclinic.specialty.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyCrudChangeableView extends CrudChangeableView<Specialty>,
        SearchableView,
        LanguageChangeableView,
        CrudView2Model,
        Serializable {

    long serialVersionUID = -3557696335568559475L;

    String showDetailsForm(Specialty o);
}
