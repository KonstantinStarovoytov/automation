package services.ORMServices;

import entity.UserModel;

import static services.ORMServices.DBPredicate.*;
import static tests.BaseTest.currentUser;

class DBGetter {

    private static Long getCurrentUserId() {
        var id = DBFinder.find(UserModel.class).where(nameEqual(currentUser.get().getSamAccountName())).getFieldValue("id", Long.class);
        return (Long) id.orElseGet(() -> DBFinder.find(UserModel.class).where(emailEqual(currentUser.get().getLogin())).getFieldValue("id", Long.class));
    }

    static long getMessageAmountForCurrentUser() {
        var id = getCurrentUserId();
        var userModel = (UserModel) DBFinder.find(UserModel.class).where(idEqual(id.toString())).getResultList().get(0);
        return userModel.getMessages().size();
    }
}