package org.woehlke.jakartaee.petclinic.vet.views;


import org.woehlke.jakartaee.petclinic.application.views.HasCrudFlowState;
import org.woehlke.jakartaee.petclinic.application.views.impl.CrudViewFlowImpl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;


/**
 *
 */
@Named("vetViewFlow")
@SessionScoped
public class VetViewFlowImpl extends CrudViewFlowImpl implements HasCrudFlowState, Serializable {
    private static final long serialVersionUID = -4032116498859585466L;
}
