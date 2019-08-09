package pages;

import anatations.PageObject;
import com.codeborne.selenide.SelenideElement;
import components.NavigationBar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.$;

@Getter
@PageObject
public class MessagePage extends BasePage {
    @Autowired
    private NavigationBar navigationBar;

    private SelenideElement btnAddMessage = $(".container .btn[data-toggle]");
    private SelenideElement ipfMessage = $(".form-group input[name=text]");
    private SelenideElement ipfTag = $(".form-group input[name=tag]");
    private SelenideElement ipfFileUpload = $(".form-group input#customFile");
    private SelenideElement btnPostMessage = $("input[type=hidden]~div button");
}