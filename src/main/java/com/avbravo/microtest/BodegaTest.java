/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbspard.repository.BodegaRepository;
import static com.avbravo.microtest.util.UnitTest.assertEquals;
import com.avbravo.microtest.util.UnitReport;
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
@DependsOn("StartupBean")
public class BodegaTest {
    @Inject
UnitReport htmlGenerator;
    @Inject
    BodegaRepository bodegaRepository;

    @PostConstruct
    void init() {
        System.out.println("--------------------------------------->");
        System.out.println("estoy en init() de BodegaTest ()");
        System.out.println("--------------------------------------->");
        System.out.println("*********************************************");
        System.out.println("invocare al findAll()");
       
        assertEquals(1,bodegaRepository.findAll().size());
//                if(bodegaRepository.findAll().size()==0){
//           System.out.println("--->tiene bodegas");     
//       }else{
//           System.out.println("--->no tiene bodegas");
//       }
      
        System.out.println("*********************************************");
htmlGenerator.generar();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("======================================");
        System.out.println("Destroying BodegaTest -- ");
        System.out.println("======================================");
    }
}
