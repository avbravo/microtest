/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.repository.BodegaRepository;
import com.avbravo.jmoordbunit.util.UnitTest;
//import static com.avbravo.jmoordbunit.util.UnitTest.assertEquals;
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
public class BodegaTest {
@Inject 
UnitTest unitTest;
    @Inject
    BodegaRepository bodegaRepository;

    @PostConstruct
    void init() {
         unitTest.start("BodegaTest");
       
       
        unitTest.assertEquals(1,bodegaRepository.findAll().size());

      
        System.out.println("*********************************************");
//htmlGenerator.generar();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("======================================");
        System.out.println("Destroying BodegaTest -- ");
        System.out.println("======================================");
    }
}
