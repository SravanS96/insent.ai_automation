package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class HomePage {

    private By status_Field = By.xpath("//span[contains(normalize-space(),\"What's on your mind\")]");
    private By crate_Post = By.xpath("//div[contains(@aria-label,\"What's on your mind\")]");
    private By post_Btn = By.xpath("//div[@aria-label='Post']");
    private By first_Post = By.xpath("//div[@class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql']");



    public void enterStatus(String status){
        PageActionUtils.click(status_Field);
        PageActionUtils.typeIntoTextBox(crate_Post, status);
        PageActionUtils.click(post_Btn);

    }

    public String getStatus(){
        return PageActionUtils.getElementText(first_Post);
    }
}
