package org.woehlke.jakartaee.petclinic.tmp.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.component.picklist.PickList;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 26.01.14
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class EditVetPage {

    @FindBy(id="editVeterinarian")
    private WebElement editVeterinarian;

    @FindBy(id="editVeterinarianForm:firstName")
    private WebElement firstName;

    @FindBy(id="editVeterinarianForm:lastName")
    private WebElement lastName;

    @FindBy(id="editVeterinarianForm:selectedSpecialtiesPickList")
    private PickList pickList;

    @FindBy(id="editVeterinarianForm:save")
    private WebElement save;

    public void assertPageIsLoaded() {
        Assert.assertTrue(editVeterinarian.isDisplayed());
    }

    public void editContent(String firstName,String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        save.click();
    }

    public void editContentWithNoneSpecialties(String firstName,String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.pickList.getRemoveAllLabel();
        save.click();
    }

    public void editContentWithAllSpecialties(String firstName,String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.pickList.getAddAllLabel();
        save.click();
    }
}
