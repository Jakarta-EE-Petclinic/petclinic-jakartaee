package org.woehlke.jakartaee.petclinic.pettype;

import org.woehlke.jakartaee.petclinic.application.framework.db.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.db.SearchableService;

import java.io.Serializable;

/**
 *
 */
public interface PetTypeService extends CrudService<PetType>, SearchableService<PetType> {

    long serialVersionUID = 6637453269836393L;

    PetType findByName(String name);
}
