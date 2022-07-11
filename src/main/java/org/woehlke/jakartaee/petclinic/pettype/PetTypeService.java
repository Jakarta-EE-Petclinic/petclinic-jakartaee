package org.woehlke.jakartaee.petclinic.pettype;

import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.impl.SearchableService;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeService extends CrudService<PetType>, SearchableService<PetType>, Serializable {

    long serialVersionUID = 6637453269836393L;

    PetType findByName(String name);
}
