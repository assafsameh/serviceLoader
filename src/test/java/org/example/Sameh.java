package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sameh {

    @BeforeMethod
    public void setUp_Sameh(){
        System.out.println("setUp_Sameh");
    }

    @Test
    public void testMethod_Sameh(){
        System.out.println("Test Method Sameh");
    }
}
