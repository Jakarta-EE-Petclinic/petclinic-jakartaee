package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.owner.api.OwnerEndpointIT;
import org.woehlke.jakartaee.petclinic.pet.api.PetEndpointIT;
import org.woehlke.jakartaee.petclinic.pettype.api.PetTypeEndpointIT;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyEndpointIT;
import org.woehlke.jakartaee.petclinic.vet.api.VetEndpointIT;
import org.woehlke.jakartaee.petclinic.visit.api.VisitEndpointIT;

@Suite
@SelectClasses({
        SpecialtyEndpointIT.class, VetEndpointIT.class,
        PetTypeEndpointIT.class, PetEndpointIT.class, VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {
}
