package objects;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import objects.Accounts.Accounts;

import java.util.List;

public enum UserType {
    MAIN("Main", "Admin"),
    ADDITIONAL("Additional", "User"),
    NA_NA("","");

    private String typeName;
    private String roleName;

    UserType (String type, String role) {
        this.typeName = type;
        this.roleName = role;
    }

    public String getFirstLastName () {
        return Joiner.on(" ").join(Accounts.getAccount(this).getFirstName(), Accounts.getAccount(this).getLastName());
    }

    public String getTypeString () {
        return typeName;
    }

    public String getRoleString () {
        return roleName;
    }

    public static List<UserType> getVpUser () {
        return ImmutableList.of(MAIN,ADDITIONAL);
    }

    public String getRoleLowerCaseString () {
        return roleName.toLowerCase();
    }

    public static UserType getUserTypeByType (String type) {
        for (UserType value : UserType.values()) {
            if (value.getTypeString().equals(type)) return value;
        }
        throw new IllegalArgumentException("Can't find user type with type " + type);
    }
}