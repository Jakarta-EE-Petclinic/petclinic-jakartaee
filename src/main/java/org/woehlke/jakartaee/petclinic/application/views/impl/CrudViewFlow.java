package org.woehlke.jakartaee.petclinic.application.views.impl;

import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;

import java.io.Serializable;

/**
 *
 */
@Log
public abstract class CrudViewFlow implements HasCrudFlowState, Serializable {

    private static final long serialVersionUID = 8853867570285389553L;

    private CrudViewFlowState flowState;

    protected CrudViewFlowState getFlowState() {
        if (this.flowState == null) {
            this.flowState = CrudViewFlowState.LIST;
        }
        return flowState;
    }

    @Override
    public boolean isFlowStateList() {
        return CrudViewFlowState.LIST == this.getFlowState();
    }

    @Override
    public boolean isFlowStateNew() {
        return CrudViewFlowState.NEW == this.getFlowState();
    }

    @Override
    public boolean isFlowStateEdit() {
        return CrudViewFlowState.EDIT == this.getFlowState();
    }

    @Override
    public boolean isFlowStateDelete() {
        return CrudViewFlowState.DELETE == this.getFlowState();
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return CrudViewFlowState.LIST_SEARCH_RESULT == this.getFlowState();
    }


    @Override
    public void setFlowStateList() {
        String msg = "setFlowState: " + CrudViewFlowState.LIST.name();
        log.info(msg);
        this.flowState = CrudViewFlowState.LIST;
    }

    @Override
    public void setFlowStateNew() {
        String msg = "setFlowState: " + CrudViewFlowState.NEW.name();
        log.info(msg);
        this.flowState = CrudViewFlowState.NEW;
    }

    @Override
    public void setFlowStateEdit() {
        String msg = "setFlowState: " + CrudViewFlowState.EDIT.name();
        log.info(msg);
        this.flowState = CrudViewFlowState.EDIT;
    }

    @Override
    public void setFlowStateDelete() {
        String msg = "setFlowState: " + CrudViewFlowState.DELETE.name();
        log.info(msg);
        this.flowState = CrudViewFlowState.DELETE;
    }

    @Override
    public void setFlowStateSearchResult() {
        String msg = "setFlowState: " + CrudViewFlowState.LIST_SEARCH_RESULT.name();
        log.info(msg);
        this.flowState = CrudViewFlowState.LIST_SEARCH_RESULT;
    }
}
