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
import java.nio.file.Path;
import java.nio.file.Paths;
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
@Test
@Report(path = "/home/avbravo/Descargas/")
public class BodegaTest {
@Inject 
UnitTest unitTest;
    @Inject
    BodegaRepository bodegaRepository;

    @PostConstruct
    void init() {
      //   unitTest.start("BodegaTest");
       unitTest.start(BodegaTest.class);
       
        unitTest.assertEquals(1,bodegaRepository.findAll().size());
        
        
//      Path resourceDirectory = Paths.get("src","test","resources");
//        System.out.println(" "+ resourceDirectory.toAbsolutePath());
        
//         URL location =  this.getClass().getResource("/reports");
//    String FullPath = location.getPath();
//        System.out.println("new path -->"+FullPath);
//        URL resource = BodegaTest.class.getResource("abc");
//    try {
//        System.out.println("Path---> "+ Paths.get(resource.toURI()).toFile().getAbsolutePath());
//        
//    } catch (URISyntaxException ex) {
//        Logger.getLogger(BodegaTest.class.getName()).log(Level.SEVERE, null, ex);
//    }
//         unitTest.path();
        System.out.println("*********************************************");
//htmlGenerator.generar();
    }

    @PreDestroy
    public void destroy() {
       
    }
}
