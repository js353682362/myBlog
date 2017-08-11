package com.blog.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * @（#）:IOTest.java
 * @description:
 * @author: jiaosen 2017/8/11
 * @version: Version 1.0
 */
public class IOTest {

    @Test
    public void testIo(){
        String filePath = "G:\\\\test.txt";
        File file = new File(filePath);

        try {
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.append("jiaosen");
            writer.append("\r\n");
            writer.append("123445");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
