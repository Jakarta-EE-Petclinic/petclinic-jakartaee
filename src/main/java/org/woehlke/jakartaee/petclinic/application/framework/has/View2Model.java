package org.woehlke.jakartaee.petclinic.application.framework.has;

import java.io.Serializable;

/**
 *
 */
public interface View2Model extends Serializable {

    long serialVersionUID = 6750797521381818959L;

    void loadList();
    void newEntity();
    void saveNewEntity();
    void saveEditedEntity();
    void deleteSelectedEntity();

    void postConstruct();
    void preDestroy();
}
