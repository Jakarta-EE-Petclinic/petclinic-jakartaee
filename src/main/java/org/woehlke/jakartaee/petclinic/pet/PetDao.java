package org.woehlke.jakartaee.petclinic.pet;

import org.woehlke.jakartaee.petclinic.application.framework.crud.CrudDao;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 06.01.14
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public interface PetDao extends CrudDao<Pet> {
    long serialVersionUID = -7894365380280920804L;
}
