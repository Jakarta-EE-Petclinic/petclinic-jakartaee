package org.woehlke.jakartaee.petclinic.owner.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.owner.views.impl.OwnersPet2Model;
import org.woehlke.jakartaee.petclinic.owner.views.impl.Owner2ModelCrud;
import org.woehlke.jakartaee.petclinic.pet.views.OwnersPetView;
import org.woehlke.jakartaee.petclinic.visit.views.OwnersPetVisitView;

import java.io.Serializable;

/**
 *
 */
public interface OwnerCrudChangeableView extends CrudChangeableView<Owner>,
        OwnersPetView,
        OwnersPetVisitView,
        Owner2ModelCrud,
        OwnersPet2Model,
        LanguageChangeableView,
        SearchableView,
        Serializable {

    long serialVersionUID = 3691413509555926089L;

    String showOwnerEditForm();

}
