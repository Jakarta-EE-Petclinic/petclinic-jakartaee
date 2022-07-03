package org.woehlke.jakartaee.petclinic.pet.views;

import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;

import java.io.Serializable;

/**
 *
 */
public interface HasOwnerViewFlowState extends HasCrudFlowState, Serializable {

    long serialVersionUID = 6654391340545426308L;

    boolean isFlowStateNewPet();

    void setFlowStateNewPet();

    boolean isFlowStateEditPet();

    void setFlowStateEditPet();

    boolean isFlowStateNewVisit();

    void setFlowStateNewVisit();

    boolean isRenderPanelAddNewOwner();

    boolean isRenderPanelEditOwner();

    boolean isRenderPanelOwner();

    boolean isRenderPanelOwnerList();

    boolean isRenderPanelEditOwnersPet();

    boolean isRenderPanelAddNewOwnersPet();

    boolean isRenderPanelAddNewOwnersPetVisit();
}
