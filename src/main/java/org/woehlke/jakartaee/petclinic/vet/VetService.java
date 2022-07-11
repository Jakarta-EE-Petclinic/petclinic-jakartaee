package org.woehlke.jakartaee.petclinic.vet;

import org.woehlke.jakartaee.petclinic.application.framework.impl.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.impl.SearchableService;

import java.io.Serializable;

public interface VetService extends CrudService<Vet>, SearchableService<Vet>, Serializable {
    long serialVersionUID = 6211608636423556157L;
}
