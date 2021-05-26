package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class HomePage {

    private By Inbox=By.xpath("//div[@class='sc-eTuwsz kJljir']");




    public String getInboxText(){
      String inboxText= PageActionUtils.getElementText(Inbox);
      return inboxText;
    }







}
