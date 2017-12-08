package ru.vladislav.titov;

import org.junit.Test;
import ru.vladislav.titov.base.BaseAuth;
import ru.vladislav.titov.base.BaseTest;
import ru.vladislav.titov.model.AccountData;
import ru.vladislav.titov.model.PostFields;

import static org.junit.Assert.assertEquals;

public class DiaryPostModificationTests extends BaseAuth {

    @Test
    public void editPost() throws Exception {
        manager.getNavigationHelper().goToDiary();
        manager.getPostHelper().initPostModification();
        PostFields fields = new PostFields("Changed title", "Changed message");
        manager.getPostHelper().fillPostFields(fields);
        manager.getPostHelper().saveChanges();
        assertEquals(fields, manager.getPostHelper().getPost());
    }

}
