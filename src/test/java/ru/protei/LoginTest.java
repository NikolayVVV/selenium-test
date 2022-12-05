package ru.protei;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public LoginPage loginPage;
    public QuestionnairePage questionnairePage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        questionnairePage = new QuestionnairePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("E-Mail:", loginPage.getEmail()),
                () -> Assertions.assertEquals("Вход", loginPage.getAuthButton()),
                () -> Assertions.assertEquals("Пароль:", loginPage.getPassword()));
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test
    public void shouldHaveCorrectUserIrinaWomen11and21() {
        questionnairePage.inputEmail("testemail2@mail.ru");
        questionnairePage.inputName("Irina");
        questionnairePage.inputWomenGender();
        questionnairePage.inputOption11();
        questionnairePage.inputOption21();
        questionnairePage.clickAddButton();
        questionnairePage.clickClose();
        Assertions.assertAll(
                () -> Assertions.assertEquals("testemail2@mail.ru", questionnairePage.getUserEmail()),
                () -> Assertions.assertEquals("Irina", questionnairePage.getUserName()),
                () -> Assertions.assertEquals("Женский", questionnairePage.getUserGender()));
    }

    @Test
    public void shouldHaveCorrectUserNikolayMen11with12and23() {
        questionnairePage.inputEmail("testing@mail.ru");
        questionnairePage.inputName("Nikolay");
        questionnairePage.inputMenGender();
        questionnairePage.inputOption11();
        questionnairePage.inputOption12();
        questionnairePage.inputOption23();
        questionnairePage.clickAddButton();
        questionnairePage.clickClose();
        Assertions.assertAll(
                () -> Assertions.assertEquals("testing@mail.ru", questionnairePage.getUserEmail()),
                () -> Assertions.assertEquals("Nikolay", questionnairePage.getUserName()),
                () -> Assertions.assertEquals("Мужской", questionnairePage.getUserGender())
        );
    }

    @Test
    public void shouldHaveCorrectUserIrinaWomen12and22() {
        questionnairePage.inputEmail("test@mail.ru");
        questionnairePage.inputName("Напу Амо Хала Она Она Анека Вехи Вехи " +
                "Она Хивеа Нена Вава Кехо Онка Кахе Хеа Леке Еа Она Ней " +
                "Нана Ниа Кеко Оа Ога Ван Ика Ванао");
        questionnairePage.inputWomenGender();
        questionnairePage.inputOption12();
        questionnairePage.inputOption22();
        questionnairePage.clickAddButton();
        questionnairePage.clickClose();
    }

    @Test
    public void shouldHaveCorrectUserIrinaWomen11with12and23() {
        questionnairePage.inputEmail("1@mail.ru");
        questionnairePage.inputName("Барнаби Мармадюк Алоизий Бенджи Кобвеб Дартаньян " +
                "Эгберт Феликс Гаспар Гумберт Игнатий Джейден Каспер Лерой Максимилиан " +
                "Недди Объяхулу Пепин Кьюллиам Розенкранц " +
                "Секстон Тедди Апвуд Виватма Уэйленд Ксилон Ярдли Закари Усански");
        questionnairePage.inputWomenGender();
        questionnairePage.inputOption11();
        questionnairePage.inputOption12();
        questionnairePage.inputOption23();
        questionnairePage.clickAddButton();
        questionnairePage.clickClose();
    }

    @AfterEach
    public void LoginTest() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }
}
