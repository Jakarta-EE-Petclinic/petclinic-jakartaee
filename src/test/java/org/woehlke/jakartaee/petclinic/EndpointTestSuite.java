package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.OwnerEndpointIT;
import org.woehlke.jakartaee.petclinic.it.PetEndpointIT;
import org.woehlke.jakartaee.petclinic.it.PetTypeEndpointIT;
import org.woehlke.jakartaee.petclinic.it.SpecialtyEndpointIT;
import org.woehlke.jakartaee.petclinic.it.VetEndpointIT;
import org.woehlke.jakartaee.petclinic.it.VisitEndpointIT;

@Suite
@SelectClasses({
        SpecialtyEndpointIT.class, VetEndpointIT.class,
        PetTypeEndpointIT.class, PetEndpointIT.class, VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {
}
