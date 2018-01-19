/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbjmoordb.pojos.UserInfo;
import com.avbravo.ejbspard.entity.Color;
import com.avbravo.ejbspard.repository.ColorRepository;
import com.avbravo.jmoordbunit.anotation.Report;
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
public class ColorTest {

    @Inject
    UnitTest unitTest;
    @Inject
    ColorRepository colorRepository;

    @PostConstruct
    void init() {
        unitTest.start(ColorTest.class);
        save();
        findAll();
        failure();
        unitTest.skipper("delete()");

    }

    @Test
    public String save() {
        try {
            //Mock
            Color color = new Color();
            color.setActivo("si");
            color.setAutoincrementable(15);
            color.setIdcolor("elsa");
            List<UserInfo> list = new ArrayList<>();
            color.setUserInfo(list);
            Boolean expResult = true;
            unitTest.assertEquals(true, colorRepository.save(color));

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String findAll() {
        try {
            for (Color c : colorRepository.findAll()) {
                System.out.println("color: " + c.getIdcolor());
            }
         
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return "";
    }

    @PreDestroy
    public void destroy() {
        unitTest.end(ColorTest.class);
    }
    
    @Test
    public void failure(){
        unitTest.fail("Fallo intencional");
    }
}
