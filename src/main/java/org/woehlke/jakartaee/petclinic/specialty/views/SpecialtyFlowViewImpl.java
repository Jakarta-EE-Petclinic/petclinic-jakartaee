package org.woehlke.jakartaee.petclinic.specialty.views;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudViewFlowImpl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


/**
 *
 */
@Named("specialtyViewFlow")
@SessionScoped
public class SpecialtyFlowViewImpl extends CrudViewFlowImpl implements SpecialtyFlowView {
    private static final long serialVersionUID = -621000271002202654L;
}
