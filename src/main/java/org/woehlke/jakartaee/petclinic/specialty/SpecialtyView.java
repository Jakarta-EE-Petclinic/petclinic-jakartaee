package org.woehlke.jakartaee.petclinic.specialty;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;

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

    long serialVersionUID = -3557696335568559475L;
}
