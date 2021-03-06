package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.validation.constraints.NotNull;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.application.framework.db.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.db.SearchableService;

/**
 * Created by tw on 10.03.14.
 */
public interface OwnerService extends CrudService<Owner>, SearchableService<Owner> {

    long serialVersionUID = -5744255576144969978L;

    Visit addNewVisit(@NotNull Visit visit);


}
