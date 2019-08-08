package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import services.MessageService;

@Test
public class MessageTest extends BaseTest{
    @Autowired
    private MessageService messageService;

    private static final String TEST_IMAGE = "testImage.jpg";

    @Test(description = "Verify create message")
    public void checkCreateMessage() {
        messageService.clickMessageMenuItem();
        messageService.createRandomMessageWithImage(TEST_IMAGE);
    }
}