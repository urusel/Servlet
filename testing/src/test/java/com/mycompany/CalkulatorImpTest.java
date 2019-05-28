/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.xml.transform.Result;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CalkulatorImpTest {
    private CalkulatorImp calkulator;
    
    @Before
    public void setUp() throws Exception{
        calkulator=new CalkulatorImp();
    }
    
    
    @Test
    public void zeroTest() throws Exception{
        double result= calkulator.calculate("0");
        
        assertEquals(0, result, 1e-9);
            
     
    }
   @Test
    public void floatingPointTest() throws Exception{
        double result=calkulator.calculate("-3000.02");
        assertEquals(-3000.02, result, 1e-9);
    }
    @Test
    public void addTest_1() throws Exception{
        double result= calkulator.calculate("30.4/2");
        assertEquals(15.2, result, 1e-9);
    }
    @Test
    public void addTest_2() throws Exception{
        double result= calkulator.calculate("(2+2)*1.5/10-444");
        assertEquals(-443.4, result, 1e-9);
}
     @Test
    public void addTest_3() throws Exception{
        double result= calkulator.calculate("1/0");
        assertEquals(Infinity, result, 1e-9);
}
}
