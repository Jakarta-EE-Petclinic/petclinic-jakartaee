package org.woehlke.jakartaee.petclinic.pettype.views;


import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;
import org.woehlke.jakartaee.petclinic.application.views.impl.CrudViewFlow;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 *
 */
@Named("petTypeViewFlow")
@SessionScoped
public class PetTypeViewFlow extends CrudViewFlow implements HasCrudFlowState, Serializable {
    private static final long serialVersionUID = 8397968607819895147L;
}
