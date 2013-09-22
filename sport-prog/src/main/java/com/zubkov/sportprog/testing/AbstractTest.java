/*
 * Developer: Andrey Zubkov
 * Date: 21.02.13
 * Time: 20:17
 */
package com.zubkov.sportprog.testing;

import com.zubkov.sportprog.testing.exception.TestingException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public abstract class AbstractTest {

    public static final String TEMP_FILE_PREFIX = "azb";
    public static final String TEMP_FILE_SUFFIX = "test";


    protected boolean trimAssertion(){
        return true;
    }

    protected void test(String dirName){

        try {
            URI uri = this.getClass().getClassLoader().getResource(dirName).toURI();
            String path = new File(uri).toString();

            File inFile = new File(MessageFormat.format("{0}{1}in.txt", path, File.separator));
            File outFile = new File(MessageFormat.format("{0}{1}out.txt", path, File.separator));

            File tempFile = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);

            invoke(inFile, tempFile);

            String expectedString = FileUtils.readFileToString(outFile);
            String actualString = FileUtils.readFileToString(tempFile);
            if(trimAssertion()){
                expectedString = expectedString.trim();
                actualString = actualString.trim();
            }
            assertEquals(expectedString, actualString);

            FileUtils.deleteQuietly(tempFile);
        } catch (URISyntaxException e) {
            throw  new TestingException(e);
        } catch (IOException e) {
            throw new TestingException(e);
        }

    }

    protected abstract void invoke(File inFile, File outFile);


}
