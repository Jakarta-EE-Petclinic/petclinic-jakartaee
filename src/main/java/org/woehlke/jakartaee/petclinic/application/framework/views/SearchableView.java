package org.woehlke.jakartaee.petclinic.application.framework.views;

import java.io.Serializable;

/**
 *
 */
public interface SearchableView extends Serializable {

    long serialVersionUID = 7807892292217350921L;

    String search();
    void performSearch();

    String getSearchterm();
    void setSearchterm(String searchterm);
    String clearSearchterm();
}
