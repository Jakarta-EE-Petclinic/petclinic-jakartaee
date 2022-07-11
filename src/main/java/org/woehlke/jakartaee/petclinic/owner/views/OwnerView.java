package org.woehlke.jakartaee.petclinic.owner.views;

import org.woehlke.jakartaee.petclinic.application.framework.has.*;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageSelectorView;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.views.OwnersPetView;
import org.woehlke.jakartaee.petclinic.visit.views.OwnersPetVisitView;

import java.io.Serializable;

/**
 *
 */
public interface OwnerView extends CrudView<Owner>,
        OwnersPetView,
        OwnersPetVisitView,
        Owner2Model,
        HasOwnersPetModelOperations,
        LanguageSelectorView,
        SearchView,
        Serializable {

    long serialVersionUID = 3691413509555926089L;

    String showOwnerEditForm();

}
