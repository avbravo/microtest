/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbjmoordb.pojos.UserInfo;
import com.avbravo.ejbspard.entity.Color;
import com.avbravo.ejbspard.repository.ColorRepository;
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
@DependsOn("StartupBean")
public class PostStartupBean {
//    @Inject
//    ColorTest colorTest;
    @Inject
    ColorRepository colorRepository;

    @PostConstruct
    void init() {
        System.out.println("--------------------------------------->");
        System.out.println("estoy en init() de PostStartupBean ()");
        System.out.println("--------------------------------------->");
        System.out.println("*********************************************");
        System.out.println("invocare al findAll()");
        Color color = new Color();
        color.setActivo("si");
        color.setAutoincrementable(15);
        color.setIdcolor("elsa");
      List<UserInfo> list  = new ArrayList<>();
        color.setUserInfo(list);
        if(colorRepository.save(color)){
            System.out.println("Guardado");
        }else{
            System.out.println("No guardado "+colorRepository.getException());
        }
        for(Color c:colorRepository.findAll()){
            System.out.println("color: "+c.getIdcolor());
        }
        System.out.println("*********************************************");
//        colorTest.findAll();
        // Here init your resources
    }

    @PreDestroy
    public void destroy() {
        System.out.println("======================================");
        System.out.println("Destroying configuration -- ");
        System.out.println("======================================");
    }
}
