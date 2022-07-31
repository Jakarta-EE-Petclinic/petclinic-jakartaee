package org.woehlke.jakartaee.petclinic.it.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.component.Calendar;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 28.01.14
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class NewVisitPage {

    @FindBy(id="addVisitForm")
    private WebElement addVisitForm;

    @FindBy(id="addVisitForm:petName")
    private WebElement petName;

    @FindBy(id="addVisitForm:petBirthDate")
    private WebElement petBirthDate;

    @FindBy(id="addVisitForm:petType")
    private WebElement petType;

    @FindBy(id="addVisitForm:ownerFirstName")
    private WebElement ownerFirstName;

    @FindBy(id="addVisitForm:ownerLastName")
    private WebElement ownerLastName;

    @FindBy(id="addVisitForm:visitDate")
    private Calendar visitDate;

    @FindBy(id="addVisitForm:visitDescription")
    private WebElement visitDescription;

    @FindBy(id="addVisitForm:save")
    private WebElement save;

    public void assertPageIsLoaded() {
        Assert.assertTrue(addVisitForm.isDisplayed());
    }

    public void assertOwnerContent(String firstName, String lastName) {
        Assert.assertEquals(firstName,ownerFirstName.getText());
        Assert.assertEquals(lastName,ownerLastName.getText());
    }

    public void assertPetContent(String petName, Date birthDate, String petType) {
        Assert.assertEquals(petName, this.petName.getText());
        Assert.assertEquals(petType, this.petType.getText());
        LocalDateTime a = LocalDateTime.ofEpochSecond(birthDate.getTime(),0, ZoneOffset.UTC).minusDays(1);
        Assert.assertEquals(
                DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH).format(a),
                petBirthDate.getText()
        );
    }

    public void setNewContent(Date visitDate, String description) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(visitDate.getTime(),0, ZoneOffset.UTC);
        Graphene.waitModel().until().element(addVisitForm).is().visible();
        this.visitDescription.sendKeys(description);
        this.visitDate.setDate(dateTime);
        Graphene.guardHttp(save).click();
    }
}
