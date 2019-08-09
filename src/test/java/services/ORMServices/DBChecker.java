package services.ORMServices;

import static core.CustomMatcher.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.not;
import static services.ORMServices.DBGetter.getMessageAmountForCurrentUser;

public class DBChecker {

    public static void checkMessageAmountChangedAfterAction(Runnable action) {
        long messageAmountForCurrentUserBefore = getMessageAmountForCurrentUser();
        action.run();
        long messageAmountForCurrentUserAfter = getMessageAmountForCurrentUser();
        assertThat(String.format("Message amount changed from '%d' to '%d'",
                messageAmountForCurrentUserBefore, messageAmountForCurrentUserAfter),
                messageAmountForCurrentUserBefore, not(equalTo(messageAmountForCurrentUserAfter)));
    }
}