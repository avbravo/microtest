/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Named(value = "start")
//@ApplicationScoped
@SessionScoped
public class Start implements Serializable{
@EJB
 
StartupBean ejb;

@Inject 
ColorTest colorTest;
 
    /**
     * Creates a new instance of Start
     */
    public Start() {
    }
    @PostConstruct
    public void init(){
        System.out.println("=======================================");
        System.out.println("---Arranco el server para test");
        
System.out.println("State is "+ejb.getState());
        System.out.println("=======================================");
        
    }
    public String run(){
        try {
            System.out.println("=======================================");
        System.out.println("---Run()");
        System.out.println("State is "+ejb.getState());
        System.out.println("=======================================");
        
      
        } catch (Exception e) {
            System.out.println("run() "+e.getLocalizedMessage());
        }
        
        

        return "";
    }
}
