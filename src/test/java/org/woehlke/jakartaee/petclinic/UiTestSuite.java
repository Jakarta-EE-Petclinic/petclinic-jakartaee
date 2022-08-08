package org.woehlke.jakartaee.petclinic;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.it.ui.InformationUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.OwnerUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.PetTypeUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.VetUiTest;
import org.woehlke.jakartaee.petclinic.it.ui.SpecialtyUiTest;

@Suite
@RunAsClient
@SelectClasses({
   SpecialtyUiTest.class, VetUiTest.class, PetTypeUiTest.class, OwnerUiTest.class, InformationUiTest.class
})
public class UiTestSuite {
}
