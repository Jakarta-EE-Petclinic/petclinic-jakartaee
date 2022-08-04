package org.woehlke.jakartaee.petclinic.it.ui;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jakartaee.petclinic.it.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.it.ui.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.VeterinarianPage;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunAsClient
@RunWith(Arquillian.class)
public class VetUiTest {

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
    private VeterinarianPage veterinarianPage;

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
    public void openVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(VeterinarianPage.class);
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(3)
    public void addNewVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(VeterinarianPage.class);
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickAddNewEntityButton();
        Assert.assertTrue(veterinarianPage.isFlowStateNew());
        veterinarianPage.clickCancelNewEntityButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(4)
    public void openVeterinarianDetailsPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianDetailsPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(VeterinarianPage.class);
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton0();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianDetailsPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
    public void editVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(VeterinarianPage.class);
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton0();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickShowEditForm();
        Assert.assertTrue(veterinarianPage.isFlowStateEdit());
        veterinarianPage.clickCancelEditButton();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(6)
    public void deleteVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(VeterinarianPage.class);
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton1();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickShowDeleteForm();
        Assert.assertTrue(veterinarianPage.isFlowStateDelete());
        veterinarianPage.clickCancelDeleteButton();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }
}
