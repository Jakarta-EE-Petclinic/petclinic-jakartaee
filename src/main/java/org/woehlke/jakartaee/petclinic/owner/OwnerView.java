package org.woehlke.jakartaee.petclinic.owner;

import jakarta.validation.constraints.NotNull;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.owner.views.Owner2Model;
import org.woehlke.jakartaee.petclinic.owner.views.OwnersPet2Model;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pet.views.OwnersPetView;
import org.woehlke.jakartaee.petclinic.visit.views.OwnersPetVisitView;

import java.util.List;


/**
 *
 */
public interface OwnerView extends CrudView<Owner>,
        OwnersPetView,
        OwnersPetVisitView,
        Owner2Model,
        OwnersPet2Model {


    String JSF_PAGE = "owner.jsf";

    String showOwnerEditForm();

    // Owner
    List<Pet> getPetsAsList();

    // Owner
    String getPetsAsString();

    long serialVersionUID = 3691413509555926089L;
}
