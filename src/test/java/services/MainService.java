package services;

import anatations.Service;
import com.codeborne.selenide.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pages.MainPage;

@Slf4j
@Service
public class MainService {
    @Autowired
    private MainPage page;

    public void verifyThatAvatarIsVisible(){
        page.getIMG_avatar().waitUntil(Condition.appear,15);
        page.getLogo().waitUntil(Condition.visible,15);
    }
}
