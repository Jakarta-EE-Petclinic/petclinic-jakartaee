package org.woehlke.jakartaee.petclinic;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.api.RestEndpointIT;

@Log
@Suite
@SelectClasses({
        RestEndpointIT.class
})
public class RestEndpointSuite {

    @BeforeAll
    public void runBeforeSuite(){
        log.info("START");
    }

    @AfterAll
    public void runAfterSuite(){
        log.info("DONE");
    }
}
