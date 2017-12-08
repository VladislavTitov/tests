package ru.vladislav.titov;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.vladislav.titov.manager.TestManager;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        //DiaryLoginTest.class,
        DiaryPostCreationTests.class,
        DiaryPostModificationTests.class
})
public class DiaryTest {

    @AfterClass
    public static void finish() {
        TestManager.getInstance().stop();
    }
}
