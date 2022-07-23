package org.woehlke.jakartaee.petclinic.specialty;

import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;



/**
 *
 */
public interface SpecialtyView extends CrudView<Specialty>, CrudView2Model {

    String JSF_PAGE = "specialty.jsf";

    long serialVersionUID = -3557696335568559475L;
}
