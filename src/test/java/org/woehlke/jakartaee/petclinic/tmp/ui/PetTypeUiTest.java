package org.woehlke.jakartaee.petclinic.tmp.ui;

import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jakartaee.petclinic.it.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.it.ui.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.PetTypePage;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunAsClient
@RunWith(Arquillian.class)
public class PetTypeUiTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createDeployment();
    }

    @Drone
    WebDriver driver;

    @ArquillianResource
    URL deploymentUrl;

    @Page
    private HomePage homePage;

    @Page
    private PetTypePage petTypePage;

    @Test
    @InSequence(1)
    public void openHomePage() {
        goTo(HomePage.class);
        homePage.assertPageIsLoaded();
    }

    @Test
    @InSequence(2)
    public void openPetTypePage() {
        goTo(PetTypePage.class);
        petTypePage.assertPageIsLoaded();
    }

    @Test
    @InSequence(3)
    public void openPetTypeDetailsPage() {
        goTo(PetTypePage.class);
        petTypePage.assertPageIsLoaded();
    }

}
