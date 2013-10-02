package com.zubkov.sportprog.testing;

/*
 * Developer: Andrey Zubkov
 * Date: 2013-10-02
 */

import java.io.File;
import java.lang.reflect.Method;

public class StopCoderTest extends AbstractTest{

    @Override
    protected void invoke(File inFile, File outFile) {
        try{
            Class<?> algorithmClass = Class.forName("Algorithm");
            Object algorithm = algorithmClass.newInstance();
            Method method = algorithmClass.getDeclaredMethod("solution", new Class[]{String.class, String.class});
            method.invoke(algorithm, inFile.getAbsolutePath(), outFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
