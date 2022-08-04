/*
All the code that follow is
Copyright (c) 2022, Thomas Woehlke. All Rights Reserved.
Not for reuse without permission.
*/

package org.woehlke.jakartaee.petclinic.it.ui.pages;
import java.util.Map;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudFlowState;


@Location("veterinarian.jsf")
public class VeterinarianPage implements CrudFlowStatePage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id="veterinarianViewFlowFlowState")
    private WebElement crudFlowState;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    @CacheLookup
    private WebElement addNewVeterinarian;

    @FindBy(id = "j_idt14:j_idt23_focus")
    @CacheLookup
    private WebElement englisch1;

    @FindBy(id = "j_idt14:j_idt23_input")
    @CacheLookup
    private WebElement englisch2;

    @FindBy(id = "findEntityForm:inputTextSearchterm")
    @CacheLookup
    private WebElement firstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDer;

    @FindBy(css = "a[href='home.jsf']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='info.jsf']")
    @CacheLookup
    private WebElement information;

    @FindBy(css = "a[href='owner.jsf']")
    @CacheLookup
    private WebElement owners;

    private final String pageLoadedText = "© 2019-2022 Thomas Wöhlke";

    private final String pageUrl = "/petclinic/veterinarian.jsf";

    @FindBy(css = "a[href='petType.jsf']")
    @CacheLookup
    private WebElement petTypes;

    @FindBy(css = "a[href='specialty.jsf']")
    @CacheLookup
    private WebElement specialties;

    @FindBy(id = "j_idt14:j_idt25")
    @CacheLookup
    private WebElement uibutton1;

    @FindBy(id = "findEntityForm:searchButton")
    @CacheLookup
    private WebElement uibutton2;

    @FindBy(id = "findEntityForm:clearSearchButton")
    @CacheLookup
    private WebElement uibutton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:0:showDetailsFormButton")
    @CacheLookup
    private WebElement uibutton4;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    @CacheLookup
    private WebElement uibutton5;

    @FindBy(css = "a[href='veterinarian.jsf']")
    @CacheLookup
    private WebElement veterinarians;

    @FindBy(css = "a[href='./rest/vet/list']")
    @CacheLookup
    private WebElement viewAsJson;

    @FindBy(css = "a[href='./rest/vet/xml/list']")
    @CacheLookup
    private WebElement viewAsXml;

    public VeterinarianPage() {
    }

    public VeterinarianPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public VeterinarianPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public VeterinarianPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Add New Veterinarian Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickAddNewVeterinarianButton() {
        addNewVeterinarian.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Information Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickInformationLink() {
        information.click();
        return this;
    }

    /**
     * Click on Owners Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickOwnersLink() {
        owners.click();
        return this;
    }

    /**
     * Click on Pet Types Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickPetTypesLink() {
        petTypes.click();
        return this;
    }

    /**
     * Click on Specialties Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickSpecialtiesLink() {
        specialties.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickUibutton1Button() {
        uibutton1.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickUibutton2Button() {
        uibutton2.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickUibutton3Button() {
        uibutton3.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickUibutton4Button() {
        uibutton4.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickUibutton5Button() {
        uibutton5.click();
        return this;
    }

    /**
     * Click on Veterinarians Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickVeterinariansLink() {
        veterinarians.click();
        return this;
    }

    /**
     * Click on View As Json Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickViewAsJsonLink() {
        viewAsJson.click();
        return this;
    }

    /**
     * Click on View As Xml Link.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage clickViewAsXmlLink() {
        viewAsXml.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage fill() {
        setEnglisch1DropDownListField();
        setEnglisch2DropDownListField();
        setFirstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerTextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setEnglisch1DropDownListField() {
        return setEnglisch1DropDownListField(data.get("ENGLISCH_1"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setEnglisch1DropDownListField(String englisch1Value) {
        englisch1.sendKeys(englisch1Value);
        return this;
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setEnglisch2DropDownListField() {
        return setEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).selectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Set default value to First Namespecialtieshugoneurosurgeon Cardiologist Radiologist Von Der Vogelweideoncologist Dentist Dermatologist Surgeon Uibutton Text field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setFirstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerTextField() {
        return setFirstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerTextField(data.get("FIRST_NAMESPECIALTIESHUGONEUROSURGEON_CARDIOLOGIST_RADIOLOGIST_VON_DER"));
    }

    /**
     * Set value to First Namespecialtieshugoneurosurgeon Cardiologist Radiologist Von Der Vogelweideoncologist Dentist Dermatologist Surgeon Uibutton Text field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage setFirstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerTextField(String firstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerValue) {
        firstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDer.sendKeys(firstNamespecialtieshugoneurosurgeonCardiologistRadiologistVonDerValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage submit() {
        // TODO
        // clickUibuttonButton();
        return this;
    }

    /**
     * Unset default value from Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage unsetEnglisch2DropDownListField() {
        return unsetEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Unset value from Englisch Drop Down List field.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage unsetEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).deselectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the VeterinariansPage class instance.
     */
    public VeterinarianPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public void clickAddNewEntityButton() {

    }

    public void clickCancelNewEntityButton() {

    }

    public void clickShowDetailsFormButton0() {

    }

    public void clickCancelDetailsButton() {

    }

    public void clickShowEditForm() {

    }

    public void clickCancelEditButton() {

    }

    public void clickShowDetailsFormButton1() {

    }

    public void clickShowDeleteForm() {

    }

    public void clickCancelDeleteButton() {

    }


    @Override
    public boolean isFlowStateList() {
        return CrudFlowState.LIST.name().compareTo(crudFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDetails() {
        return CrudFlowState.DETAILS.name().compareTo(crudFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNew() {
        return CrudFlowState.NEW.name().compareTo(crudFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateEdit() {
        return CrudFlowState.EDIT.name().compareTo(crudFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDelete() {
        return CrudFlowState.DELETE.name().compareTo(crudFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return CrudFlowState.LIST_SEARCH_RESULT.name().compareTo(crudFlowState.getText())==0;
    }
}
