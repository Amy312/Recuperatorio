package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class OnBoardPage {
    public TextBox nameTextBox = new TextBox(By.xpath("//input[contains(@placeholder,\"Por ej\")]"));
    public Button nameButton = new Button(By.xpath("//button[@class=\"F9gvIPl rWfXb_e _8313bd46 _7a4dbd5f _95951888 _2a3b75a1 _8c75067a\"]"));
    public Button eduButton = new Button(By.xpath("//button[@data-gtm-id=\"education\"]"));
    public Button goToMenu = new Button(By.xpath("//span[text()=\"Abrir Todoist\"]/../../button"));
}
