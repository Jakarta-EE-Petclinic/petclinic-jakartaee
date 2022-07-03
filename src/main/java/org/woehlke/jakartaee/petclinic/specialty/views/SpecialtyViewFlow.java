package org.woehlke.jakartaee.petclinic.specialty.views;

import org.woehlke.jakartaee.petclinic.application.framework.has.HasCrudFlowState;
import org.woehlke.jakartaee.petclinic.application.views.impl.CrudViewFlow;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 *
 */
@Named("specialtyViewFlow")
@SessionScoped
public class SpecialtyViewFlow extends CrudViewFlow implements HasCrudFlowState, Serializable {
    private static final long serialVersionUID = -621000271002202654L;
}
