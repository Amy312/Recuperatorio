package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class TaskSection {
    public TextBox taskNameTextBox = new TextBox(By.xpath("//p[@data-placeholder=\"Nombre de la tarea\"]"));
    public Button sendButton = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));
}
