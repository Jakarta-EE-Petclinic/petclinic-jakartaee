package org.woehlke.jakartaee.petclinic;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.woehlke.jakartaee.petclinic.owner.OwnerUnitTest;
import org.woehlke.jakartaee.petclinic.pet.PetUnitTest;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeUnitTest;
import org.woehlke.jakartaee.petclinic.specialty.SpecialtyUnitTest;
import org.woehlke.jakartaee.petclinic.vet.VetUnitTest;
import org.woehlke.jakartaee.petclinic.visit.VisitUnitTest;

@Suite
@SelectClasses({
        SpecialtyUnitTest.class,  VetUnitTest.class,
        PetTypeUnitTest.class, PetUnitTest.class, VisitUnitTest.class, OwnerUnitTest.class
})
public class EntityUnitTestSuite {
}
