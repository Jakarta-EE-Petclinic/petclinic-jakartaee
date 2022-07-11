package org.woehlke.jakartaee.petclinic.pettype.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeCrudView extends CrudView<PetType>,
        LanguageChangeableView,
        SearchableView,
        CrudView2Model,
        Serializable {

    long serialVersionUID = -7305835717012880655L;
}