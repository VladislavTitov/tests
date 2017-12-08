package ru.vladislav.titov.base;

import org.junit.After;
import org.junit.Before;
import ru.vladislav.titov.manager.TestManager;

public class BaseTest {

    protected TestManager manager;

    @Before
    public void setUp() throws Exception {
        manager = TestManager.getInstance();
        manager.getNavigationHelper().openHomePage();
    }

    @After
    public void tearDown() throws Exception {
        manager.getLoginHelper().exitFromAccount();
    }


}
