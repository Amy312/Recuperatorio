package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class SignUpPage {
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@placeholder=\"Introduce tu email...\"]"));
    public TextBox passTextBox = new TextBox(By.xpath("//input[@type=\"password\"]"));
    public Button sendButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-signup\"]"));

}
