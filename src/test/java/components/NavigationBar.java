package components;

import anatations.PageComponent;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@PageComponent
@Getter
public class NavigationBar {
    private SelenideElement btnSignIn = $("#navbarSupportedContent button.btn-outline-info");
    private SelenideElement btnSignOut = $("#navbarSupportedContent button.btn-outline-warning");
    private SelenideElement loggedUserName = $("div.navbar-text.text-danger");
    private SelenideElement btnMessages = $("a[href='/main']");
}