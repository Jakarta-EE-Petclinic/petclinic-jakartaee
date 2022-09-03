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
import org.woehlke.jakartaee.petclinic.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.deployments.UnitTestData;
import org.woehlke.jakartaee.petclinic.it.ui.pages.*;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunAsClient
@RunWith(Arquillian.class)
public class TellTheStoryUiTest  extends UnitTestData {

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
    private InformationPage informationPage;

    @Page
    private VeterinarianPage veterinarianPage;

    @Page
    private SpecialtyPage specialtyPage;

    @Page
    private PetTypePage petTypePage;

    @Page
    private OwnerPage ownerPage;

    private void goToOwnerPage(){
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
    }

    private void goToPetTypePage(){
        goTo(PetTypePage.class);
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateList());
    }

    private void goToSpecialtyPage(){
        goTo(SpecialtyPage.class);
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateList());
    }

    private void goToVeterinarianPage(){
        goTo(VeterinarianPage.class);
        veterinarianPage.fullscreen();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
    }

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
    public void openInformationPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openInformationPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(InformationPage.class);
        informationPage.assertPageIsLoaded();
        log.info("------------------------------------------------------------------------------------");
        log.info(" openInformationPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(3)
    public void openSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goToSpecialtyPage();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(4)
    public void addNewSpecialtyForm() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyForm ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickAddNewEntityButton();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateNew());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyForm DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
    public void addNewSpecialtyFormCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyFormCancel ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickCancelNewEntityButton();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyFormCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(6)
    public void detailsSpecialtyForm() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyForm ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickShowDetailsFormButton0();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyForm DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(7)
    public void editSpecialtyForm() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyForm ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickShowEditForm();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateEdit());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyForm DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(8)
    public void editSpecialtyFormCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyFormCancel ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickCancelEditButton();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyFormCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(9)
    public void deleteSpecialtyForm() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyForm ");
        log.info("------------------------------------------------------------------------------------");
        specialtyPage.clickShowDeleteForm();
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateDelete());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyForm DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(10)
    public void openPetTypePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openPetTypePage ");
        log.info("------------------------------------------------------------------------------------");
        goToPetTypePage();
        Assert.assertTrue(petTypePage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openPetTypePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(11)
    public void addNewPetTypePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetTypePage ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickAddNewEntityButton();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateNew());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetTypePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(12)
    public void addNewPetTypePageCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetTypePageCancel ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickCancelNewEntityButton();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetTypePageCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }


    @Test
    @InSequence(13)
    public void detailsPetTypePageCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" detailsPetTypePageCancel ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickShowDetailsFormButton0();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateDetails());
        log.info("------------------------------------------------------------------------------------");
        log.info(" detailsPetTypePageCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(14)
    public void editPetTypePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetTypePage ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickShowEditForm();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateEdit());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetTypePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(15)
    public void editPetTypePageCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetTypePageCancel ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickCancelEditButton();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateDetails());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetTypePageCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(16)
    public void deletePetTypePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deletePetTypePage ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickShowDeleteForm();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateDelete());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deletePetTypePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(17)
    public void deletePetTypePageCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deletePetTypePageCancel ");
        log.info("------------------------------------------------------------------------------------");
        petTypePage.clickCancelDeleteButton();
        petTypePage.fullscreen();
        Assert.assertTrue(petTypePage.isFlowStateDetails());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deletePetTypePageCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(18)
    public void openVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(19)
    public void openOwnerPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerPage ");
        log.info("------------------------------------------------------------------------------------");
        goToOwnerPage();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openOwnerPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

}
