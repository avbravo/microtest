/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;


/**
 *
 * @author avbravo
 */
@Startup
@Singleton
@DependsOn("StartupBean")
public class PostStartupBean {
    @PostConstruct
  void init() {
        System.out.println("estoy en init() de PostStartupBean ()");
    // Here init your resources
  }
}
