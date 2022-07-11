package org.woehlke.jakartaee.petclinic.pettype.views;


import org.woehlke.jakartaee.petclinic.application.framework.views.HasCrudFlowState;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudViewFlowImpl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 *
 */
@Named("petTypeViewFlow")
@SessionScoped
public class PetTypeViewFlowImpl extends CrudViewFlowImpl implements HasCrudFlowState, Serializable {
    private static final long serialVersionUID = 8397968607819895147L;
}
