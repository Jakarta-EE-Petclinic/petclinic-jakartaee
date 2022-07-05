package org.woehlke.jakartaee.petclinic.owner.views;

import org.woehlke.jakartaee.petclinic.application.framework.has.*;
import org.woehlke.jakartaee.petclinic.application.views.CrudViewFlow;
import org.woehlke.jakartaee.petclinic.owner.Owner;

import java.io.Serializable;

/**
 *
 */
public interface OwnerView extends CrudViewFlow<Owner>,
        OwnersPetView,
        OwnersPetVisitView,
        HasOwnerModelOperations,
        HasOwnersPetModelOperations,
        HasLanguage,
        HasSearch,
        Serializable {

    long serialVersionUID = 3691413509555926089L;

    String showOwnerEditForm();

}
