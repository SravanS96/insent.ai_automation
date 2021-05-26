package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;


public class LoginPage {

    private By email_Field=By.name("email");
    private By password_Field=By.name("password");
    private By login_Btn=By.xpath("//span[contains(text(),'Login')]");
    private By toast_Error =By.xpath("//div[@role='alert']");
    private By password_error =By.xpath("//div[@class='sc-gFaPwZ fAcOit']");
    private String password_error_text = "Password can't be blank";
    private By Email_error=By.xpath("//body[1]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]");
    private String Email_error_text="Email can't be blank";


    public boolean userLogin(String userName, String password){
        setUsername(userName);
        setPassword_Field(password);
        clickLoginButton();
        return !PageActionUtils.verifyElementPresence(toast_Error);
    }

    public LoginPage setUsername(String username){
        PageActionUtils.typeIntoTextBox(email_Field,username);
        return this;
    }

    public LoginPage setPassword_Field(String password){
        PageActionUtils.typeIntoTextBox(password_Field,password);
        return this;
    }

    public HomePage clickLoginButton(){
        PageActionUtils.click(login_Btn);
        return new HomePage();
    }
    public boolean verifyEmptyPasswordError(){
        return PageActionUtils.getElementText(password_error).equals(password_error_text);
    }
    public boolean verifyEmptyEmailError(){
        return PageActionUtils.getElementText(Email_error).equals(Email_error_text);
    }


}
