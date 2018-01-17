/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest.util;

/**
 *
 * @author avbravo
 */
public class UnitTest {
    public static void assertEquals(Object expect, Object result){
        if(expect.equals(result)){
            System.out.println(" es igual");
        }else{
        System.out.println(" No es igual");
    }
        
    
    }
    
}
