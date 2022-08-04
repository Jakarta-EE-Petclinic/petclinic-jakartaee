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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Location("petType.jsf")
public class PetTypePage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "listEntityHeaderId")
    private WebElement pageTitle;

    @FindBy(css = "a.ui-paginator-page.ui-state-default.ui-state-active.ui-corner-all")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = "#entityDataTableForm:entityDataTable_paginator_bottom span.ui-paginator-pages a:nth-of-type(2)")
    @CacheLookup
    private WebElement _2;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    @CacheLookup
    private WebElement addNewPetType;

    @FindBy(css = "a.ui-paginator-last.ui-state-default.ui-corner-all")
    @CacheLookup
    private WebElement e;

    @FindBy(id = "j_idt14:j_idt23_focus")
    @CacheLookup
    private WebElement englisch1;

    @FindBy(id = "j_idt14:j_idt23_input")
    @CacheLookup
    private WebElement englisch2;

    @FindBy(id = "findEntityForm:inputTextSearchterm")
    @CacheLookup
    private WebElement englisch3;

    @FindBy(css = "a.ui-paginator-first.ui-state-default.ui-corner-all.ui-state-disabled")
    @CacheLookup
    private WebElement f;

    @FindBy(css = "a[href='home.jsf']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='info.jsf']")
    @CacheLookup
    private WebElement information;

    @FindBy(css = "a.ui-paginator-next.ui-state-default.ui-corner-all")
    @CacheLookup
    private WebElement n;

    @FindBy(css = "a[href='owner.jsf']")
    @CacheLookup
    private WebElement owners;

    @FindBy(css = "a.ui-paginator-prev.ui-state-default.ui-corner-all.ui-state-disabled")
    @CacheLookup
    private WebElement p;

    private final String pageLoadedText = "© 2019-2022 Thomas Wöhlke";

    private final String pageUrl = "/petclinic/petType.jsf";

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

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    @CacheLookup
    private WebElement uibutton6;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    @CacheLookup
    private WebElement uibutton7;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    @CacheLookup
    private WebElement uibutton8;

    @FindBy(css = "a[href='veterinarian.jsf']")
    @CacheLookup
    private WebElement veterinarians;

    @FindBy(css = "a[href='./rest/petType/list']")
    @CacheLookup
    private WebElement viewAsJson;

    @FindBy(css = "a[href='./rest/petType/xml/list']")
    @CacheLookup
    private WebElement viewAsXml;

    public PetTypePage() {
    }

    public PetTypePage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public PetTypePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public PetTypePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Add New Pet Type Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickAddNewPetTypeButton() {
        addNewPetType.click();
        return this;
    }

    /**
     * Click on E Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickELink() {
        e.click();
        return this;
    }

    /**
     * Click on F Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickFLink() {
        f.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Information Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickInformationLink() {
        information.click();
        return this;
    }

    /**
     * Click on 1 Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickLink1() {
        _1.click();
        return this;
    }

    /**
     * Click on 2 Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickLink2() {
        _2.click();
        return this;
    }

    /**
     * Click on N Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickNLink() {
        n.click();
        return this;
    }

    /**
     * Click on Owners Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickOwnersLink() {
        owners.click();
        return this;
    }

    /**
     * Click on P Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickPLink() {
        p.click();
        return this;
    }

    /**
     * Click on Pet Types Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickPetTypesLink() {
        petTypes.click();
        return this;
    }

    /**
     * Click on Specialties Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickSpecialtiesLink() {
        specialties.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton1Button() {
        uibutton1.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton2Button() {
        uibutton2.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton3Button() {
        uibutton3.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton4Button() {
        uibutton4.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton5Button() {
        uibutton5.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton6Button() {
        uibutton6.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton7Button() {
        uibutton7.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickUibutton8Button() {
        uibutton8.click();
        return this;
    }

    /**
     * Click on Veterinarians Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickVeterinariansLink() {
        veterinarians.click();
        return this;
    }

    /**
     * Click on View As Json Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickViewAsJsonLink() {
        viewAsJson.click();
        return this;
    }

    /**
     * Click on View As Xml Link.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage clickViewAsXmlLink() {
        viewAsXml.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage fill() {
        setEnglisch1DropDownListField();
        setEnglisch2DropDownListField();
        setEnglisch3TextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch1DropDownListField() {
        return setEnglisch1DropDownListField(data.get("ENGLISCH_1"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch1DropDownListField(String englisch1Value) {
        englisch1.sendKeys(englisch1Value);
        return this;
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch2DropDownListField() {
        return setEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).selectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Set default value to Englisch Text field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch3TextField() {
        return setEnglisch3TextField(data.get("ENGLISCH_3"));
    }

    /**
     * Set value to Englisch Text field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage setEnglisch3TextField(String englisch3Value) {
        englisch3.sendKeys(englisch3Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage submit() {
        // TODO
        // clickUibuttonButton();
        return this;
    }

    /**
     * Unset default value from Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage unsetEnglisch2DropDownListField() {
        return unsetEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Unset value from Englisch Drop Down List field.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage unsetEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).deselectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the PetTypesPage class instance.
     */
    public PetTypePage verifyPageLoaded() {
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
     * @return the PetTypesPage class instance.
     */
    public PetTypePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public void assertPageIsLoaded() {
        assertThat(pageTitle.isDisplayed());
        assertEquals( "Pet Types", pageTitle.getText() );
    }

    public boolean isFlowStateList() {
        return true;
    }

    public void clickAddNewEntityButton() {

    }

    public boolean isFlowStateNew() {
        return false;
    }

    public void clickCancelNewEntityButton() {
    }

    public void clickShowDetailsFormButton0() {

    }

    public boolean isFlowStateDetails() {
        return false;
    }

    public void clickCancelDetailsButton() {

    }

    public void clickShowEditForm() {

    }

    public boolean isFlowStateEdit() {
        return false;
    }

    public void clickCancelEditButton() {

    }

    public boolean isFlowStateDelete() {
        return false;
    }

    public void clickShowDetailsFormButton1() {

    }

    public void clickShowDeleteForm() {

    }

    public void clickCancelDeleteButton() {

    }
}
