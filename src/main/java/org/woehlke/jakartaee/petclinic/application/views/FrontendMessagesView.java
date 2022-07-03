package org.woehlke.jakartaee.petclinic.application.views;

import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;

import java.io.Serializable;

/**
 *
 */
public interface FrontendMessagesView extends Serializable {

    long serialVersionUID = 2936821773310905949L;

    void addInfoMessage(String summary, String detail);

    void addWarnMessage(String summary, String detail);

    void addErrorMessage(String summary, String detail);

    void addFatalMessage(String summary, String detail);

    void addInfoMessage(String summary, EntityBase entity);

    void addWarnMessage(String summary, EntityBase entity);

    void addErrorMessage(String summary, EntityBase entity);

    void addFatalMessage(String summary, EntityBase entity);

    void addInfoMessage(RuntimeException e, EntityBase entity);

    void addWarnMessage(RuntimeException e, EntityBase entity);

    void addErrorMessage(RuntimeException e, EntityBase entity);

    void addFatalMessage(RuntimeException e, EntityBase entity);

}
