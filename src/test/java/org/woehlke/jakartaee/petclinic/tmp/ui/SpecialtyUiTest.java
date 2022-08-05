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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jakartaee.petclinic.it.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.it.ui.pages.*;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;


/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 19.01.14
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@Log
@RunAsClient
@RunWith(Arquillian.class)
public class SpecialtyUiTest {

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
    private SpecialtyPage specialtyPage;

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
    public void openSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(3)
    public void addNewSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickAddNewEntityButton();
        Assert.assertTrue(specialtyPage.isFlowStateNew());
        specialtyPage.clickCancelNewEntityButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(4)
    public void openSpecialtyDetailsPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyDetailsPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickShowDetailsFormButton0();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickCancelDetailsButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openSpecialtyDetailsPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
    public void editSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickShowDetailsFormButton0();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickShowEditForm();
        Assert.assertTrue(specialtyPage.isFlowStateEdit());
        specialtyPage.clickCancelEditButton();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickCancelDetailsButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(6)
    public void deleteSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickShowDetailsFormButton1();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickShowDeleteForm();
        Assert.assertTrue(specialtyPage.isFlowStateDelete());
        specialtyPage.clickCancelDeleteButton();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickCancelDetailsButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Ignore
    @Test
    @InSequence(7)
    public void fillSpecialtyPager() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" fillSpecialtyPager ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        /*
        specialtyPage.clickShowDetailsFormButton0();
        specialtyPage.assertPageIsLoaded();
        specialtyPage.clickAddNewSpecialty();
        */
        log.info("------------------------------------------------------------------------------------");
        log.info(" fillSpecialtyPager DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Ignore
    @Test
    @InSequence(8)
    public void nextAndPreviousSpecialtyPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" nextAndPreviousSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        /*
        specialtyPage.assertPagerNextIsLoaded();
        specialtyPage.clickPagerNext();
        specialtyPage.assertPagerPrevIsLoaded();
        specialtyPage.clickPagerPrev();
        specialtyPage.assertPagerNextIsLoaded();
        */
        log.info("------------------------------------------------------------------------------------");
        log.info(" nextAndPreviousSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Ignore
    @Test
    @InSequence(9)
    public void changeSortOrderSpecialtySorter() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" changeSortOrderSpecialtySorter ");
        log.info("------------------------------------------------------------------------------------");
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        /*
        specialtyPage.assertSorterIsLoaded();
        specialtyPage.assertOrder();
        specialtyPage.clickSorter();
        specialtyPage.assertReverseOrder();
        specialtyPage.assertSorterIsLoaded();
        specialtyPage.clickSorter();
        specialtyPage.assertOrder();
        */
        log.info("------------------------------------------------------------------------------------");
        log.info(" changeSortOrderSpecialtySorter DONE ");
        log.info("------------------------------------------------------------------------------------");
    }
}
