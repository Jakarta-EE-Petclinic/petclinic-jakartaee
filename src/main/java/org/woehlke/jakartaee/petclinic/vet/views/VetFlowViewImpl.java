package org.woehlke.jakartaee.petclinic.vet.views;


import org.woehlke.jakartaee.petclinic.application.framework.views.CrudViewFlowImpl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;


/**
 *
 */
@Named("vetViewFlow")
@SessionScoped
public class VetFlowViewImpl extends CrudViewFlowImpl implements VetFlowView, Serializable {
    private static final long serialVersionUID = -4032116498859585466L;
}
