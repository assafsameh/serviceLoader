package org.example;

import org.testng.annotations.Test;

public class SampleTest {

    @Test(groups = {"regression"})
    public void myTest() {
        System.out.println("Running test...");
    }
}