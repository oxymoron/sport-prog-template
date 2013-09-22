/*
 * Author: Andrey Zubkov
 * Date: 26.05.13
 */

package com.zubkov.sportprog.testing;

import com.zubkov.sportprog.testing.exception.TestingException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProgrammingChallengesTest extends AbstractTest {


    @Override
    protected boolean trimAssertion() {
        return true;
    }

    protected void invoke(File inFile, File outFile){
        try {
            Class<?> clazz = Class.forName("Main");
            Method main = clazz.getMethod("main", new Class[]{String[].class});
            main.setAccessible(true);

            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inFile));
            PrintStream outputStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));

            System.setIn(inputStream);
            System.setOut(outputStream);
            main.invoke(null, (Object)new String[]{});
            inputStream.close();
            outputStream.close();

        } catch (ClassNotFoundException e) {
            throw new TestingException(e);
        } catch (InvocationTargetException e) {
            throw new TestingException(e);
        } catch (NoSuchMethodException e) {
            throw new TestingException(e);
        } catch (IllegalAccessException e) {
            throw new TestingException(e);
        } catch (FileNotFoundException e) {
            throw new TestingException(e);
        } catch (IOException e) {
            throw new TestingException(e);
        }

    }
}
