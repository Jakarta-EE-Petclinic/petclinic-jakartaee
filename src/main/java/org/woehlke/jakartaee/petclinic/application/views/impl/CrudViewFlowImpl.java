package org.woehlke.jakartaee.petclinic.application.views.impl;

import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.views.HasCrudFlowState;

import java.io.Serializable;

/**
 *
 */
@Log
public abstract class CrudViewFlowImpl implements HasCrudFlowState, Serializable {

    private static final long serialVersionUID = 8853867570285389553L;

    private CrudViewState flowState;

    protected CrudViewState getFlowState() {
        if (this.flowState == null) {
            this.flowState = CrudViewState.LIST;
        }
        return flowState;
    }

    @Override
    public boolean isFlowStateList() {
        return CrudViewState.LIST == this.getFlowState();
    }

    @Override
    public boolean isFlowStateDetails(){
        return CrudViewState.DETAILS  == this.getFlowState();
    }

    @Override
    public boolean isFlowStateNew() {
        return CrudViewState.NEW == this.getFlowState();
    }

    @Override
    public boolean isFlowStateEdit() {
        return CrudViewState.EDIT == this.getFlowState();
    }

    @Override
    public boolean isFlowStateDelete() {
        return CrudViewState.DELETE == this.getFlowState();
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return CrudViewState.LIST_SEARCH_RESULT == this.getFlowState();
    }


    public void logFlowState(){
        String msg = "flowState: " + this.flowState.name();
        log.info(msg);
    }

    @Override
    public void setFlowStateList() {
        this.flowState = CrudViewState.LIST;
    }

    @Override
    public void setFlowStateDetails() {
        this.flowState = CrudViewState.DETAILS;
    }

    @Override
    public void setFlowStateNew() {
        this.flowState = CrudViewState.NEW;
    }

    @Override
    public void setFlowStateEdit() {
        this.flowState = CrudViewState.EDIT;
    }

    @Override
    public void setFlowStateDelete() {
        this.flowState = CrudViewState.DELETE;
    }

    @Override
    public void setFlowStateSearchResult() {
        this.flowState = CrudViewState.LIST_SEARCH_RESULT;
    }
}
