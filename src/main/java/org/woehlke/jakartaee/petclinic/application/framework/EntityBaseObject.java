package org.woehlke.jakartaee.petclinic.application.framework;

import java.util.UUID;

/**
 *
 */
public abstract class EntityBaseObject<T extends EntityBaseObject> extends Object implements EntityBase, Comparable<T> {

    private static final long serialVersionUID = -3378330831315654285L;

    @Override
    public abstract Long getId();

    @Override
    public abstract UUID getUuid();

    @Override
    public abstract String getTableName();

    @Override
    public abstract String getPrimaryKey();

    @Override
    public abstract String getPrimaryKeyWithId();

    @Override
    public int compareTo(T o) {
        return this.getPrimaryKey().compareTo(o.getPrimaryKey());
    }
}
