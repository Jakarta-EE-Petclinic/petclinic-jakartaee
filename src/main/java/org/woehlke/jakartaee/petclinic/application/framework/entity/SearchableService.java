package org.woehlke.jakartaee.petclinic.application.framework.entity;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 */
public interface SearchableService<T extends EntityBase> extends Serializable {

    long serialVersionUID = -1893303126489909752L;

    List<T> search(@NotNull String searchterm);

    void resetSearchIndex();
}
