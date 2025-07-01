package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sameh {

    @BeforeMethod
    public void test(){
        System.out.println("setUp");
    }

    @Test
    public void testMethod1(){
        System.out.println("Test Method");
    }
}
