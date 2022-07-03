package org.woehlke.jakartaee.petclinic.pettype.views;

import org.woehlke.jakartaee.petclinic.application.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasLanguage;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasSearch;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasViewModelOperations;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeView extends CrudView<PetType>,
        HasLanguage,
        HasSearch,
        HasViewModelOperations,
        Serializable {

    long serialVersionUID = -7305835717012880655L;
}
