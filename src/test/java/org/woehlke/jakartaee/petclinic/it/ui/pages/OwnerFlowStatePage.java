package org.woehlke.jakartaee.petclinic.it.ui.pages;

public interface OwnerFlowStatePage extends CrudFlowStatePage {

    boolean isFlowStateNewPet();

    boolean isFlowStateEditPet();

    boolean isFlowStateNewVisit();
}
