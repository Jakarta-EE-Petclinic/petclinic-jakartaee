package org.woehlke.jakartaee.petclinic.owner.views;

import org.woehlke.jakartaee.petclinic.pet.views.HasOwnerViewFlowState;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 *
 */
@Named("ownerViewFlow")
@SessionScoped
public class OwnerViewFlow implements HasOwnerViewFlowState, Serializable {

    private static final long serialVersionUID = 4530858836742945751L;

    private OwnerViewFlowState flowState;

    private OwnerViewFlowState getFlowState() {
        if (this.flowState == null) {
            this.flowState = OwnerViewFlowState.LIST;
        }
        return this.flowState;
    }

    @Override
    public boolean isFlowStateList() {
        return this.getFlowState() == OwnerViewFlowState.LIST;
    }

    @Override
    public boolean isFlowStateNew() {
        return this.getFlowState() == OwnerViewFlowState.NEW_OWNER;
    }

    @Override
    public boolean isFlowStateEdit() {
        return this.getFlowState() == OwnerViewFlowState.EDIT_OWNER;
    }

    @Override
    public boolean isFlowStateDelete() {
        return this.getFlowState() == OwnerViewFlowState.DELETE_OWNER;
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return this.getFlowState() == OwnerViewFlowState.LIST_SEARCH_RESULT;
    }

    @Override
    public boolean isFlowStateNewPet() {
        return this.getFlowState() == OwnerViewFlowState.NEW_PET;
    }

    @Override
    public boolean isFlowStateEditPet() {
        return this.getFlowState() == OwnerViewFlowState.EDIT_PET;
    }

    @Override
    public boolean isFlowStateNewVisit() {
        return this.getFlowState() == OwnerViewFlowState.NEW_VISIT;
    }

    @Override
    public void setFlowStateNewVisit() {
        this.flowState = OwnerViewFlowState.NEW_VISIT;
    }

    @Override
    public void setFlowStateNewPet() {
        this.flowState = OwnerViewFlowState.NEW_PET;
    }

    @Override
    public void setFlowStateEditPet() {
        this.flowState = OwnerViewFlowState.EDIT_PET;
    }

    @Override
    public void setFlowStateList() {
        this.flowState = OwnerViewFlowState.LIST;
    }

    @Override
    public void setFlowStateNew() {
        this.flowState = OwnerViewFlowState.NEW_OWNER;
    }

    @Override
    public void setFlowStateEdit() {
        this.flowState = OwnerViewFlowState.EDIT_OWNER;
    }

    @Override
    public void setFlowStateDelete() {
        this.flowState = OwnerViewFlowState.DELETE_OWNER;
    }

    @Override
    public void setFlowStateSearchResult() {
        this.flowState = OwnerViewFlowState.LIST_SEARCH_RESULT;
    }


    public boolean isRenderPanelAddNewOwner() {
        return this.isFlowStateNew();
    }

    public boolean isRenderPanelEditOwner() {
        return this.isFlowStateEdit();
    }

    public boolean isRenderPanelOwner() {
        return false;
    }

    public boolean isRenderPanelOwnerList() {
        return true;
    }

    public boolean isRenderPanelEditOwnersPet() {
        return this.isFlowStateEditPet();
    }

    public boolean isRenderPanelAddNewOwnersPet() {
        return this.isFlowStateNewPet();
    }

    public boolean isRenderPanelAddNewOwnersPetVisit() {
        return this.isFlowStateNewVisit();
    }
}
