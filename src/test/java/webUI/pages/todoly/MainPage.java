package webUI.pages.todoly;

import org.openqa.selenium.By;
import webUI.controls.Button;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    public Button signUpButton = new Button(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"));
    public Button errorButton = new Button(By.xpath("//div[@class=\"ui-state-error ui-corner-all\"]"));
}
