package ru.protei;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionnairePage {
    public WebDriver driver;

    public QuestionnairePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id = 'dataEmail']")
    private WebElement fieldOfEmail;

    @FindBy(xpath = "//input[@id = 'dataName']")
    private WebElement fieldOfName;

    @FindBy(xpath = "//select[@class = 'uk-form-width-large']")
    private WebElement fieldOfChooseGender;

    @FindBy(xpath = "//*[@id=\"dataGender\"]/option[1]")
    private WebElement menGender;

    @FindBy(xpath = "//*[@id=\"dataGender\"]/option[2]")
    private WebElement womenGender;

    @FindBy(xpath = "//input[@id = 'dataCheck11']")
    private WebElement fieldOfOption11;

    @FindBy(xpath = "//input[@id = 'dataCheck12']")
    private WebElement fieldOfOption12;

    @FindBy(xpath = "//input[@id = 'dataSelect21']")
    private WebElement fieldOfOption21;

    @FindBy(xpath = "//input[@id = 'dataSelect22']")
    private WebElement fieldOfOption22;

    @FindBy(xpath = "//input[@id = 'dataSelect23']")
    private WebElement fieldOfOption23;

    @FindBy(xpath = "//button[@id = 'dataSend']")
    private WebElement buttonAdd;

    @FindBy(xpath = "//button[@class = 'uk-button uk-button-primary uk-modal-close']")
    private WebElement buttonClose;

    @FindBy(xpath = "//tr/td[1]")
    private WebElement userEmail;

    @FindBy(xpath = "//tr/td[2]")
    private WebElement userName;

    @FindBy(xpath = "//tr/td[3]")
    private WebElement userGender;

    public void inputEmail(String email) {
        fieldOfEmail.sendKeys(email);
    }

    public void inputName(String name) {
        fieldOfName.sendKeys(name);
    }

    public void inputMenGender() {
        fieldOfChooseGender.click();
        menGender.click();
    }

    public void inputWomenGender() {
        fieldOfChooseGender.click();
        womenGender.click();
    }

    public void inputOption11() {
        fieldOfOption11.click();
    }

    public void inputOption12() {
        fieldOfOption12.click();
    }

    public void inputOption11and12() {
        fieldOfOption11.click();
        fieldOfOption12.click();
    }

    public void inputOption21() {
        fieldOfOption21.click();
    }

    public void inputOption22() {
        fieldOfOption22.click();
    }

    public void inputOption23() {
        fieldOfOption23.click();
    }

    public void clickAddButton() {
        buttonAdd.click();
    }

    public void clickClose() {
        buttonClose.click();
    }

    public String getUserEmail() {
        String userEmailText = userEmail.getText();
        return userEmailText;
    }

    public String getUserName() {
        String userNameText = userName.getText();
        return userNameText;
    }

    public String getUserGender() {
        String userGenderText = userGender.getText();
        return userGenderText;
    }

}
