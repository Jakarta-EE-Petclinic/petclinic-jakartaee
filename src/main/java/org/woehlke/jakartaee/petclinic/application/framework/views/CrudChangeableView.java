package org.woehlke.jakartaee.petclinic.application.framework.views;

import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @param <T>
 */
public interface CrudChangeableView<T extends EntityBase> extends SearchableView, LanguageChangeableView, Serializable {

    long serialVersionUID = -4976697275728754000L;

    String showNewForm();
    String cancelNew();
    String saveNew();

    String showEditForm();
    String cancelEdited();
    String saveEdited();

    String showDeleteForm();
    String cancelDelete();
    String performDelete();

    T getEntity();
    void setEntity(T entity);

    List<T> getList();
    void setList(List<T> list);

    ResourceBundle getMsg();
}
