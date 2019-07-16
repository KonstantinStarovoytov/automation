package objects.Accounts;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "account")
public class Account {
    private String userType;
    private String firstName;
    private String lastName;
    private String login;
    private String samAccountName;
    private String pass;
}
