package org.woehlke.jakartaee.petclinic.vet.views;


import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;
import org.woehlke.jakartaee.petclinic.application.views.impl.CrudViewFlow;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;


/**
 *
 */
@Named("vetViewFlow")
@SessionScoped
public class VetViewFlow extends CrudViewFlow implements HasCrudFlowState, Serializable {
    private static final long serialVersionUID = -4032116498859585466L;
}
