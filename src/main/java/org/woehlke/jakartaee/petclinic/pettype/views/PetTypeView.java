package org.woehlke.jakartaee.petclinic.pettype.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageSelectorView;
import org.woehlke.jakartaee.petclinic.application.framework.has.SearchView;
import org.woehlke.jakartaee.petclinic.application.framework.has.View2Model;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeView extends CrudView<PetType>,
        LanguageSelectorView,
        SearchView,
        View2Model,
        Serializable {

    long serialVersionUID = -7305835717012880655L;
}
