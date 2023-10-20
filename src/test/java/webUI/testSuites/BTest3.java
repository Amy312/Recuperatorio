package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoist.*;
import webUI.session.Session;

public class BTest3 {
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    MenuSection menuSection = new MenuSection();

    OnBoardPage onBoardPage = new OnBoardPage();
    AddProjectSection addProjectSection = new AddProjectSection();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://app.todoist.com/");
    }

    @Test
    public void createUserAndProject() throws InterruptedException {

        loginPage.signUpButton.click();
        signUpPage.emailTextBox.setText("qqwansa@csa.com");
        signUpPage.passTextBox.setText("panqueS1to");
        signUpPage.sendButton.click();

        onBoardPage.nameTextBox.setText("Ambar Rojas");
        onBoardPage.nameButton.click();
        onBoardPage.eduButton.click();
        onBoardPage.goToMenu.doubleClick();

       // Thread.sleep(60000);
        Assertions.assertTrue(menuSection.addTaskButton.isControlDisplayed(),
                       "ERROR no me pude iniciar sesion");

        menuSection.projectButton.click();
        menuSection.addProjectButton.click();

        String name = "Proyecto 1";
        addProjectSection.nametextBox.setText(name);
        addProjectSection.addButton.click();

        menuSection.setProjectName(name);
        Assertions.assertTrue(menuSection.projectName.isControlDisplayed(),
                "ERROR, no se creo el proyecto");



    }
}
