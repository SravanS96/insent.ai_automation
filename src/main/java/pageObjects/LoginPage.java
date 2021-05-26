package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;


public class LoginPage {

    private By email_Field = By.id("email");
    private By password_Field = By.id("pass");
    private By login_Btn = By.name("login");


    public HomePage doLogin(String userName, String password){
        PageActionUtils.typeIntoTextBox(email_Field,userName);
        PageActionUtils.typeIntoTextBox(password_Field,password);
        PageActionUtils.click(login_Btn);
        return new HomePage();
    }

}
