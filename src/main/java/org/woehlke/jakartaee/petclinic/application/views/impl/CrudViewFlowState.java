package org.woehlke.jakartaee.petclinic.application.views.impl;

import java.io.Serializable;

/**
 *
 */
public enum CrudViewFlowState implements Serializable {
    LIST,
    NEW,
    EDIT,
    DELETE,
    LIST_SEARCH_RESULT
}
