/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.repository.PaisRepository;
import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.test.UnitTest;
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
        unitTest.start(PaisTest.class);   
        findAll();

    }

    @PreDestroy
    public void destroy() {
          unitTest.end(PaisTest.class);
      
    }
    @Test
    public String findAll(){
        unitTest.assertNotEquals(0, paisRepository.findAll().size(),"No tiene paises");
        
      
         return "";
    }
            
}
