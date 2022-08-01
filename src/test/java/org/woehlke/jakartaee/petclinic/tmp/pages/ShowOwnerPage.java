package org.woehlke.jakartaee.petclinic.tmp.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 27.01.14
 * Time: 09:23
 * To change this template use File | Settings | File Templates.
 */
public class ShowOwnerPage {

    @FindBy(id="showOwnerForm")
    private WebElement showOwnerForm;

    @FindBy(id="showOwnerForm:firstName")
    private WebElement firstName;

    @FindBy(id="showOwnerForm:lastName")
    private WebElement lastName;

    @FindBy(id="showOwnerForm:address")
    private WebElement address;

    @FindBy(id="showOwnerForm:city")
    private WebElement city;

    @FindBy(id="showOwnerForm:telephone")
    private WebElement telephone;

    @FindBy(id="showOwnerForm:edit")
    private WebElement edit;

    @FindBy(id="showOwnerForm:addPet")
    private WebElement addPet;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:visitsTable:editPet")
    private WebElement editFirstPet;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:visitsTable:addVisit")
    private WebElement newVisitForFirstPet;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:petsName")
    private WebElement firstPetsName;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:petsBirthDate")
    private WebElement firstPetsBirthDate;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:petsType")
    private WebElement firstPetsType;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:1:petsName")
    private WebElement secondPetsName;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:1:petsBirthDate")
    private WebElement secondPetsBirthDate;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:1:petsType")
    private WebElement secondPetsType;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:visitsTable:0:date")
    private WebElement firstPetsFirstVisitDate;

    @FindBy(id="showOwnerForm:petsAndVisitsTable:0:visitsTable:0:description")
    private WebElement firstPetsFirstVisitDescription;

    public void assertPageIsLoaded() {
        Graphene.waitModel().until().element(showOwnerForm).is().visible();
        Assert.assertTrue(showOwnerForm.isDisplayed());
    }

    public void clickEditOwner() {
        Graphene.guardHttp(edit).click();
    }

    public void assertContent(String firstName,
                              String lastName,
                              String address,
                              String city,
                              String telephone) {
        Assert.assertEquals(firstName,this.firstName.getText());
        Assert.assertEquals(lastName,this.lastName.getText());
        Assert.assertEquals(address,this.address.getText());
        Assert.assertEquals(city,this.city.getText());
        Assert.assertEquals(telephone,this.telephone.getText());
    }

    public void clickAddNewPet() {
        Graphene.guardHttp(addPet).click();
    }

    public void clickEditFirstPet() {
        Graphene.guardHttp(editFirstPet).click();
    }

    public void assertFirstPetContent(String petsName, Date birthDate, String petType) {
        Assert.assertEquals(petsName,firstPetsName.getText());
        Assert.assertEquals(petType,firstPetsType.getText());
        LocalDateTime a = LocalDateTime.ofEpochSecond(birthDate.getTime(),0, ZoneOffset.UTC).minusDays(1);
        Assert.assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH).format(a),firstPetsBirthDate.getText());

    }

    public void assertSecondPetContent(String petsName, Date birthDate, String petType) {
        Assert.assertEquals(petsName,secondPetsName.getText());
        Assert.assertEquals(petType,secondPetsType.getText());
        LocalDateTime a = LocalDateTime.ofEpochSecond(birthDate.getTime(),0, ZoneOffset.UTC).minusDays(1);
        Assert.assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH).format(a),secondPetsBirthDate.getText());

    }

    public void addVisitToFirstPet() {
        Graphene.guardHttp(newVisitForFirstPet).click();
    }

    public void assertFirstVisitToFirstPet(Date visitDate, String description) {
        LocalDateTime a = LocalDateTime.ofEpochSecond(visitDate.getTime(),0, ZoneOffset.UTC).minusDays(1);
        Assert.assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH).format(a),firstPetsFirstVisitDate.getText());
        Assert.assertEquals(description,firstPetsFirstVisitDescription.getText());
    }
}
