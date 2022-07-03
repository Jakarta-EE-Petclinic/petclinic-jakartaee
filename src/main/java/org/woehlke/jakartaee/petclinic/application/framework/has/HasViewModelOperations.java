package org.woehlke.jakartaee.petclinic.application.framework.has;

import java.io.Serializable;

/**
 *
 */
public interface HasViewModelOperations extends Serializable {

    long serialVersionUID = 6750797521381818959L;

    boolean reloadEntityFromSelected();

    void loadList();

    void saveNewEntity();

    void saveEditedEntity();

    void deleteSelectedEntity();

    void newEntity();

    void init();

    void preDestroy();
}
