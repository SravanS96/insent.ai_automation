package pageObjects;

import driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import utils.PageActionUtils;

@Listeners(reports.ExtentListener.class)
public class HomePage {

    private final By Inbox=By.xpath("//div[@class='sc-eTuwsz kJljir']");
    private final By conversations=By.xpath("//a[@href='/conversations']");
    private final By test_Conversation=By.xpath("//div[text()='Insent.ai']");
    private final By conversation_Flow=By.xpath("//div[text()='Conversation flow']");
    private final By Save_conversation_Flow=By.xpath("//button[normalize-space()='Save conversation flow']");
    private final By Simulator=By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-4']/child::div/div[2]");
    private final By Greeting_msg_txt_field=By.xpath("//div[text()='Hi there, welcome']");
    private final By Personalization_Trigger=By.xpath("//div[@class='personalizationTrigger']");
    private final By Personalize_Token_Tpggle=By.xpath("//div[text()='Please select a field']");
    private final By select_Field_Input_FirsName=By.xpath("//input[@id='react-select-2-input']");
    private final By select_Field_Input_LastName=By.xpath("//input[@id='react-select-3-input']");
    private final By default_value_First=By.xpath("//input[@placeholder='Please enter a default value']");
    private final By toast_message =By.xpath("//div[@role='alert']");
    private final By bot_Welcome_text =By.xpath("//*[@id='insent-chat-widget']/div/div/div[1]/div/div[1]/div");
    private final By message_TextBox =By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div[3]/div/form/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div[2]");
    private final By bot_Frame_collapse_btn =By.xpath("//div[@class='sc-bbEPYs hVxZvE']");
    private final By bot_Hi_there_message =By.xpath("//iframe[@id='insent-iframe']//div[@class='sc-bHwgHz lgWmIK']");
    private final By addNewStepButton =By.xpath("//div[text()='Add new step']/..");
    private  String  addNewStep_menu = "//div[contains(text(),'%replaceable%')]";






    public String getInboxText(){
      String inboxText= PageActionUtils.getElementText(Inbox);
      return inboxText;
    }
    public String getBotText(){
      String botText= PageActionUtils.getElementText(bot_Welcome_text);
      return botText;
    }
    public HomePage click_On_Conversations(){
        PageActionUtils.click(conversations);
        return this;
    }
    public HomePage click_On_Test(){
        PageActionUtils.click(test_Conversation);
        return this;
    }
    public HomePage click_On_ConversationFlow(){
        PageActionUtils.click(conversation_Flow);
        return this;
    }
    public String click_On_SaveConversationFlow(){
        PageActionUtils.click(Save_conversation_Flow);
        String saveMessage=PageActionUtils.getElementText(toast_message);
        return saveMessage;
    }

    public HomePage clickAddNewStep(String menu, String subMenu) throws InterruptedException {
        PageActionUtils.click(addNewStepButton);
        PageActionUtils.hoverOnElement(By.xpath(addNewStep_menu.replace("%replaceable%",menu)));
        Thread.sleep(2000);
        PageActionUtils.hoverOnElement(By.xpath(addNewStep_menu.replace("%replaceable%",subMenu)));
        Thread.sleep(2000);
        PageActionUtils.click(By.xpath(addNewStep_menu.replace("%replaceable%",subMenu)));
        return  this;
    }

    public HomePage click_On_Simulator(){
        PageActionUtils.click(Simulator);
        PageActionUtils.switchToFrame(0);
        PageActionUtils.switchToFrame(0);
        return this;
    }
    public HomePage click_On_GreetingMessage_Text_Field(){
        PageActionUtils.click(Greeting_msg_txt_field);
        return this;
    }
    public HomePage click_On_Personalization_trigger(){
        PageActionUtils.click(Personalization_Trigger);
        return this;
    }

    public HomePage selectField_enterDefaultValue (String fieldName, String name ){
        PageActionUtils.click(Personalize_Token_Tpggle);
        switch (fieldName.toUpperCase()){
            case "FIRST NAME":
                PageActionUtils.typeIntoTextBox(select_Field_Input_FirsName, fieldName + Keys.ENTER);
                break;
            case "LAST NAME":
                PageActionUtils.typeIntoTextBox(select_Field_Input_LastName, fieldName + Keys.ENTER);
                break;
        }
        PageActionUtils.typeIntoTextBox(default_value_First, name + Keys.ENTER );
        return this;
    }

    public String saveFirstName_and_LastName(String firstName, String lastName) throws InterruptedException {

        click_On_Conversations();
        click_On_Test();
        click_On_ConversationFlow();
        click_On_GreetingMessage_Text_Field();
        click_On_Personalization_trigger();
        selectField_enterDefaultValue("First Name", firstName);
        Thread.sleep(2000);
        click_On_Personalization_trigger();
        selectField_enterDefaultValue("Last Name", lastName);
        Thread.sleep(3000);
        click_On_SaveConversationFlow();
        click_On_Simulator();
        Thread.sleep(3000);
        String getBotText= getBotText();


        return getBotText;
    }

    public String add_Show_a_Message(String msg) throws InterruptedException {
        click_On_Conversations();
        click_On_Test();
        click_On_ConversationFlow();
        clickAddNewStep("Message", "Show a message");
        PageActionUtils.typeIntoTextBox(message_TextBox, msg);
        click_On_SaveConversationFlow();
        Thread.sleep(3000);
        click_On_SaveConversationFlow();
        return  PageActionUtils.getElementText(message_TextBox);
    }

















}
