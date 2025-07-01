package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;

public class SampleTest {

    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("setUp");
    }

    @Test(groups = {"regression", "smoke"})
    public void myTest() {
        System.out.println("Running test...");
    }
}