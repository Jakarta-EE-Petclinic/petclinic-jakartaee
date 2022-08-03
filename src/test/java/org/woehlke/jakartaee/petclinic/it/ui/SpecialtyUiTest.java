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

    @Page
    private SpecialtyDetailsPage specialtyDetailsPage;

    @Page
    private SpecialtyEditPage specialtyEditPage;

    @Page
    private SpecialtyDeletePage specialtyDeletePage;

    @Page
    private SpecialtyNewPage specialtyNewPage;

    @Test
    @InSequence(1)
    @RunAsClient
    public void openHomePage() {
        goTo(HomePage.class);
        homePage.assertPageIsLoaded();
    }


    @Test
    @InSequence(2)
    @RunAsClient
    public void openSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
    }

    @Test
    @InSequence(3)
    @RunAsClient
    public void addNewSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        specialtyPage.clickAddNewSpecialtyButton();
        specialtyPage.assertPageNewIsLoaded();
        specialtyPage.clickCancelNewSpecialtyButton();
        specialtyPage.assertPageIsLoaded();
    }

    @Ignore
    @Test
    @InSequence(4)
    @RunAsClient
    public void openSpecialtyDetailsPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        specialtyPage.clickShowDetailsFormButton0();
        specialtyPage.assertPageDetailsIsLoaded();
        specialtyPage.clickCancelDetailsButton();
        specialtyPage.assertPageIsLoaded();
    }

    @Ignore
    @Test
    @InSequence(5)
    @RunAsClient
    public void editSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        specialtyPage.clickShowDetailsFormButton0();
        specialtyPage.assertPageDetailsIsLoaded();
        specialtyPage.clickShowEditForm();
        specialtyPage.assertPageEditIsLoaded();
        specialtyPage.clickCancelEditButton();
        specialtyPage.clickCancelDetailsButton();
        specialtyPage.assertPageIsLoaded();
    }

    @Ignore
    @Test
    @InSequence(6)
    @RunAsClient
    public void deleteSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        specialtyPage.clickShowDetailsFormButton1();
        specialtyPage.assertPageDetailsIsLoaded();
        specialtyPage.clickShowDeleteForm();
        specialtyPage.assertPageDeleteIsLoaded();
        specialtyPage.clickCancelDelete();
        specialtyPage.clickCancelDetailsButton();
        specialtyPage.assertPageIsLoaded();
    }

    @Ignore
    @Test
    @InSequence(7)
    @RunAsClient
    public void fillSpecialtyPager() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
       // specialtyPage.clickShowDetailsFormButton0();
       // specialtyPage.assertPageIsLoaded();
        //specialtyPage.clickAddNewSpecialty();
    }

    @Ignore
    @Test
    @InSequence(8)
    @RunAsClient
    public void nextAndPreviousSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
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
    @RunAsClient
    public void changeSortOrderSpecialtySorter() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
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
