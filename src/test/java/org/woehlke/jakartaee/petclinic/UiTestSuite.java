package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.tmp.ui.InformationUiTest;
import org.woehlke.jakartaee.petclinic.tmp.api.OwnerUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.PetTypeUiTest;
import org.woehlke.jakartaee.petclinic.tmp.api.VetUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.SpecialtyUiTest;

@Suite
@SelectClasses({
   SpecialtyUiTest.class,  PetTypeUiTest.class,  VetUiTest.class,  OwnerUiTest.class, InformationUiTest.class
})
public class UiTestSuite {
}
