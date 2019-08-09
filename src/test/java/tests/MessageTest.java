package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import services.MessageService;

@Test
public class MessageTest extends BaseTest{
    @Autowired
    private MessageService messageService;

    @Test(description = "Verify create message")
    public void checkCreateMessage() {
        messageService.clickMessageMenuItem();
        messageService.checkMessageCreatedInDB();
    }
}