package org.woehlke.jakartaee.petclinic.owner;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.owner.views.Owner2Model;
import org.woehlke.jakartaee.petclinic.owner.views.OwnersPet2Model;
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
        OwnersPet2Model,
        LanguageChangeableView,
        SearchableView,
        Serializable {

    long serialVersionUID = 3691413509555926089L;

    String showOwnerEditForm();

}
