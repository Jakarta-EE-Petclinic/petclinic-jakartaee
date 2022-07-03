package org.woehlke.jakartaee.petclinic.application.framework.entity;

import java.util.UUID;

/**
 *
 */
public abstract class EntityBaseObject extends Object implements EntityBase, Comparable<EntityBaseObject> {

    private static final long serialVersionUID = -3378330831315654285L;

    @Override
    public abstract Long getId();

    @Override
    public abstract UUID getUuid();

    @Override
    public abstract String getTableName();

    @Override
    public abstract String[] getColumnNames();

    @Override
    public abstract String getPrimaryKey();

    @Override
    public abstract String getPrimaryKeyWithId();

    @Override
    public int compareTo(EntityBaseObject o) {
        return this.getPrimaryKey().compareTo(o.getPrimaryKey());
    }
}
