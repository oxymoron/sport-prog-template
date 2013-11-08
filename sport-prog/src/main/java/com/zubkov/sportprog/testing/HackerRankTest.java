/*
 * Author: Andrey Zubkov
 * Date: 26.05.13
 */

package com.zubkov.sportprog.testing;

import com.zubkov.sportprog.testing.exception.TestingException;

import java.io.*;
import java.lang.reflect.Method;

public class HackerRankTest extends AbstractStaticTest {

    @Override
    protected String getClassName() {
        return "Solution";
    }

}
