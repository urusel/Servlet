/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 *
 * @author user
 */
public class CalculatorCliTest {

    private Calkulator calkulatorMock;
    private CalculatorCli calculatorCli;
 @Rule
    public TestRule timeout=new Timeout(100, TimeUnit.MINUTES);

    @Before
    public void setUp() {

        calkulatorMock = Mockito.mock(Calkulator.class);
        calculatorCli = new CalculatorCli(calkulatorMock);
    }
    
    @Test
    public void emptyExpressionsMustBeSkipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n;    ;;;\t\n;"));

        Mockito.verifyZeroInteractions(calkulatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));

        verify(calkulatorMock).calculate("1");
        verify(calkulatorMock).calculate("2");
        verify(calkulatorMock).calculate("3");
        verifyNoMoreInteractions(calkulatorMock);
    }

   
    @Test(timeout = 100)
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_2() {
         //   Thread.sleep(200);
        when(calkulatorMock.calculate("1")).thenReturn(1d);
        when(calkulatorMock.calculate("2")).thenReturn(2d);
        when(calkulatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
         verify(calkulatorMock).calculate("1");
        verify(calkulatorMock).calculate("2");
        verify(calkulatorMock).calculate("3");
        verifyNoMoreInteractions(calkulatorMock);
    }
    }
