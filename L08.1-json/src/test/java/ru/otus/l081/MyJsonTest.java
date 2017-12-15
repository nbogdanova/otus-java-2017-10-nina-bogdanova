package ru.otus.l081;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import ru.otus.l081.mjson.MyJson;

public class MyJsonTest {

    @Test
    public void objectToJson() {
        Composition source = new Composition(1, "Test");
        String json = MyJson.toJson(source);
        Gson gson = new Gson();
        Composition result = gson.fromJson(json, Composition.class);
        Assert.assertEquals(source.getIntValue(), result.getIntValue());
        Assert.assertEquals(source.getStringValue(), result.getStringValue());
    }

    @Test
    public void ArrayOfPrimitivesToJson() {

    }

    @Test
    public void ArrayOfObjectsToJson() {

    }

    @Test
    public void CollectionToJson() {

    }

}
