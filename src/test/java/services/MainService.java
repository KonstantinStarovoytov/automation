package services;

import anatations.Service;
import com.codeborne.selenide.Condition;
import components.NavigationBar;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pages.MainPage;
import services.pageComponentServices.NavigationBarService;

@Slf4j
@Getter
@Service
public class MainService implements NavigationBarService {
    @Autowired
    private MainPage mainPage;

    @Override
    public NavigationBar navigationBar() {
        return getMainPage().getNavigationBar();
    }
}
