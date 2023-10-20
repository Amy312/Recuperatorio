package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;

public class MenuSection {

    public Button addTaskButton = new Button(By.xpath("//button[@data-track=\"navigation|quick_add\"]"));

    public Button projectButton = new Button(By.xpath("//div[@class=\"nuMVpup _2a3b75a1 _509a57b4 c4803194 b0e6eab4 cad4e2ec e5a9206f _50ba6b6b f6342c26 _34cd2b5e\"]"));
    public Button addProjectButton = new Button(By.xpath("//button[@class=\"_8313bd46 _54d56775 _5e45d59f _2a3b75a1 _56a651f6\"]"));
    public Button projectName;

    public void setProjectName(String projectName) {
        this.projectName = new Button(By.xpath("//span[@class=\"simple_content\"][text()=\""+projectName+"\"]"));
    }
}
