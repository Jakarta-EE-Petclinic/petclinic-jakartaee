package org.woehlke.jakartaee.petclinic;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.api.*;

@Log
@Suite
@SelectClasses({
    SpecialtyEndpointIT.class, VetEndpointIT.class,
    PetTypeEndpointIT.class, PetEndpointIT.class,
    VisitEndpointIT.class, OwnerEndpointIT.class
})
public class EndpointTestSuite {

    @BeforeAll
    public void runBeforeSuite(){
        log.info("START");
    }

    @AfterAll
    public void runAfterSuite(){
        log.info("DONE");
    }

}
