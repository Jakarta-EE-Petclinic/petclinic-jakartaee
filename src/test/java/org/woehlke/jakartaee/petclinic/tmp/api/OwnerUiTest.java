package org.woehlke.jakartaee.petclinic.tmp.api;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.woehlke.jakartaee.petclinic.it.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.it.ui.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.OwnerPage;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunAsClient
@RunWith(Arquillian.class)
public class OwnerUiTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createDeployment();
    }

    @Drone
    private WebDriver driver;

    @ArquillianResource
    private URL deploymentUrl;

    @Page
    private HomePage homePage;

    @Page
    private OwnerPage ownerPage;

    @Test
    @InSequence(1)
    public void openHomePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openHomePage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(HomePage.class);
        homePage.assertPageIsLoaded();
        log.info("------------------------------------------------------------------------------------");
        log.info(" openHomePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(2)
    public void openOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(3)
    public void addNewOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickAddNewEntityButton();
        Assert.assertTrue(ownerPage.isFlowStateNew());
        ownerPage.clickCancelNewEntityButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(4)
    public void openOwnerDetailsPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerDetailsPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton0();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerDetailsPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
    public void editOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton0();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        ownerPage.clickShowEditForm();
        Assert.assertTrue(ownerPage.isFlowStateEdit());
        ownerPage.clickCancelEditButton();
        // ----------------------------------
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(6)
    public void deleteOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton1();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        ownerPage.clickShowDeleteForm();
        Assert.assertTrue(ownerPage.isFlowStateDelete());
        ownerPage.clickCancelDeleteButton();
        // ----------------------------------
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(7)
    public void addNewPetToOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetToOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton1();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        ownerPage.clickAddNewPetButton();
        Assert.assertTrue(ownerPage.isFlowStateNewPet());
        ownerPage.clickCancelNewPetButton();
        // ----------------------------------
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetToOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(8)
    public void addNewVisitToOwnersFirstPetPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVisitToOwnersFirstPetPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton1();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        ownerPage.clickAddNewVisitButton();
        Assert.assertTrue(ownerPage.isFlowStateNewVisit());
        ownerPage.clickCancelNewVisitButton();
        // ----------------------------------
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVisitToOwnersFirstPetPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }
}
