package org.woehlke.jakartaee.petclinic.it;

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
import org.woehlke.jakartaee.petclinic.it.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.pages.PetTypePage;
import org.woehlke.jakartaee.petclinic.it.pages.SpecialtyPage;
import org.woehlke.jakartaee.petclinic.tmp.Deployments;
import org.woehlke.jakartaee.petclinic.tmp.pages.HelloPage;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunWith(Arquillian.class)
public class Test03PetType {

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
    @RunAsClient
    public void openHomePage() {
        goTo(HelloPage.class);
        homePage.assertPageIsLoaded();
    }

    @Test
    @InSequence(2)
    @RunAsClient
    public void openSpecialtyPage() {
        goTo(SpecialtyPage.class);
        petTypePage.assertPageIsLoaded();
    }

    @Test
    @InSequence(2)
    @RunAsClient
    public void openSpecialtyDetailsPage() {
        goTo(SpecialtyPage.class);
        petTypePage.assertPageIsLoaded();
    }

}
