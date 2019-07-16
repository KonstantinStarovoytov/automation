package objects.Accounts;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import objects.UserType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@XmlRootElement (name = "Accounts")
@XmlAccessorType (XmlAccessType.FIELD)
@Slf4j
@Getter
public class Accounts {
    @XmlElement (name = "account")
    private List<Account> accounts;

    public static Account getMainAccount () {
        return getAccount(UserType.MAIN);
    }

    public static Account getAdditionalAccount () {
        return getAccount(UserType.ADDITIONAL);
    }

    public static Account getAccount (UserType userType) {
        return getAccounts().get(userType);
    }
    public static Map<UserType,Account> getAccounts () {
        try {
            JAXBContext contex = JAXBContext.newInstance(Accounts.class);
            Unmarshaller unmarshaller = contex.createUnmarshaller();

            File xml = new File("src/main/resources/login.xml");

            Accounts accounts = (Accounts) unmarshaller.unmarshal(xml);
            return accounts.accounts.stream().collect(Collectors.toMap(acc->UserType.getUserTypeByType(acc.getUserType()),acc -> acc));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Cant unmarshall elements");
    }
}
