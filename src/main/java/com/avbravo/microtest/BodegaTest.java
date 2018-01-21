/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.repository.BodegaRepository;
import com.avbravo.jmoordbunit.anotation.Report;
import com.avbravo.jmoordbunit.anotation.Test;
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
@Test
@Report(path = "/home/avbravo/Descargas/")
public class BodegaTest {
@Inject 
UnitTest unitTest;
    @Inject
    BodegaRepository bodegaRepository;

    @PostConstruct
    void init() {
       unitTest.start(BodegaTest.class);
       findAll();
       
       unitTest.end(BodegaTest.class);
        
    }

    private void findAll(){
        unitTest.assertNotEquals("findAll",0,bodegaRepository.findAll().size());
  
    }
    @PreDestroy
    public void destroy() {
       
    }
}
