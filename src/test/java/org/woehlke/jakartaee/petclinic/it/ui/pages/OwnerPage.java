/*
All the code that follow is
Copyright (c) 2022, Thomas Woehlke. All Rights Reserved.
Not for reuse without permission.
*/

package org.woehlke.jakartaee.petclinic.it.ui.pages;
import java.util.Map;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.owner.views.OwnerFlowState;


@Location("owner.jsf")
public class OwnerPage implements OwnerFlowStatePage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id="ownerViewFlowFlowState")
    private WebElement ownerFlowState;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    private WebElement showNewFormButton;

    @FindBy(id = "addNewOwnerForm:cancelAddNewOwner")
    private WebElement cancelNewButton;

    @FindBy(id = "detailsOwnerForm:showEditFormButtonInList")
    private WebElement showEditFormButton;

    @FindBy(id = "editOwnerForm:cancelEditOwner")
    private WebElement cancelEditButton;

    @FindBy(id = "detailsOwnerForm:deleteSelectedButton")
    private WebElement showDeleteFormButton;

    @FindBy(id="deleteOwnerForm:cancelDeleteOwner")
    private WebElement canceDeleteButton;

    @FindBy(id = "findEntityForm:searchButton")
    private WebElement searchButton;

    @FindBy(id = "findEntityForm:clearSearchButton")
    private WebElement clearSearchButton;

    @FindBy(id = "entityDataTableForm:entityDataTable:0:showDetailsFormButton")
    private WebElement showDetailsFormButton0;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    private WebElement showDetailsFormButton1;

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    private WebElement showDetailsFormButton2;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    private WebElement showDetailsFormButton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    private WebElement showDetailsFormButton4;

    @FindBy(id="detailsOwnerForm:cancelDetailsOwner")
    private WebElement cancelDetailsButton;

    @FindBy(id="detailsOwnerForm:addNewPetButton")
    private WebElement addNewPetButton;

    @FindBy(id="addNewPetForm:cancelButtonAddNewOwnersPet")
    private WebElement cancelNewPetButton;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:0:addVisitButton")
    private WebElement addVisitButton;

    @FindBy(id="addVisitForm:cancelAddNewOwnersPetVisit")
    private WebElement cancelNewVisitButton;

    public OwnerPage clickAddNewEntityButton() {
        Graphene.guardHttp(showNewFormButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewEntityButton() {
        Graphene.guardHttp(cancelNewButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowEditForm() {
        Graphene.guardHttp(showEditFormButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickCancelEditButton() {
        Graphene.guardHttp(cancelEditButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDeleteForm() {
        Graphene.guardHttp(showDeleteFormButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickCancelDeleteButton() {
        Graphene.guardHttp(canceDeleteButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickSearchButton() {
        Graphene.guardHttp(searchButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 clickClearSearchButton() {
        Graphene.guardHttp(clearSearchButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton0() {
        Graphene.guardHttp(showDetailsFormButton0).click();
        fullscreen();
        return this;
    }

    public void fullscreen(){
        driver.manage().window().fullscreen();
    }

    public OwnerPage clickShowDetailsFormButton1() {
        Graphene.guardHttp(showDetailsFormButton1).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton2() {
        Graphene.guardHttp(showDetailsFormButton2).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton3() {
        Graphene.guardHttp(showDetailsFormButton3).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton4() {
        Graphene.guardHttp(showDetailsFormButton4).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton(int i) {
        switch (i){
            case 0: clickShowDetailsFormButton0(); break;
            case 1: clickShowDetailsFormButton1(); break;
            case 2: clickShowDetailsFormButton2(); break;
            case 3: clickShowDetailsFormButton3(); break;
            case 4: clickShowDetailsFormButton4(); break;
            default: break;
        }
        return this;
    }

    public OwnerPage clickCancelDetailsButton() {
        //Graphene.guardHttp(cancelDetailsButton).click();
        cancelDetailsButton.sendKeys(Keys.DOWN);
        cancelDetailsButton.sendKeys(Keys.ENTER);
        fullscreen();
        return this;
    }

    public OwnerPage clickAddNewPetButton() {
        //Graphene.waitModel(driver).until().element(addNewPetButton).is().enabled();
        //Actions action = new Actions(driver);
        //action.moveToElement(addNewPetButton).pause(1000).perform();
        addNewPetButton.sendKeys(Keys.DOWN);
        addNewPetButton.sendKeys(Keys.ENTER);
        //Graphene.guardHttp(addNewPetButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewPetButton() {
        //Graphene.waitModel(driver).until().element(cancelNewPetButton).is().enabled();
        Graphene.guardHttp(cancelNewPetButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickAddNewVisitButton() {
        //Graphene.waitModel(driver).until().element(addNewVisitButton).is().enabled();
        //Actions action = new Actions(driver);
        //action.moveToElement(addNewVisitButton).pause(1000).perform();
        addVisitButton.sendKeys(Keys.DOWN);
        addVisitButton.sendKeys(Keys.END);
        addVisitButton.sendKeys(Keys.ENTER);
        //Graphene.guardHttp(addNewVisitButton).click();
        fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewVisitButton() {
        //Graphene.waitModel(driver).until().element(cancelNewVisitButton).is().enabled();
        Graphene.guardHttp(cancelNewVisitButton).click();
        fullscreen();
        return this;
    }

    @Override
    public boolean isFlowStateList() {
        return OwnerFlowState.LIST.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDetails() {
        return OwnerFlowState.DETAILS.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNew() {
        return OwnerFlowState.NEW_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateEdit() {
        return OwnerFlowState.EDIT_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDelete() {
        return OwnerFlowState.DELETE_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return OwnerFlowState.LIST_SEARCH_RESULT.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNewPet() {
        return OwnerFlowState.NEW_PET.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateEditPet() {
        return OwnerFlowState.EDIT_PET.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNewVisit() {
        return OwnerFlowState.NEW_VISIT.name().compareTo(ownerFlowState.getText())==0;
    }

    public OwnerPage() {
    }

    public OwnerPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public OwnerPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public OwnerPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    @FindBy(id="addNewOwnerForm:firstNameAddNewOwner")
    private WebElement newOwnerInputFirstName;

    @FindBy(id="addNewOwnerForm:lastNameAddNewOwner")
    private WebElement newOwnerInputLastName;

    @FindBy(id="addNewOwnerForm:addressAddNewOwner")
    private WebElement newOwnerInputAddress;

    @FindBy(id="addNewOwnerForm:houseNumberAddNewOwner")
    private WebElement newOwnerInputHouseNumber;

    @FindBy(id="addNewOwnerForm:addressInfoAddNewOwner")
    private WebElement newOwnerInputAddressInfo;

    @FindBy(id="addNewOwnerForm:cityAddNewOwner")
    private WebElement newOwnerInputCity;

    @FindBy(id="addNewOwnerForm:zipCodeAddNewOwner")
    private WebElement newOwnerZipCode;

    @FindBy(id="addNewOwnerForm:phoneNumberAddNewOwner")
    private WebElement newOwnerPhoneNumber;

    @FindBy(id="addNewOwnerForm:emailAddNewOwner")
    private WebElement newOwnerEmail;

    @FindBy(id="addNewOwnerForm:saveAddNewOwner")
    private WebElement newOwnerSaveButton;

    public OwnerPage addNewEntity(Owner o) {
        if(null != o.getAddressInfo()){
            newOwnerInputAddressInfo.sendKeys(o.getAddressInfo());
        }
        newOwnerInputFirstName.sendKeys(o.getFirstName());
        newOwnerInputLastName.sendKeys(o.getLastName());
        newOwnerInputAddress.sendKeys(o.getAddress());
        newOwnerInputHouseNumber.sendKeys(o.getHouseNumber());
        newOwnerInputCity.sendKeys(o.getCity());
        newOwnerZipCode.sendKeys(o.getZipCode());
        newOwnerPhoneNumber.sendKeys(o.getPhoneNumber());
        newOwnerEmail.sendKeys(o.getEmail());
        Graphene.guardHttp(newOwnerSaveButton).click();
        return this;
    }

    @FindBy(id="editOwnerForm:firstNameEditOwner")
    private WebElement editOwnerInputFirstName;

    @FindBy(id="editOwnerForm:lastNameEditOwner")
    private WebElement editOwnerInputLastName;

    @FindBy(id="editOwnerForm:addressEditOwner")
    private WebElement editOwnerInputAddress;

    @FindBy(id="editOwnerForm:houseNumberEditOwner")
    private WebElement editOwnerInputHouseNumber;

    @FindBy(id="editOwnerForm:addressInfoEditOwner")
    private WebElement editOwnerInputAddressInfo;

    @FindBy(id="editOwnerForm:cityEditOwner")
    private WebElement editOwnerInputCity;

    @FindBy(id="editOwnerForm:zipCodeEditOwner")
    private WebElement editOwnerZipCode;

    @FindBy(id="editOwnerForm:phoneNumberEditOwner")
    private WebElement editOwnerPhoneNumber;

    @FindBy(id="editOwnerForm:emailEditOwner")
    private WebElement editOwnerEmail;

    @FindBy(id="editOwnerForm:saveEditOwner")
    private WebElement editOwnerSaveButton;

    public OwnerPage editNameAddString() {
        String firstName = editOwnerInputFirstName.getText();
        String lastName = editOwnerInputLastName.getText();
        String address = editOwnerInputAddress.getText();
        String houseNumber = editOwnerInputHouseNumber.getText();
        String addressInfo = editOwnerInputAddressInfo.getText();
        String city = editOwnerInputCity.getText();
        String zipCode = editOwnerZipCode.getText();
        String phoneNumber = editOwnerPhoneNumber.getText();
        String email = editOwnerEmail.getText();
        firstName += "Test";
        lastName += "TEST";
        address += " XY";
        houseNumber += " 33";
        if(null != addressInfo){
            addressInfo += " TeST";
            editOwnerInputAddressInfo.sendKeys(addressInfo);
        }
        city += " ZZ";
        zipCode += "99";
        phoneNumber += "77";
        editOwnerInputFirstName.sendKeys(firstName);
        editOwnerInputLastName.sendKeys(lastName);
        editOwnerInputAddress.sendKeys(address);
        editOwnerInputHouseNumber.sendKeys(houseNumber);
        editOwnerInputCity.sendKeys(city);
        editOwnerZipCode.sendKeys(zipCode);
        editOwnerPhoneNumber.sendKeys(phoneNumber);
        editOwnerEmail.sendKeys(email);
        Graphene.guardHttp(editOwnerSaveButton).click();
        return this;
    }

    @FindBy(id="deleteOwnerForm:confirmDeleteButton")
    private WebElement deleteOwnerSaveButton;

    public OwnerPage clickSaveDeleteButton() {
        Graphene.guardHttp(deleteOwnerSaveButton).click();
        return this;
    }

    public OwnerPage clickAddAndSaveNewPet() {
        return this;
    }
}
