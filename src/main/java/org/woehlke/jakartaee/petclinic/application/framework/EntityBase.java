package org.woehlke.jakartaee.petclinic.application.framework;

import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 */
public interface EntityBase extends Serializable {

    long serialVersionUID = -3378330831315654285L;

    Long getId();

    UUID getUuid();

    @Transient
    String getTableName();

    @Transient
    String getPrimaryKey();

    @Transient
    String getPrimaryKeyWithId();
}
