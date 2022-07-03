package org.woehlke.jakartaee.petclinic.vet;

import org.woehlke.jakartaee.petclinic.application.framework.crud.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.entity.SearchableService;

import java.io.Serializable;

public interface VetService extends CrudService<Vet>, SearchableService<Vet>, Serializable {
    long serialVersionUID = 6211608636423556157L;
}
