package org.woehlke.jakartaee.petclinic.application.framework.entity;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 */
public interface SearchableEntity<T extends EntityBase> extends Serializable {

    long serialVersionUID = -1799267609856447186L;

    List<T> search(@NotNull String searchterm);

    void resetSearchIndex();
}
