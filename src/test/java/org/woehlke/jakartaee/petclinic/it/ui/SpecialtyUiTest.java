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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.wildfly.common.Assert;
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
        goTo(HomePage.class);
        homePage.assertPageIsLoaded();
    }

    @Test
    @InSequence(2)
    public void openSpecialtyPage() {
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
    }

   // @Ignore
    @Test
    @InSequence(3)
    public void addNewSpecialtyPage() {
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickAddNewSpecialtyButton();
        Assert.assertTrue(specialtyPage.isFlowStateNew());
        specialtyPage.clickCancelNewSpecialtyButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
    }

   // @Ignore
    @Test
    @InSequence(4)
    public void openSpecialtyDetailsPage() {
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        specialtyPage.clickShowDetailsFormButton0();
        Assert.assertTrue(specialtyPage.isFlowStateDetails());
        specialtyPage.clickCancelDetailsButton();
        Assert.assertTrue(specialtyPage.isFlowStateList());
    }

    @Test
    @InSequence(5)
    public void editSpecialtyPage() {
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
    }

    @Test
    @InSequence(6)
    public void deleteSpecialtyPage() {
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
    }

    @Ignore
    @Test
    @InSequence(7)
    public void fillSpecialtyPager() {
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
       // specialtyPage.clickShowDetailsFormButton0();
       // specialtyPage.assertPageIsLoaded();
        //specialtyPage.clickAddNewSpecialty();
    }

    @Ignore
    @Test
    @InSequence(8)
    public void nextAndPreviousSpecialtyPage() {
        goTo(SpecialtyPage.class);
        Assert.assertTrue(specialtyPage.isFlowStateList());
        /*
        specialtyPage.assertPagerNextIsLoaded();
        specialtyPage.clickPagerNext();
        specialtyPage.assertPagerPrevIsLoaded();
        specialtyPage.clickPagerPrev();
        specialtyPage.assertPagerNextIsLoaded();
       */
    }

    @Ignore
    @Test
    @InSequence(9)
    public void changeSortOrderSpecialtySorter() {
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
    }
}
