package org.woehlke.jakartaee.petclinic.pettype;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeView extends CrudView<PetType>,
        LanguageChangeableView,
        SearchableView,
        CrudView2Model,
        Serializable {

    String JSF_PAGE = "petType.jsf";

    long serialVersionUID = -7305835717012880655L;
}
