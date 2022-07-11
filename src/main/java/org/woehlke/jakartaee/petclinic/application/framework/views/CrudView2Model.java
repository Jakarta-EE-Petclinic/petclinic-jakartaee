package org.woehlke.jakartaee.petclinic.application.framework.views;

import java.io.Serializable;

/**
 *
 */
public interface CrudView2Model extends Serializable {

    long serialVersionUID = 6750797521381818959L;

    void loadList();
    void newEntity();
    void saveNewEntity();
    void saveEditedEntity();
    void deleteSelectedEntity();

    void postConstruct();
    void preDestroy();
}
