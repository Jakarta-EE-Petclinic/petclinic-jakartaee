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
import org.woehlke.jakartaee.petclinic.it.pages.SpecialtyPage;
import org.woehlke.jakartaee.petclinic.tmp.Deployments;
import org.woehlke.jakartaee.petclinic.tmp.pages.HelloPage;

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
public class Test01Specialty {

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
        specialtyPage.assertPageIsLoaded();
    }


    @Test
    @InSequence(3)
    @RunAsClient
    public void addNewSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
    }


    @Test
    @InSequence(4)
    @RunAsClient
    public void editSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
    }

    @Test
    @InSequence(5)
    @RunAsClient
    public void deleteSpecialtyPage() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        /*
        specialtyPage.clickDeleteSpecialty();
        specialtyPage.assertPageIsLoaded();
        specialtyPage.assertDeletedContentNotFound();
        */
    }

    @Test
    @InSequence(6)
    @RunAsClient
    public void fillSpecialtyPager() {
        goTo(SpecialtyPage.class);
        specialtyPage.assertPageIsLoaded();
        //specialtyPage.clickAddNewSpecialty();
    }

    @Test
    @InSequence(7)
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

    @Test
    @InSequence(8)
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
