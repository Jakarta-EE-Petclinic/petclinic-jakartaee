package org.woehlke.jakartaee.petclinic.specialty;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;



/**
 *
 */
public interface SpecialtyView extends CrudView<Specialty>, CrudView2Model {

    String JSF_PAGE = "specialty.jsf";

    String JSF_PAGE_DETAILS = "specialtyDetails.jsf";

    String JSF_PAGE_EDIT = "specialtyEdit.jsf";

    String JSF_PAGE_DELETE = "specialtyDelete.jsf";

    String JSF_PAGE_NEW = "specialtyNew.jsf";

    long serialVersionUID = -3557696335568559475L;
}
