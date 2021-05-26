package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;


public class LoginPage {

    private By email_Field=By.name("email");
    private By password_Field=By.name("password");
    private By login_Btn=By.xpath("//span[contains(text(),'Login')]");
    private By toast_Error =By.xpath("//div[@role='alert']");


    public boolean userLogin(String userName, String password){
        PageActionUtils.typeIntoTextBox(email_Field,userName);
        PageActionUtils.typeIntoTextBox(password_Field,password);
        PageActionUtils.click(login_Btn);
        return !PageActionUtils.verifyElementPresence(toast_Error);
    }

}
