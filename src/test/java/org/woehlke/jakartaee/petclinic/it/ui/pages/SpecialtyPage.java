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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.primefaces.selenium.component.CommandButton;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudFlowState;


@Location("specialty.jsf")
public class SpecialtyPage implements CrudFlowStatePage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div/div/h1/span[@class='contentTitleHeadlineText']")
    private WebElement pageTitle;

    @FindBy(id="specialtyViewFlowFlowState")
    private WebElement crudFlowState;

    /**
     * Click on Add New Specialty Button.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickAddNewSpecialtyButton() {
       Graphene.guardHttp(showNewFormButton).click();
       return this;
    }

    public SpecialtyPage clickCancelNewSpecialtyButton() {
        Graphene.guardHttp(cancelNewSpecialty).click();
        return this;
    }

    public SpecialtyPage clickShowEditForm() {
        Graphene.guardHttp(showEditFormButton).click();
        return this;
    }

    public SpecialtyPage clickCancelEditButton() {
        Graphene.guardHttp(cancelEditButton).click();
        return this;
    }

    public SpecialtyPage clickShowDeleteForm() {
        Graphene.guardHttp(showDeleteFormButton).click();
        return this;
    }

    public SpecialtyPage clickCancelDeleteButton() {
        Graphene.guardHttp(canceDeleteButton).click();
        return this;
    }

    @FindBy(xpath = "/html/body/div[1]/section[2]/div/form[@id='addNewEntityForm']/div/div[@id='addNewEntityFormPanel_content']/div[3]/div[1]/button[@id='cancelNew']")
    private CommandButton cancelNewSpecialty;

    //@FindBy(xpath = "/html/body/div[1]/section[2]/div/div/div[@id='contentPanel_content']/form[@id='entityDataTableForm']/div[2]/div[1]/button[@id='showNewFormButton']")
    @FindBy(id = "showNewFormButton")
    private CommandButton showNewFormButton;

    @FindBy(xpath = "/html/body/div[1]/section[2]/div/form[@id='detailsEntityForm']/div/div[@id='detailsEntityFormPanel_content']/div[3]/div[2]/button[@id='showEditFormButton']")
    private CommandButton showEditFormButton;

    @FindBy(id = "entityDataTableForm:cancelEdit")
    private CommandButton cancelEditButton;

    @FindBy(xpath = "/html/body/div[1]/section[2]/div/form[@id='detailsEntityForm']/div/div[@id='detailsEntityFormPanel_content']/div[3]/div[3]/button[@id='showEditFormButton']")
    private CommandButton showDeleteFormButton;

    @FindBy(id="detailsEntityForm:canceDelete")
    private CommandButton canceDeleteButton;

    @FindBy(id = "findEntityForm:searchButton")
    private CommandButton searchButton;

    @FindBy(id = "findEntityForm:clearSearchButton")
    private CommandButton clearSearchButton;

    @FindBy(xpath = "/html/body/div[1]/section[2]/div/div/div[@id='contentPanel_content']/form[@id='entityDataTableForm']/div[1]/div/div/div[1]/table/tbody/tr[1]/td[2]/button/@name")
    private CommandButton showDetailsFormButton0;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    private CommandButton showDetailsFormButton1;

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    private CommandButton showDetailsFormButton2;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    private CommandButton showDetailsFormButton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    private CommandButton showDetailsFormButton4;

    @FindBy(xpath = "/html/body/div[1]/section[2]/div/form[@id='detailsEntityForm']/div/div[@id='detailsEntityFormPanel_content']/div[3]/div[1]/button[@id='cancelDetails']")
    private CommandButton cancelDetailsButton;


    public SpecialtyPage clickSearchButton() {
        Graphene.guardHttp(searchButton).click();
        return this;
    }

    public SpecialtyPage clickClearSearchButton() {
        Graphene.guardHttp(clearSearchButton).click();
        return this;
    }

    public SpecialtyPage clickShowDetailsFormButton0() {
        Graphene.guardHttp(showDetailsFormButton0).click();
        return this;
    }

    public SpecialtyPage clickShowDetailsFormButton1() {
        Graphene.guardHttp(showDetailsFormButton1).click();
        return this;
    }

    public SpecialtyPage clickShowDetailsFormButton2() {
        Graphene.guardHttp(showDetailsFormButton2).click();
        return this;
    }

    public SpecialtyPage clickShowDetailsFormButton3() {
        Graphene.guardHttp(showDetailsFormButton3).click();
        return this;
    }

    public SpecialtyPage clickShowDetailsFormButton4() {
        Graphene.guardHttp(showDetailsFormButton4).click();
        return this;
    }

    public SpecialtyPage clickCancelDetailsButton() {
        Graphene.guardHttp(cancelDetailsButton).click();
        return this;
    }

    /**
     * Click on View As Json Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickViewAsJsonLink() {
        // viewAsJson.click();
        return this;
    }

    /**
     * Click on View As Xml Link.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage clickViewAsXmlLink() {
        // viewAsXml.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage verifyPageLoaded() {
        /*
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        */
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the SpecialtyPage class instance.
     */
    public SpecialtyPage verifyPageUrl() {
        /*
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        */
        return this;
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
}
