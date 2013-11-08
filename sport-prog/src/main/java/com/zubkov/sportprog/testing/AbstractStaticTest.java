package com.zubkov.sportprog.testing;/*
 * Developer: Andrey Zubkov
 * Date: 2013-11-09
 */

import com.zubkov.sportprog.testing.exception.TestingException;

import java.io.*;
import java.lang.reflect.Method;

public class AbstractStaticTest extends AbstractTest{

    protected String getClassName(){
        return "Main";
    }

    protected String getMethodName(){
        return "main";
    }

    protected void invoke(File inFile, File outFile){
        try {
            Class<?> clazz = Class.forName(getClassName());
            Method main = clazz.getMethod(getMethodName(), new Class[]{String[].class});
            main.setAccessible(true);

            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inFile));
            PrintStream outputStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));

            System.setIn(inputStream);
            System.setOut(outputStream);
            main.invoke(null, (Object)new String[]{});
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            throw new TestingException(e);
        }
    }
}
