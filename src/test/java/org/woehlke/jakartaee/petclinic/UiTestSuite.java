package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.ui.*;

@Suite
@SelectClasses({
   SpecialtyUiTest.class,  PetTypeUiTest.class,  VetUiTest.class,  OwnerUiTest.class, InformationUiTest.class
})
public class UiTestSuite {
}
