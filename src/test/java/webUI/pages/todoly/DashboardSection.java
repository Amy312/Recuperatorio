package webUI.pages.todoly;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;

public class DashboardSection {
    public TextBox addItemTextBox = new TextBox(By.id("NewItemContentInput"));
    public Button addItemButton = new Button(By.id("NewItemAddButton"));
    public TextBox itemContentTextBox;
    public TextBox itemUpdateTextBox = new TextBox(By.xpath("//textarea[@id=\"ItemEditTextbox\"]"));
    public Button itemContentButton;

    public void setItemContent(String path) {
        this.itemContentTextBox = new TextBox(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ path +"\"]"));
        this.itemContentButton = new Button(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ path +"\"]"));
    }

    public void setItemContentUpdated(String newItemName) {
        this.itemContentTextBox = new TextBox(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ newItemName +"\"]"));
        this.itemContentButton = new Button(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ newItemName +"\"]"));
    }
}
