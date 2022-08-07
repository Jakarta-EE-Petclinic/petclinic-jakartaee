/*
All the code that follow is
Copyright (c) 2022, Thomas Woehlke. All Rights Reserved.
Not for reuse without permission.
*/

package org.woehlke.jakartaee.petclinic.it.ui.pages;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.owner.views.OwnerFlowState;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import static java.text.DateFormat.SHORT;


@Location("owner.jsf")
public class OwnerPage implements OwnerFlowStatePage {

    @Drone
    private WebDriver driver;

    @FindBy(id="ownerViewFlowFlowState")
    private GrapheneElement ownerFlowState;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    private GrapheneElement showNewFormButton;

    @FindBy(id = "addNewOwnerForm:cancelAddNewOwner")
    private GrapheneElement cancelNewButton;

    @FindBy(id = "detailsOwnerForm:showEditFormButtonInList")
    private GrapheneElement showEditFormButton;

    @FindBy(id = "editOwnerForm:cancelEditOwner")
    private GrapheneElement cancelEditButton;

    @FindBy(id = "detailsOwnerForm:deleteSelectedButton")
    private GrapheneElement showDeleteFormButton;

    @FindBy(id="deleteOwnerForm:cancelDeleteOwner")
    private GrapheneElement canceDeleteButton;

    @FindBy(id = "findEntityForm:searchButton")
    private GrapheneElement searchButton;

    @FindBy(id = "findEntityForm:clearSearchButton")
    private GrapheneElement clearSearchButton;

    @FindBy(id = "entityDataTableForm:entityDataTable:0:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton0;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton1;

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton2;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton4;

    @FindBy(id="detailsOwnerForm:cancelDetailsOwner")
    private GrapheneElement cancelDetailsButton;

    @FindBy(id="detailsOwnerForm:addNewPetButton")
    private GrapheneElement addNewPetButton;

    @FindBy(id="addNewPetForm:cancelButtonAddNewOwnersPet")
    private GrapheneElement cancelNewPetButton;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:0:addVisitButton")
    private GrapheneElement addVisitButton;

    @FindBy(id="addVisitForm:cancelAddNewOwnersPetVisit")
    private GrapheneElement cancelNewVisitButton;

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

    @FindBy(id="addNewOwnerForm:firstNameAddNewOwner")
    private GrapheneElement newOwnerInputFirstName;

    @FindBy(id="addNewOwnerForm:lastNameAddNewOwner")
    private GrapheneElement newOwnerInputLastName;

    @FindBy(id="addNewOwnerForm:addressAddNewOwner")
    private GrapheneElement newOwnerInputAddress;

    @FindBy(id="addNewOwnerForm:houseNumberAddNewOwner")
    private GrapheneElement newOwnerInputHouseNumber;

    @FindBy(id="addNewOwnerForm:addressInfoAddNewOwner")
    private GrapheneElement newOwnerInputAddressInfo;

    @FindBy(id="addNewOwnerForm:cityAddNewOwner")
    private GrapheneElement newOwnerInputCity;

    @FindBy(id="addNewOwnerForm:zipCodeAddNewOwner")
    private GrapheneElement newOwnerZipCode;

    @FindBy(id="addNewOwnerForm:phoneNumberAddNewOwner")
    private GrapheneElement newOwnerPhoneNumber;

    @FindBy(id="addNewOwnerForm:emailAddNewOwner")
    private GrapheneElement newOwnerEmail;

    @FindBy(id="addNewOwnerForm:saveAddNewOwner")
    private GrapheneElement newOwnerSaveButton;

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
    private GrapheneElement editOwnerInputFirstName;

    @FindBy(id="editOwnerForm:lastNameEditOwner")
    private GrapheneElement editOwnerInputLastName;

    @FindBy(id="editOwnerForm:addressEditOwner")
    private GrapheneElement editOwnerInputAddress;

    @FindBy(id="editOwnerForm:houseNumberEditOwner")
    private GrapheneElement editOwnerInputHouseNumber;

    @FindBy(id="editOwnerForm:addressInfoEditOwner")
    private GrapheneElement editOwnerInputAddressInfo;

    @FindBy(id="editOwnerForm:cityEditOwner")
    private GrapheneElement editOwnerInputCity;

    @FindBy(id="editOwnerForm:zipCodeEditOwner")
    private GrapheneElement editOwnerZipCode;

    @FindBy(id="editOwnerForm:phoneNumberEditOwner")
    private GrapheneElement editOwnerPhoneNumber;

    @FindBy(id="editOwnerForm:emailEditOwner")
    private GrapheneElement editOwnerEmail;

    @FindBy(id="editOwnerForm:saveEditOwner")
    private GrapheneElement editOwnerSaveButton;

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
    private GrapheneElement deleteOwnerSaveButton;

    public OwnerPage clickSaveDeleteButton() {
        Graphene.guardHttp(deleteOwnerSaveButton).click();
        return this;
    }

    @FindBy(id="addNewPetForm:petNameAddNewOwnersPet")
    private GrapheneElement petNameAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:petBirthDateAddNewOwnersPet_input")
    private GrapheneElement petBirthDateAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:petTypeAddNewOwnersPet")
    private WebElement petTypeAddNewOwnersPetDiv;

    @FindBy(id="addNewPetForm:petTypeAddNewOwnersPet_input")
    private Select petTypeAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:saveButtonAddNewOwnersPet")
    private GrapheneElement newOwnersPetSaveButton;

    private final DateFormat df = DateFormat.getDateInstance(SHORT, Locale.US);

    public OwnerPage clickAddAndSaveNewPet(Pet pet) {
        int option = 1;
        petTypeAddNewOwnersPetDiv.click();
        petNameAddNewOwnersPetInput.sendKeys(pet.getName());
        petBirthDateAddNewOwnersPetInput.sendKeys(df.format(pet.getBirthDate()));
        petTypeAddNewOwnersPetInput.selectByIndex(option);
        newOwnersPetSaveButton.sendKeys(Keys.DOWN);
        newOwnersPetSaveButton.sendKeys(Keys.END);
        newOwnersPetSaveButton.sendKeys(Keys.ENTER);
        //Graphene.guardHttp(newOwnersPetSaveButton).click();
        return this;
    }

    @FindBy(id="addVisitForm:visitDate_input")
    private WebElement newVisitDateInput;

    @FindBy(id="addVisitForm:visitDescription")
    private WebElement newVisitDescriptionInput;

    @FindBy(id="addVisitForm:saveAddNewOwnersPetVisit")
    private GrapheneElement newVisitSaveButton;

    public OwnerPage clickAddAndSaveNewVisitButton(Date datum, String description) {
        newVisitDateInput.sendKeys(df.format(datum));
        newVisitDescriptionInput.sendKeys(description);
        newVisitSaveButton.click();
        return this;
    }
}
