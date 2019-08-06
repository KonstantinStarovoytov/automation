package services.pageComponentServices;

import anatations.Service;
import components.NavigationBar;
import objects.Accounts.Account;

import static core.CustomMatcher.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@Service
public interface NavigationBarService {
    NavigationBar navigationBar();

    default void clickSignInButton() {
        navigationBar().getBtnSignIn().click();
    }

    default void clickSignOutButton() {
        navigationBar().getBtnSignOut().click();
    }

    default void checkLoggedInUserNameEqualTo(Account account) {
        assertThat("Logged user name", navigationBar().getLoggedUserName().text(), equalTo(account.getSamAccountName()));
    }

}