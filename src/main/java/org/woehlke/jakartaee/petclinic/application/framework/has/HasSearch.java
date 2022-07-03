package org.woehlke.jakartaee.petclinic.application.framework.has;

import java.io.Serializable;

/**
 *
 */
public interface HasSearch extends Serializable {

    long serialVersionUID = 7807892292217350921L;

    String search();

    void performSearch();

    String getSearchterm();

    void setSearchterm(String searchterm);
}
