package org.woehlke.jakartaee.petclinic.it.ui.pages;

import org.woehlke.jakartaee.petclinic.owner.views.OwnerFlowState;

public interface OwnerFlowStatePage extends CrudFlowStatePage {

    // OwnerFlowState.NEW_PET;
    boolean isFlowStateNewPet();

    //OwnerFlowState.EDIT_PET;
    boolean isFlowStateEditPet();

    // OwnerFlowState.NEW_VISIT;
    boolean isFlowStateNewVisit();
}
