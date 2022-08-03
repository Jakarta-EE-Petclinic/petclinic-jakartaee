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

@Location("info.jsf")
public class InformationPage {
    private Map<String, String> data;
    @Drone
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "listEntityHeaderId")
    private WebElement pageTitle;

    @FindBy(css = "a[href='https://github.com/thomaswoehlke']")
    @CacheLookup
    private WebElement c2022ThomasWoehlke;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic_django']")
    @CacheLookup
    private WebElement djangoPython;

    @FindBy(id = "j_idt14:j_idt23_focus")
    @CacheLookup
    private WebElement englisch1;

    @FindBy(id = "j_idt14:j_idt23_input")
    @CacheLookup
    private WebElement englisch2;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic_flask']")
    @CacheLookup
    private WebElement flaskSqlalchemyPython;

    @FindBy(css = "a[href='https://extensions.typo3.org']")
    @CacheLookup
    private WebElement fluidextbaseTypo3cmsPhp;

    @FindBy(css = "a[href='https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee']")
    @CacheLookup
    private WebElement githubRepository;

    @FindBy(css = "a[href='home.jsf']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='info.jsf']")
    @CacheLookup
    private WebElement information;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-jakartaee']")
    @CacheLookup
    private WebElement jakartaEeJava;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-jee6']")
    @CacheLookup
    private WebElement javaEe6;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-javaee7']")
    @CacheLookup
    private WebElement javaEe7;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-java-swing/']")
    @CacheLookup
    private WebElement javaSwing;

    @FindBy(css = "a[href='owner.jsf']")
    @CacheLookup
    private WebElement owners;

    private final String pageLoadedText = "but Jakarta EE uses JSF (Java Server Faces), a Component Based Web/Presentation-Tier";

    private final String pageUrl = "/petclinic/info.jsf";

    @FindBy(css = "a[href='petType.jsf']")
    @CacheLookup
    private WebElement petTypes;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-qt5/']")
    @CacheLookup
    private WebElement qtC;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-pyqt/']")
    @CacheLookup
    private WebElement qtPython;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-uml/']")
    @CacheLookup
    private WebElement requirementsEngineeringOoaooduml;

    @FindBy(css = "a[href='specialty.jsf']")
    @CacheLookup
    private WebElement specialties;

    @FindBy(css = "a[href='https://github.com/spring-projects/spring-petclinic']")
    @CacheLookup
    private WebElement springPetclinicJava;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic_symfony']")
    @CacheLookup
    private WebElement symfonyPhp;

    @FindBy(css = "a[href='https://jakarta-ee-petclinic.github.io/petclinic-jakartaee/']")
    @CacheLookup
    private WebElement thisDocument;

    @FindBy(id = "j_idt14:j_idt25")
    @CacheLookup
    private WebElement uibutton;

    @FindBy(css = "a[href='veterinarian.jsf']")
    @CacheLookup
    private WebElement veterinarians;

    public InformationPage() {
    }

    public InformationPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public InformationPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public InformationPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on C 2022 Thomas Woehlke Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickC2022ThomasWoehlkeLink() {
        c2022ThomasWoehlke.click();
        return this;
    }

    /**
     * Click on Django Python Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickDjangoPythonLink() {
        djangoPython.click();
        return this;
    }

    /**
     * Click on Flask Sqlalchemy Python Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickFlaskSqlalchemyPythonLink() {
        flaskSqlalchemyPython.click();
        return this;
    }

    /**
     * Click on Fluidextbase Typo3cms Php Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickFluidextbaseTypo3cmsPhpLink() {
        fluidextbaseTypo3cmsPhp.click();
        return this;
    }

    /**
     * Click on Github Repository Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickGithubRepositoryLink() {
        githubRepository.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Information Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickInformationLink() {
        information.click();
        return this;
    }

    /**
     * Click on Jakarta Ee Java Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickJakartaEeJavaLink() {
        jakartaEeJava.click();
        return this;
    }

    /**
     * Click on Java Ee 6 Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickJavaEe6Link() {
        javaEe6.click();
        return this;
    }

    /**
     * Click on Java Ee 7 Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickJavaEe7Link() {
        javaEe7.click();
        return this;
    }

    /**
     * Click on Java Swing Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickJavaSwingLink() {
        javaSwing.click();
        return this;
    }

    /**
     * Click on Owners Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickOwnersLink() {
        owners.click();
        return this;
    }

    /**
     * Click on Pet Types Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickPetTypesLink() {
        petTypes.click();
        return this;
    }

    /**
     * Click on Qt C Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickQtCLink() {
        qtC.click();
        return this;
    }

    /**
     * Click on Qt Python Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickQtPythonLink() {
        qtPython.click();
        return this;
    }

    /**
     * Click on Requirements Engineering Ooaooduml Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickRequirementsEngineeringOoaoodumlLink() {
        requirementsEngineeringOoaooduml.click();
        return this;
    }

    /**
     * Click on Specialties Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickSpecialtiesLink() {
        specialties.click();
        return this;
    }

    /**
     * Click on Spring Petclinic Java Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickSpringPetclinicJavaLink() {
        springPetclinicJava.click();
        return this;
    }

    /**
     * Click on Symfony Php Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickSymfonyPhpLink() {
        symfonyPhp.click();
        return this;
    }

    /**
     * Click on This Document Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickThisDocumentLink() {
        thisDocument.click();
        return this;
    }

    /**
     * Click on Uibutton Button.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickUibuttonButton() {
        uibutton.click();
        return this;
    }

    /**
     * Click on Veterinarians Link.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage clickVeterinariansLink() {
        veterinarians.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage fill() {
        setEnglisch1DropDownListField();
        setEnglisch2DropDownListField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage setEnglisch1DropDownListField() {
        return setEnglisch1DropDownListField(data.get("ENGLISCH_1"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage setEnglisch1DropDownListField(String englisch1Value) {
        englisch1.sendKeys(englisch1Value);
        return this;
    }

    /**
     * Set default value to Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage setEnglisch2DropDownListField() {
        return setEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Set value to Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage setEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).selectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage submit() {
        clickUibuttonButton();
        return this;
    }

    /**
     * Unset default value from Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage unsetEnglisch2DropDownListField() {
        return unsetEnglisch2DropDownListField(data.get("ENGLISCH_2"));
    }

    /**
     * Unset value from Englisch Drop Down List field.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage unsetEnglisch2DropDownListField(String englisch2Value) {
        new Select(englisch2).deselectByVisibleText(englisch2Value);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the InformationPage class instance.
     */
    public InformationPage verifyPageLoaded() {
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
     * @return the InformationPage class instance.
     */
    public InformationPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public void assertPageIsLoaded() {
        assertThat(pageTitle.isDisplayed());
        assertEquals( "Information", pageTitle.getText() );
    }
}
