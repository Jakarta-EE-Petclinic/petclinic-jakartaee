package org.woehlke.jakartaee.petclinic.tmp.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.component.Calendar;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 27.01.14
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public class NewPetPage {

    @FindBy(id="addNewPetForm")
    private WebElement addNewPetForm;

    @FindBy(id="addNewPetForm:petName")
    private WebElement petName;

    @FindBy(id="addNewPetForm:petBirthDate")
    private Calendar petBirthDate;

    @FindBy(id="addNewPetForm:petType")
    private WebElement petType;

    @FindBy(id="addNewPetForm:add")
    private WebElement add;

    public void assertPageIsLoaded() {
        Graphene.waitModel().until().element(addNewPetForm).is().visible();
        Assert.assertTrue(addNewPetForm.isDisplayed());
    }

    public void setContent(String petName, Date petBirthDate, String petType){
        this.petName.sendKeys(petName);
        this.petBirthDate.setDate(petBirthDate.getTime());
        List<WebElement> options = this.petType.findElements(By.tagName("option"));
        for(WebElement option: options){
            if(option.getText().contentEquals(petType)){
                option.click();
                break;
            }
        }
        Graphene.guardHttp(add).click();
    }
}
