package org.woehlke.jakartaee.petclinic.owner.views;

import org.woehlke.jakartaee.petclinic.application.framework.has.*;
import org.woehlke.jakartaee.petclinic.application.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.views.HasLanguageView;
import org.woehlke.jakartaee.petclinic.owner.Owner;

import java.io.Serializable;

/**
 *
 */
public interface OwnerView extends CrudView<Owner>,
        OwnersPetView,
        OwnersPetVisitView,
        Owner2Model,
        HasOwnersPetModelOperations,
        HasLanguageView,
        SearchView,
        Serializable {

    long serialVersionUID = 3691413509555926089L;

    String showOwnerEditForm();

}
