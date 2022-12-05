package ru.protei;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id = 'loginEmail']")
    private WebElement fieldOfLoginInput;

    @FindBy(xpath = "//input[@id = 'loginPassword']")
    private WebElement fieldOfPasswordInput;

    @FindBy(xpath = "//button[@id = 'authButton']")
    private WebElement loginButton;

    @FindBy(xpath = "//label[@for = 'loginEmail']")
    private WebElement email;

    @FindBy(xpath = "//label[@for = 'loginPassword']")
    private WebElement password;

    public void inputLogin(String login) {
        fieldOfLoginInput.click();
        fieldOfLoginInput.sendKeys(login);
    }

    public void inputPassword(String password) {
        fieldOfPasswordInput.click();
        fieldOfPasswordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getEmail() {
        String emailText = email.getText();
        return emailText;
    }

    public String getPassword() {
        String passwordText = password.getText();
        return passwordText;
    }

    public String getAuthButton() {
        String authButtonText = loginButton.getText();
        return authButtonText;
    }

}
