/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.entity.Rol;
import com.avbravo.ejbspard.repository.RolRepository;
import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.test.UnitTest;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
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
@Test(name = "RolTest")  
public class RolTest{
@Inject 
UnitTest unitTest;
     @Inject
    RolRepository rolRepository;

    @PostConstruct
    public void init() {
       unitTest.start(RolTest.class);
       findAll();
      unitTest.skipper("delete");
      unitTest.skipper("save");
   unitTest.end(RolTest.class);
     
        
    }

    @Test
    public void findAll(){
        for(Rol c:rolRepository.findAll()){
            System.out.println("rol: "+c.getIdrol());
        }
        unitTest.assertEquals("save",5,rolRepository.findAll().size());

    }
    /**
     *
     */
    @PreDestroy
    public void destroy() {
       
       
    }
}
