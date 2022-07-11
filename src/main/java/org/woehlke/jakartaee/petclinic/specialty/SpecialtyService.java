package org.woehlke.jakartaee.petclinic.specialty;

import jakarta.validation.constraints.NotNull;
import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.impl.SearchableService;

import java.io.Serializable;

/**
 *
 */
public interface SpecialtyService extends CrudService<Specialty>, SearchableService<Specialty>, Serializable {

    long serialVersionUID = -5259594533899166058L;

    Specialty findSpecialtyByName(@NotNull String name);

}
