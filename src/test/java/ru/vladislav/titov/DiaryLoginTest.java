package ru.vladislav.titov;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import ru.vladislav.titov.base.BaseTest;
import ru.vladislav.titov.model.AccountData;

public class DiaryLoginTest extends BaseTest {

    @Test
    public void correctLogin() {
        AccountData data = new AccountData("vladey_slavoy", "1997nbnjddkflbckfd");
        manager.getLoginHelper().exitFromAccount();
        manager.getLoginHelper().signIn(data);
        manager.getNavigationHelper().goToDiary();
        assertTrue(manager.getLoginHelper().isLoggedIn(data));
    }

    @Test
    public void incorrectLogin() {
        AccountData data = new AccountData("vladey_slavoy", "1997nbnjddkfdfgbmkbhkgrjnertgrhhkyh");
        manager.getLoginHelper().exitFromAccount();
        manager.getLoginHelper().signIn(data);
        assertFalse(manager.getLoginHelper().isLoggedIn());
    }

}
