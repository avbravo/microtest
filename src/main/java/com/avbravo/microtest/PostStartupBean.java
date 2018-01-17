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
//    @Inject
//    ColorRepository colorRepository;

    @PostConstruct
    void init() {
        System.out.println("--------------------------------------->");
        System.out.println("estoy en init() de PostStartupBean ()");
        System.out.println("--------------------------------------->");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("======================================");
        System.out.println("Destroying configuration -- ");
        System.out.println("======================================");
    }
}
