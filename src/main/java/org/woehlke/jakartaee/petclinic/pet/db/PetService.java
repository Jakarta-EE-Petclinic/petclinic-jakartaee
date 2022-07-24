package org.woehlke.jakartaee.petclinic.pet.db;

import org.woehlke.jakartaee.petclinic.application.framework.db.CrudService;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import java.io.Serializable;


/**
 *
 */
public interface PetService extends CrudService<Pet>, Serializable {

    long serialVersionUID = 7113444329343577727L;
}
