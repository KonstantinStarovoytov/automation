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
import static services.ORMServices.DBChecker.checkMessageAmountChangedAfterAction;

@Slf4j
@Getter
@Service
public class MessageService implements NavigationBarService {
    @Autowired
    private MessagePage page;

    public void createRandomMessageWithImage() {
        getPage().getBtnAddMessage().click();
        getPage().getIpfMessage().sendKeys("Message : ".concat(randomAlphabetic(10)));
        getPage().getIpfTag().sendKeys(randomAlphabetic(4));
        getPage().getIpfFileUpload().uploadFile(ResourcesUtils.getRandomResourceFile());
        getPage().getBtnPostMessage().click();
    }

    public void checkMessageCreatedInDB() {
        checkMessageAmountChangedAfterAction(this::createRandomMessageWithImage);
    }

    @Override
    public NavigationBar navigationBar() {
        return getPage().getNavigationBar();
    }
}