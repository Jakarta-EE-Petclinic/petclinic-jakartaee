package org.woehlke.jakartaee.petclinic;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.ui.InformationUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.OwnerUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.PetTypeUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.VetUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.SpecialtyUiTest;

@Log
@Suite
@SelectClasses({
   SpecialtyUiTest.class, VetUiTest.class, PetTypeUiTest.class, OwnerUiTest.class, InformationUiTest.class
})
public class UiTestSuite {

    @BeforeAll
    public void runBeforeSuite(){
        log.info("START");
    }

    @AfterAll
    public void runAfterSuite(){
        log.info("DONE");
    }
}
