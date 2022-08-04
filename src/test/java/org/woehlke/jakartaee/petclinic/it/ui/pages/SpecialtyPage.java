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
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudFlowState;


@Location("specialty.jsf")
public class SpecialtyPage implements CrudFlowStatePage {
    private Map<String, String> data;
    @Drone
    private WebDriver browser;

    @FindBy(id="specialtyViewFlowFlowState")
    private WebElement crudFlowState;
    @FindBy(id = "entityDataTableForm:showNewFormButton")
    private WebElement showNewFormButton;

    @FindBy(id = "addNewEntityForm:cancelNew")
    private WebElement cancelNewButton;

    @FindBy(id = "detailsEntityForm:showEditFormButton")
    private WebElement showEditFormButton;

    @FindBy(id = "editEntityForm:cancelEdit")
    private WebElement cancelEditButton;

    @FindBy(id = "detailsEntityForm:deleteSelectedButton")
    private WebElement showDeleteFormButton;

    @FindBy(id="deleteEntityForm:cancelDelete")
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

   @FindBy(id="detailsEntityForm:cancelDetails")
    private WebElement cancelDetailsButton;

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
        Graphene.guardHttp(cancelNewButton).click();
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
        this.browser = driver;
    }

    public SpecialtyPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

}
