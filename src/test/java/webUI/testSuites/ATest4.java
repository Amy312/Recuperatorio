package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoist.LoginPage;
import webUI.pages.todoist.MenuSection;
import webUI.pages.todoist.TaskSection;
import webUI.session.Session;

public class ATest4 {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();
    TaskSection taskSection = new TaskSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void addTask()  {

        // 1st - Login
        loginPage.emailTextBox.setText("amy@san.com");
        loginPage.pwdTextBox.setText("panques1t0");
        loginPage.loginButton.click();

        // 2nd - Create task
        String task = "tarea1";
        menuSection.addTaskButton.click();
        taskSection.taskNameTextBox.click();
        taskSection.taskNameTextBox.setText(task);
        taskSection.sendButton.click();
        menuSection.setTaskName(task);

        menuSection.inboxButton.click();

        Assertions.assertTrue(menuSection.taskName.isControlDisplayed(), "ERROR la tarea no existe!");

    }

}
