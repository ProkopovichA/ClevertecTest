package util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SaveToFileTest {

    private boolean isFileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    @Test
    public void saveListToFile() {
        List<String> stringList = new ArrayList<>();
        stringList.add("line 1");
        stringList.add("line 2");

        SaveToFile.saveListToFile("testSave.txt", stringList);

        Assert.assertTrue(isFileExists("testSave.txt"));

    }
}