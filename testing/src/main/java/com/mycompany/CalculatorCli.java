package com.mycompany;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class CalculatorCli {
    private final Calkulator calkulator;

    public CalculatorCli(Calkulator calkulator) {
        this.calkulator = calkulator;
    }
    
    

    
    public void runInteractiveSession(Reader reader){
        runInteractiveSession(reader, System.out::println);
    }
    public void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer){
        new BufferedReader(reader).lines()
                .flatMap(s->Stream.of(s.split(";")))
                .filter(s->!s.trim().isEmpty())
                .mapToDouble(calkulator::calculate)
                .forEach(resultConsumer);
    }
    public static void main(String[] args) throws Exception{
        CalculatorCli calculatorCli=new CalculatorCli(new CalkulatorImp());
        try (Reader reader=new InputStreamReader(System.in)){
            calculatorCli.runInteractiveSession(reader);
            
        } 
        }
        
    }

