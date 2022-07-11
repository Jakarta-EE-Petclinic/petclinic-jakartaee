package org.woehlke.jakartaee.petclinic.application.views;

import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.has.SearchView;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @param <T>
 */
public interface CrudView<T extends EntityBase> extends SearchView, HasLanguageView, Serializable {

    long serialVersionUID = -4976697275728754000L;

    String showNewForm();

    String saveNew();

    String cancelNew();

    String showEditForm();

    String saveEdited();

    String cancelEdited();

    String showDeleteForm();

    String performDelete();

    String cancelDelete();

    T getEntity();

    void setEntity(T entity);

    List<T> getList();

    void setList(List<T> list);

    ResourceBundle getMsg();
}
