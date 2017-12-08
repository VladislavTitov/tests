package ru.vladislav.titov.base;

import org.junit.Before;
import ru.vladislav.titov.model.AccountData;
import ru.vladislav.titov.utils.XmlParser;

public class BaseAuth extends BaseTest {

    @Before
    public void login() {
        String login = XmlParser.getInstance().getLogin();
        String password = XmlParser.getInstance().getPassword();
        AccountData data = new AccountData(login, password);
        manager.getLoginHelper().signIn(data);
    }

}
