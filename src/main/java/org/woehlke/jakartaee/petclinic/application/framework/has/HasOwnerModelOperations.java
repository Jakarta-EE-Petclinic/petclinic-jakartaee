package org.woehlke.jakartaee.petclinic.application.framework.has;

/**
 *
 */
public interface HasOwnerModelOperations extends HasViewModelOperations {

    long serialVersionUID = 1490389883743112662L;

    void loadPetTypeList();
}
