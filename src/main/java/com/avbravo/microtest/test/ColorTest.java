/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest.test;

import com.avbravo.ejbspard.entity.Color;
import com.avbravo.ejbspard.repository.ColorRepository;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class ColorTest implements Serializable {
@Inject
    ColorRepository colorRepository;
    /**
     * Creates a new instance of Color
     */
    public ColorTest() {
    }
    
    public String findAll(){
        try {
            for(Color c:colorRepository.findAll()){
                System.out.println("Color "+c.getIdcolor());
            }
        } catch (Exception e) {
            System.out.println("findAll() "+e.getLocalizedMessage());
        }
        return "";
    }
}
