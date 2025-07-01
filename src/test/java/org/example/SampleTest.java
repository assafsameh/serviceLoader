package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("setUp");
    }

    /*@Test()*/
    public void myTest() {
        System.out.println("Running setUp...");
    }
}