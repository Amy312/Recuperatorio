package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoly.*;
import webUI.session.Session;

public class LoginTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void updatePassword() {

        //1st - LOGIN
        String email = "amy@san.com";
        String newpass = "Amys4n23";
        String pass = "panques1to";
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(pass);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");
    }
}
