package org.woehlke.jakartaee.petclinic.it;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;

@Location("/")
public class SpecialtyPage {

    @Drone
    private WebDriver browser;
}
