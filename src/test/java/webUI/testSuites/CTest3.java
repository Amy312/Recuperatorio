package webUI.testSuites;

import org.junit.jupiter.api.*;
import webUI.pages.todoist.LoginPage;
import webUI.pages.todoist.MenuSection;
import webUI.pages.todoist.SettingsSection;
import webUI.pages.todoist.TaskSection;
import webUI.session.Session;

public class CTest3 {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();
    SettingsSection settingsSection = new SettingsSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void changeName() throws InterruptedException {

        // 1st - Login
        loginPage.emailTextBox.setText("amy@san.com");
        loginPage.pwdTextBox.setText("panques1t0");
        loginPage.loginButton.click();

        // 2nd - go to settings
        menuSection.informationButton.click();
        menuSection.settingsButton.click();

        // 3rd - change name
        String name = "Rojitas con rojas";
        settingsSection.nameTextBox.clearSetText(name);
        settingsSection.updateButton.click();
        settingsSection.closeButton.click();

        // 4th - close account

        menuSection.informationButton.click();
        menuSection.closeSession.click();
        loginPage.mainLoginButton.click();

        // 5th - login again
        loginPage.emailTextBox.setText("amy@san.com");
        loginPage.pwdTextBox.setText("panques1t0");
        loginPage.loginButton.click();

        // 6th - verify if the name changed
        menuSection.informationButton.click();
        menuSection.settingsButton.click();
        Assertions.assertEquals(settingsSection.nameTextBox.getValue(), name, "Error! no se cambio el nombre");





    }
}