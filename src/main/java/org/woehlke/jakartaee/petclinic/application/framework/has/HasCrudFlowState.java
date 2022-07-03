package org.woehlke.jakartaee.petclinic.application.framework.has;

import java.io.Serializable;

/**
 *
 */
public interface HasCrudFlowState extends Serializable {

    long serialVersionUID = -2732706731385890693L;

    boolean isFlowStateList();

    boolean isFlowStateNew();

    boolean isFlowStateEdit();

    boolean isFlowStateDelete();

    boolean isFlowStateSearchResult();

    void setFlowStateList();

    void setFlowStateNew();

    void setFlowStateEdit();

    void setFlowStateDelete();

    void setFlowStateSearchResult();
}
