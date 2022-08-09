package org.woehlke.jakartaee.petclinic;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.unit.OwnerUnitTestData;
import org.woehlke.jakartaee.petclinic.unit.PetUnitTestData;
import org.woehlke.jakartaee.petclinic.unit.PetTypeUnitTestData;
import org.woehlke.jakartaee.petclinic.unit.SpecialtyUnitTestData;
import org.woehlke.jakartaee.petclinic.unit.VetUnitTestData;
import org.woehlke.jakartaee.petclinic.unit.VisitUnitTestData;

@Log
@Suite
@SelectClasses({
        SpecialtyUnitTestData.class,  VetUnitTestData.class,
        PetTypeUnitTestData.class, PetUnitTestData.class,
        VisitUnitTestData.class, OwnerUnitTestData.class
})
public class EntityUnitTestSuite {

    @BeforeAll
    public void runBeforeSuite(){
      log.info("START");
    }

    @AfterAll
    public void runAfterSuite(){
        log.info("DONE");
    }
}
