package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.tmp.api.SpecialtyEndpointIT;
import org.woehlke.jakartaee.petclinic.tmp.api.*;

@Suite
@SelectClasses({
    SpecialtyEndpointIT.class, VetEndpointIT.class,
    PetTypeEndpointIT.class, PetEndpointIT.class, VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {
}
