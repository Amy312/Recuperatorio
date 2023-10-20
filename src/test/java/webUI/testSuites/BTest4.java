package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoly.*;
import webUI.session.Session;

public class BTest4 {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SettingsPage settingsPage = new SettingsPage();
    DashboardSection dashboardSection = new DashboardSection();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void updatePassword() throws InterruptedException {

        //1st - LOGIN
        String email = "amy@san.com";
        String pass = "Amys4n23";
        String newpass = "panques1to";
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(pass);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        //2nd - Go to settings
        menuSection.settingsButton.click();

        // 3rd - Change Password
        settingsPage.oldPassTextBox.setText(pass);
        settingsPage.newPassTextBox.setText(newpass);
        settingsPage.okButton.click();
        Thread.sleep(3000);

        // 4th - verify change
        menuSection.logoutButton.click();

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(newpass);
        loginSection.loginButton.click();

        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

    }
}
