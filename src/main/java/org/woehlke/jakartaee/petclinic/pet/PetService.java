package org.woehlke.jakartaee.petclinic.pet;

import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudService;

import java.io.Serializable;


/**
 *
 */
public interface PetService extends CrudService<Pet>, Serializable {

    long serialVersionUID = 7113444329343577727L;
}
