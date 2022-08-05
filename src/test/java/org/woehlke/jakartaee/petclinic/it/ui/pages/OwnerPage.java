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
import org.woehlke.jakartaee.petclinic.owner.views.OwnerFlowState;


@Location("owner.jsf")
public class OwnerPage implements CrudFlowStatePage {
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


    public OwnerPage clickAddNewEntityButton() {
        Graphene.guardHttp(showNewFormButton).click();
        return this;
    }

    public OwnerPage clickCancelNewEntityButton() {
        Graphene.guardHttp(cancelNewButton).click();
        return this;
    }

    public OwnerPage clickShowEditForm() {
        Graphene.guardHttp(showEditFormButton).click();
        return this;
    }

    public OwnerPage clickCancelEditButton() {
        Graphene.guardHttp(cancelEditButton).click();
        return this;
    }

    public OwnerPage clickShowDeleteForm() {
        Graphene.guardHttp(showDeleteFormButton).click();
        return this;
    }

    public OwnerPage clickCancelDeleteButton() {
        Graphene.guardHttp(canceDeleteButton).click();
        return this;
    }

    public OwnerPage clickSearchButton() {
        Graphene.guardHttp(searchButton).click();
        return this;
    }

    public OwnerPage clickClearSearchButton() {
        Graphene.guardHttp(clearSearchButton).click();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton0() {
        Graphene.guardHttp(showDetailsFormButton0).click();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton1() {
        Graphene.guardHttp(showDetailsFormButton1).click();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton2() {
        Graphene.guardHttp(showDetailsFormButton2).click();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton3() {
        Graphene.guardHttp(showDetailsFormButton3).click();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton4() {
        Graphene.guardHttp(showDetailsFormButton4).click();
        return this;
    }

    public OwnerPage clickCancelDetailsButton() {
        Graphene.guardHttp(cancelDetailsButton).click();
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
}
