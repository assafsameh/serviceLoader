package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sameh {

    @BeforeMethod
    public void test(){
        System.out.println("setUp");
    }

    @Test(groups = {"regression", "smoke"})
    public void testMethod1(){
        System.out.println("Test Method");
    }
}
