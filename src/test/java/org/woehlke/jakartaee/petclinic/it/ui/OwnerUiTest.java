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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jakartaee.petclinic.it.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.it.ui.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.OwnerPage;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.net.URL;
import java.util.*;

import static org.jboss.arquillian.graphene.Graphene.goTo;

@Log
@RunWith(Arquillian.class)
public class OwnerUiTest {

    @RunAsClient
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
    public void addNewOwnerPageWithCancel() {
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

    protected static List<Pet> petList = new ArrayList<>();
    protected static List<Date> dateOfBirthList = new ArrayList<>();
    protected static List<PetType> petTypeList = new ArrayList<>();
    protected static Set<Pet> petSet = new HashSet<>();
    protected static final String petTypeNames[] = {
            "A Dog",
            "A Cat",
            "A Elephant",
            "A Kitten",
            "A Donkey",
            "A Cow",
            "A Pig",
            "A Chicken"
    };
    protected static final String petNames[] = {
            "A Jessie",
            "A Lucifer Sam",
            "A Nelly",
            "A Kitten",
            "A Benjamin",
            "A Pauline Wayne",
            "A Snowball",
            "A Gallus gallus domesticus"
    };
    static {
        for (String petTypeName : petTypeNames){
            PetType o = new PetType();
            o.setName(petTypeName);
            o.setUuid(UUID.randomUUID());
            petTypeList.add(o);
        }
    }
    static {
        int year = 2001;
        int month = 1;
        int day = 5;
        for (String petName : petNames){
            @SuppressWarnings("deprecation")
            Date dob = new Date(year,month,day);
            dateOfBirthList.add(dob);
            year++;
            month++;
            day++;
        }
    }
    static {
        int i=0;
        int k=0;
        for (String petName : petNames){
            Date dob = dateOfBirthList.get(k);
            Pet o = new Pet();
            o.setName(petName);
            o.setBirthDate(dob);
            o.setType(petTypeList.get(i));
            o.setUuid(UUID.randomUUID());
            petList.add(o);
            petSet.add(o);
            i++;
            i %= petTypeList.size();
            k++;
        }
    }
    protected static List<Owner> ownerList = new ArrayList<>();
    static {
        Owner o = new Owner();
        o.setFirstName("A1 Kurt");
        o.setLastName("A1 Tucholsky");
        o.setAddress("Lübecker Straße");
        o.setHouseNumber("13");
        o.setCity("Berlin");
        o.setZipCode("10559");
        o.setPhoneNumber("+49 30 3946364");
        o.setEmail("kurt.tucholsky@vistaberlin.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A2 Heinrich");
        o.setLastName("A2 Heine");
        o.setAddress("Bolkerstraße");
        o.setHouseNumber("53");
        o.setCity("Düsseldorf");
        o.setZipCode("40213");
        o.setPhoneNumber("+4921120054294");
        o.setEmail("heinrich.heine@heinehaus.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A3 Alan");
        o.setLastName("A3 Turing");
        o.setAddress("Bletchley Park");
        o.setHouseNumber("Block H");
        o.setCity("Milton Keynes");
        o.setZipCode("MK3 6EB");
        o.setPhoneNumber("+441908374708");
        o.setEmail("alan.turing@tnmoc.org");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A4 Grace");
        o.setLastName("A4 Hopper");
        o.setAddress("St Ronan St");
        o.setHouseNumber("160");
        o.setAddressInfo("Yale University");
        o.setCity("New Haven");
        o.setZipCode("CT 06520");
        o.setPhoneNumber("+12034324771");
        o.setEmail("grace.hopper@yale.edu");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A5 Mahatma");
        o.setLastName("A5 Ghandi");
        o.setAddress("Sevagram");
        o.setHouseNumber("PMH7 H42");
        o.setAddressInfo("Mahatma Gandhi Ashram");
        o.setCity("Maharashtra");
        o.setZipCode("442102");
        o.setPhoneNumber("+91 7152 284753");
        o.setEmail("mahatma.ghandi@gandhiashramsevagram.org");
        ownerList.add(o);
        for(Owner oo:ownerList){
            oo.setUuid(UUID.randomUUID());
            oo.setPets(petSet);
        }
    }

    @Test
    @InSequence(4)
    public void addNewOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        for(Owner oo:ownerList){
            ownerPage.clickAddNewEntityButton();
            Assert.assertTrue(ownerPage.isFlowStateNew());
            ownerPage.addNewEntity(oo);
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickCancelDetailsButton();
            Assert.assertTrue(ownerPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
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
    @InSequence(6)
    public void editOwnerPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editOwnerPageWithCancel ");
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
        log.info(" editOwnerPageWithCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(7)
    public void editOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        for(int i=0; i<ownerList.size(); i++){
            log.info(" "+i);
            ownerPage.clickShowDetailsFormButton(i);
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickShowEditForm();
            Assert.assertTrue(ownerPage.isFlowStateEdit());
            ownerPage.editNameAddString();
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickCancelDetailsButton();
            Assert.assertTrue(ownerPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" editOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(8)
    public void deleteOwnerPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOwnerPageWithCancel ");
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
        log.info(" deleteOwnerPageWithCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(9)
    public void deleteOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        for(int i=0; i<(ownerList.size()-1); i++) {
            ownerPage.clickShowDetailsFormButton0();
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickShowDeleteForm();
            Assert.assertTrue(ownerPage.isFlowStateDelete());
            ownerPage.clickSaveDeleteButton();
            Assert.assertTrue(ownerPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(10)
    public void addNewPetToOwnerPageWithCancel() {
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
    @InSequence(11)
    public void addNewPetToOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetToOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
        // ----------------------------------
        for(Pet pet:petList){
            ownerPage.clickShowDetailsFormButton1();
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickAddNewPetButton();
            Assert.assertTrue(ownerPage.isFlowStateNewPet());
            ownerPage.clickAddAndSaveNewPet(pet);
            //+++
            Assert.assertTrue(ownerPage.isFlowStateDetails());
            ownerPage.clickCancelDetailsButton();
            Assert.assertTrue(ownerPage.isFlowStateList());
        }
        // ----------------------------------
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewPetToOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Ignore
    @Test
    @InSequence(12)
    public void editPetOfOwnerPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetOfOwnerPageWithCancel ");
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
        log.info(" editPetOfOwnerPageWithCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Ignore // TODO
    @Test
    @InSequence(13)
    public void editPetOfOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetOfOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton1();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        //ownerPage.clickAddNewPetButton();
        //Assert.assertTrue(ownerPage.isFlowStateNewPet());
        //ownerPage.clickCancelNewPetButton();
        // ----------------------------------
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editPetOfOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(14)
    public void addNewVisitToOwnersFirstPetPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editNewVisitToOwnersFirstPetPageWithCancel ");
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
        log.info(" editNewVisitToOwnersFirstPetPageWithCancel DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    protected static List<Visit> visitList = new ArrayList<>();
    static {
        long i = 0;
        Pet p = petList.get(2);
        for(Date day : dateOfBirthList){
            i++;
            Visit v = new Visit();
            v.setPet(p);
            v.setDate(day);
            v.setDescription("woooolloooomoooolloooo "+i);
            v.setUuid(UUID.randomUUID());
            v.setId(i);
            visitList.add(v);
        }
    }

    @Test
    @InSequence(15)
    public void addNewVisitToOwnersFirstPetPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editNewVisitToOwnersFirstPetPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        ownerPage.fullscreen();
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton1();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        // ----------------------------------
        for(Visit v: visitList){
            ownerPage.clickAddNewVisitButton();
            Assert.assertTrue(ownerPage.isFlowStateNewVisit());
            ownerPage.clickAddAndSaveNewVisitButton(v.getDate(),v.getDescription());
            Assert.assertTrue(ownerPage.isFlowStateDetails());
        }
        // ----------------------------------
        ownerPage.clickCancelDetailsButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editNewVisitToOwnersFirstPetPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(9)
    public void deleteOneOwnerPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOneOwnerPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goTo(OwnerPage.class);
        Assert.assertTrue(ownerPage.isFlowStateList());
        ownerPage.clickShowDetailsFormButton0();
        Assert.assertTrue(ownerPage.isFlowStateDetails());
        ownerPage.clickShowDeleteForm();
        Assert.assertTrue(ownerPage.isFlowStateDelete());
        ownerPage.clickSaveDeleteButton();
        Assert.assertTrue(ownerPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteOneOwnerPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }
}
