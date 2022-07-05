package org.woehlke.jakartaee.petclinic.pettype;

import org.woehlke.jakartaee.petclinic.application.framework.crud.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.entity.SearchableService;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeService extends CrudService<PetType>, SearchableService<PetType>, Serializable {

    long serialVersionUID = 6637453269836393L;

    PetType findByName(String name);
}
