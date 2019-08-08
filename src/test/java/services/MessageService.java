package services;

import anatations.Service;
import components.NavigationBar;
import core.ResourcesUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pages.MessagePage;
import services.pageComponentServices.NavigationBarService;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Slf4j
@Getter
@Service
public class MessageService implements NavigationBarService {
    @Autowired
    private MessagePage messagePage;

    public void createRandomMessageWithImage (String imageName) {
        getMessagePage().getIpfMessage().sendKeys("Message : ".concat(randomAlphabetic(10)));
        getMessagePage().getIpfTag().sendKeys(randomAlphabetic(4));
        getMessagePage().getIpfTag().sendKeys(randomAlphabetic(4));
        getMessagePage().getIpfTag().uploadFile(ResourcesUtils.getResourceFile(imageName));
    }

    @Override
    public NavigationBar navigationBar() {
        return getMessagePage().getNavigationBar();
    }
}