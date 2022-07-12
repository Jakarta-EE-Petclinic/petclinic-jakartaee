package org.woehlke.jakartaee.petclinic.visit.views;

import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.io.Serializable;

/**
 *
 */
public interface OwnersPetVisitView extends Serializable {

    long serialVersionUID = 2400107254778567823L;

    String editOwnerPetVisitNewForm();
    String cancelOwnerPetVisitNew();
    String saveOwnerPetVisitNew();

    Visit getVisit();
    void setVisit(Visit visit);
}
