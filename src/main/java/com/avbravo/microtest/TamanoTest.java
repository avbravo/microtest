/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbjmoordb.pojos.UserInfo;
import com.avbravo.ejbspard.entity.Tamano;
import com.avbravo.ejbspard.repository.TamanoRepository;
import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.test.UnitTest;
import java.util.ArrayList;
import java.util.List;
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
@Test(name = "TamanoTes")
public class TamanoTest {

    @Inject
    UnitTest unitTest;
    @Inject
    TamanoRepository tamanoRepository;

    @PostConstruct
    void init() {
        unitTest.start(TamanoTest.class);
        save();
        findAll();
        failure();
        unitTest.skipper("save()");

//        tamanoTest.findAll();
        // Here init your resources
    }

    @Test
    public String save() {
        try {
            //Mock
            Tamano tamano = new Tamano();
            tamano.setActivo("si");           
            tamano.setIdtamano("prueba");
            List<UserInfo> list = new ArrayList<>();
            tamano.setUserInfo(list);

            Boolean expResult = true;
            unitTest.assertEquals("save",true, tamanoRepository.save(tamano),"metodo save()");

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String findAll() {
        try {
           unitTest.assertEquals("findAll",5,tamanoRepository.findAll());

        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return "";
    }

    @PreDestroy
    public void destroy() {
        unitTest.end(TamanoTest.class);
    }
    
    @Test
    public void failure(){
        unitTest.fail("failure","Fallo intencional");
    }
}
