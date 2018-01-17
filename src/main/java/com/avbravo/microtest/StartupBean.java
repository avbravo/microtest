/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;


/**
 *
 * @author avbravo
 */
@Startup
@Singleton
public class StartupBean {
    public enum States {BEFORESTARTED, STARTED, PAUSED, SHUTTINGDOWN};
    private States state;
    private String clase;
    @PostConstruct
    public void initialize() {
        state = States.BEFORESTARTED;
        // Perform intialization
        state = States.STARTED;
        
        System.out.println("--------------------------------");
        System.out.println("----------->Service Started");
        System.out.println("--------------------------------");
    }
    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;
        // Perform termination
        System.out.println("--------------------------------");
        System.out.println("Shut down in progress");
        System.out.println("--------------------------------");
    }
    public States getState() {
        return state;
    }
    public void setState(States state) {
        this.state = state;
    }
}
