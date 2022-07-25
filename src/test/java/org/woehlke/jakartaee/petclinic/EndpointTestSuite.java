package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.tmp.OwnerEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.PetEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.PetTypeEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.SpecialtyEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.VetEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.VisitEndpointIT;

@Suite
@SelectClasses({
        SpecialtyEndpointIT.class, VetEndpointIT.class,
        PetTypeEndpointIT.class, PetEndpointIT.class, VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {
}
