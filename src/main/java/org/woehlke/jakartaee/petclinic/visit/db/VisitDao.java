package org.woehlke.jakartaee.petclinic.visit.db;

import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudDao;
import org.woehlke.jakartaee.petclinic.visit.Visit;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 07.01.14
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
public interface VisitDao extends CrudDao<Visit> {
    long serialVersionUID = -2002874805548729384L;
}
