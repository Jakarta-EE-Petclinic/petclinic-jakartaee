package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.api.OwnerEndpointIT;
import org.woehlke.jakartaee.petclinic.it.api.PetEndpointIT;
import org.woehlke.jakartaee.petclinic.it.api.PetTypeEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.api.SpecialtyEndpointIT;
import org.woehlke.jakartaee.petclinic.it.api.VetEndpointIT;
import org.woehlke.jakartaee.petclinic.it.api.VisitEndpointIT;

@Suite
@SelectClasses({
        SpecialtyEndpointIT.class, VetEndpointIT.class,
        PetTypeEndpointIT.class, PetEndpointIT.class, VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {
}
