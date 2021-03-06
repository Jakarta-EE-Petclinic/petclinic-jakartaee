/*
All the code that follow is
Copyright (c) 2022, Thomas Woehlke. All Rights Reserved.
Not for reuse without permission.
*/

package org.woehlke.jakartaee.petclinic.it.pages;

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

@Location("specialty.jsf")
public class SpecialtyPage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "#listEntityHeaderId")
    private WebElement pageTitle;

    @FindBy(css = "a.ui-paginator-page.ui-state-default.ui-state-active.ui-corner-all")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = "#entityDataTableForm:entityDataTable_paginator_bottom span.ui-paginator-pages a:nth-of-type(2)")
    @CacheLookup
    private WebElement _2;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    @CacheLookup
    private WebElement addNewSpecialty;

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

    private final String pageLoadedText = "?? 2019-2022 Thomas W??hlke";

    private final String pageUrl = "/petclinic/specialty.jsf";

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
    private WebElement searchButton;

    @FindBy(id = "findEntityForm:clearSearchButton")
    @CacheLookup
    private WebElement clearSearchButton;

    @FindBy(id = "entityDataTableForm:entityDataTable:0:showDetailsFormButton")
    @CacheLookup
    private WebElement showDetailsFormButton0;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    @CacheLookup
    private WebElement showDetailsFormButton1;

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    @CacheLookup
    private WebElement showDetailsFormButton2;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    @CacheLookup
    private WebElement showDetailsFormButton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    @CacheLookup
    private WebElement showDetailsFormButton4;

    @FindBy(css = "a[href='veterinarian.jsf']")
    @CacheLookup
    private WebElement veterinarians;

    @FindBy(css = "a[href='./rest/specialty/list']")
    @CacheLookup
    private WebElement viewAsJson;

    @FindBy(css = "a[href='./rest/specialty/xml/list']")
    @CacheLookup
    private WebElement viewAsXml;

    public SpecialtyPage() {
    }

    public SpecialtyPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public SpecialtyPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public SpecialtyPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Add New Specialty Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickAddNewSpecialtyButton() {
        addNewSpecialty.click();
        return this;
    }

    /**
     * Click on E Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickELink() {
        e.click();
        return this;
    }

    /**
     * Click on F Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickFLink() {
        f.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Information Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickInformationLink() {
        information.click();
        return this;
    }

    /**
     * Click on 1 Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickLink1() {
        _1.click();
        return this;
    }

    /**
     * Click on 2 Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickLink2() {
        _2.click();
        return this;
    }

    /**
     * Click on N Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickNLink() {
        n.click();
        return this;
    }

    /**
     * Click on Owners Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickOwnersLink() {
        owners.click();
        return this;
    }

    /**
     * Click on P Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickPLink() {
        p.click();
        return this;
    }

    /**
     * Click on Pet Types Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickPetTypesLink() {
        petTypes.click();
        return this;
    }

    /**
     * Click on Specialties Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickSpecialtiesLink() {
        specialties.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton1Button() {
        uibutton1.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton2Button() {
        searchButton.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton3Button() {
        clearSearchButton.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton4Button() {
        showDetailsFormButton0.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton5Button() {
        showDetailsFormButton1.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton6Button() {
        showDetailsFormButton2.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton7Button() {
        showDetailsFormButton3.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickUibutton8Button() {
        showDetailsFormButton4.click();
        return this;
    }

    /**
     * Click on Veterinarians Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickVeterinariansLink() {
        veterinarians.click();
        return this;
    }

    /**
     * Click on View As Json Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickViewAsJsonLink() {
        viewAsJson.click();
        return this;
    }

    /**
     * Click on View As Xml Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickViewAsXmlLink() {
        viewAsXml.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage fill() {
        setEnglisch1DropDownListField();
        setEnglisch2DropDownListField();
        setEnglisch3TextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch1DropDownListField() {
        return setEnglisch1DropDownListField(data.get("ENGLISCH_1"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch1DropDownListField(String englisch1Value) {
        englisch1.sendKeys(englisch1Value);
        return this;
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch2DropDownListField() {
        return setEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).selectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Set default value to Englisch Text field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch3TextField() {
        return setEnglisch3TextField(data.get("ENGLISCH_3"));
    }

    /**
     * Set value to Englisch Text field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage setEnglisch3TextField(String englisch3Value) {
        englisch3.sendKeys(englisch3Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage submit() {
        // TODO
        // clickUibuttonButton();
        return this;
    }

    /**
     * Unset default value from Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage unsetEnglisch2DropDownListField() {
        return unsetEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Unset value from Englisch Drop Down List field.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage unsetEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).deselectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage verifyPageLoaded() {
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
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public void assertPageIsLoaded() {
        assertThat(pageTitle.isDisplayed());
        assertEquals( "Specialties", pageTitle.getText() );
    }
}
