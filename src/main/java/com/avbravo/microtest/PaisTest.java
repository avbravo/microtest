/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.repository.PaisRepository;
import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.util.UnitTest;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Startup
@Singleton
@DependsOn("TestEnvironment")
public class PaisTest{
@Inject 
UnitTest unitTest;
    @Inject
    PaisRepository paisRepository;

    @PostConstruct
    void init() {
        unitTest.start("PaisTest");
    
       if(paisRepository.findAll().size()==0){
           System.out.println("--->tiene paiss");     
       }else{
           System.out.println("--->no tiene paiss");
       }
      
        System.out.println("*********************************************");

    }

    @PreDestroy
    public void destroy() {
        System.out.println("======================================");
        System.out.println("Destroying PaisTest -- ");
        System.out.println("======================================");
    }
}
