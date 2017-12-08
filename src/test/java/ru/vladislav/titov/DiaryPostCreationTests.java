package ru.vladislav.titov;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.vladislav.titov.base.BaseAuth;
import ru.vladislav.titov.model.PostFields;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class DiaryPostCreationTests extends BaseAuth {

    @DataProvider
    public static List<List<PostFields>> getPosts() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader("E:\\Programming\\testing\\autotests\\src\\main\\resources\\data.json"));
            List<PostFields> posts = gson.fromJson(reader, new TypeToken<List<PostFields>>(){}.getType());
            return posts.stream().map(fields -> {
                List<PostFields> singlePost =  new ArrayList<>();
                singlePost.add(fields);
                return singlePost;
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    @UseDataProvider("getPosts")
    public void createPost(PostFields fields) throws Exception {
        manager.getPostHelper().initPostCreation();
        // PostFields fields = new PostFields("New title", "New message");
        manager.getPostHelper().fillPostFields(fields);
        manager.getPostHelper().saveChanges();
        assertEquals(fields, manager.getPostHelper().getPost());
    }

}

