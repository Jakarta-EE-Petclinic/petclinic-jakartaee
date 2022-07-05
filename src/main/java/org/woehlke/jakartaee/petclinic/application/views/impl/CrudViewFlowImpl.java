package org.woehlke.jakartaee.petclinic.application.views.impl;

import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;

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


    @Override
    public void setFlowStateList() {
        String msg = "setFlowState: " + CrudViewState.LIST.name();
        log.info(msg);
        this.flowState = CrudViewState.LIST;
    }

    @Override
    public void setFlowStateNew() {
        String msg = "setFlowState: " + CrudViewState.NEW.name();
        log.info(msg);
        this.flowState = CrudViewState.NEW;
    }

    @Override
    public void setFlowStateEdit() {
        String msg = "setFlowState: " + CrudViewState.EDIT.name();
        log.info(msg);
        this.flowState = CrudViewState.EDIT;
    }

    @Override
    public void setFlowStateDelete() {
        String msg = "setFlowState: " + CrudViewState.DELETE.name();
        log.info(msg);
        this.flowState = CrudViewState.DELETE;
    }

    @Override
    public void setFlowStateSearchResult() {
        String msg = "setFlowState: " + CrudViewState.LIST_SEARCH_RESULT.name();
        log.info(msg);
        this.flowState = CrudViewState.LIST_SEARCH_RESULT;
    }
}
