package org.woehlke.jakartaee.petclinic.tmp.pages;

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
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class EditPetPage {

    @FindBy(id="editPetForm")
    private WebElement editPetForm;

    @FindBy(id="editPetForm:petName")
    private WebElement petName;

    @FindBy(id="editPetForm:petBirthDate")
    private Calendar petBirthDate;

    @FindBy(id="editPetForm:petType")
    private WebElement petType;

    @FindBy(id="editPetForm:save")
    private WebElement save;

    public void assertPageIsLoaded() {
        Assert.assertTrue(editPetForm.isDisplayed());
    }

    public void setContent(String petName, Date petBirthDate, String petType) {
        this.petName.clear();
        this.petName.sendKeys(petName);
        this.petBirthDate.setDate(petBirthDate.getTime());
        List<WebElement> options = this.petType.findElements(By.tagName("option"));
        for(WebElement option: options){
            if(option.getText().contentEquals(petType)){
                option.click();
                break;
            }
        }
        save.click();
    }
}
