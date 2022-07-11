package org.woehlke.jakartaee.petclinic.owner;

import jakarta.validation.constraints.NotNull;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.impl.SearchableService;

/**
 * Created by tw on 10.03.14.
 */
public interface OwnerService extends CrudService<Owner>, SearchableService<Owner> {

    long serialVersionUID = -5744255576144969978L;

    Visit addNewVisit(@NotNull Visit visit);


}
