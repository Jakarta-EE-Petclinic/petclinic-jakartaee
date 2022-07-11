package org.woehlke.jakartaee.petclinic.specialty;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyView extends CrudView<Specialty>,
        SearchableView,
        LanguageChangeableView,
        CrudView2Model,
        Serializable {

    String JSF_PAGE = "specialty.jsf";

    String showDetailsForm(Specialty o);

    long serialVersionUID = -3557696335568559475L;
}
