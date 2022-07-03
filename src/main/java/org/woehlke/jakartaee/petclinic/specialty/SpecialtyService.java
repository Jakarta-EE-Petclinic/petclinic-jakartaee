package org.woehlke.jakartaee.petclinic.specialty;

import org.woehlke.jakartaee.petclinic.application.framework.crud.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.entity.SearchableService;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyService extends CrudService<Specialty>, SearchableService<Specialty>, Serializable {

    long serialVersionUID = -5259594533899166058L;

    Specialty findSpecialtyByName(String name);

}
