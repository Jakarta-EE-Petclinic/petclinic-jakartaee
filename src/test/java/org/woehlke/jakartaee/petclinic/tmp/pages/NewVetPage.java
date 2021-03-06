package org.woehlke.jakartaee.petclinic.tmp.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.component.picklist.PickList;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 26.01.14
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class NewVetPage {

    @FindBy(id="addNewVeterinarian")
    private WebElement addNewVeterinarian;

    @FindBy(id="addNewVeterinarianForm:firstName")
    private WebElement firstName;

    @FindBy(id="addNewVeterinarianForm:lastName")
    private WebElement lastName;

    @FindBy(id="addNewVeterinarianForm:save")
    private WebElement save;

    @FindBy(id="addNewVeterinarianForm:selectedSpecialtiesPickList")
    private PickList pickList;

    public void assertPageIsLoaded() {
        Assert.assertTrue(addNewVeterinarian.isDisplayed());
    }

    public void addNewContent(String firstName,String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        save.click();
    }

    public void addNewContentWithAllSpecialties(String firstName, String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.pickList.getAddAllLabel();
        save.click();
    }

    public void addNewContentWithOneSpecialty(String firstName, String lastName, String specialty) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.pickList.setAddLabel(specialty);
        save.click();
    }
}
