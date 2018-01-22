/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microtest;

import com.avbravo.ejbjmoordb.pojos.UserInfo;
import com.avbravo.ejbspard.entity.Color;
import com.avbravo.ejbspard.repository.ColorRepository;
import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.datatable.ColView;
import com.avbravo.jmoordbunit.datatable.RowView;
import com.avbravo.jmoordbunit.htmlcomponents.InputText;
import com.avbravo.jmoordbunit.test.UnitTest;
import com.avbravo.jmoordbunit.view.UnitView;
import java.util.ArrayList;
import java.util.Arrays;
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
    UnitView unitView;
    @Inject
    ColorRepository colorRepository;

    @PostConstruct
    void init() {
        unitTest.start(ColorTest.class);
      unitView.start(ColorTest.class);
        save();
        findAll();
        failure();
        unitTest.skipper("delete()");
        unitTest.end(ColorTest.class);
    }

    @Test
    public String save() {
        try {
//            unitView.message("Testeando save()");
//Mock
            Color color = new Color();
            color.setActivo("si");
            color.setAutoincrementable(15);
            color.setIdcolor("rojo");
            List<UserInfo> list = new ArrayList<>();
            color.setUserInfo(list);
            Boolean expResult = true;
       Boolean save=     unitTest.assertEquals("save", true, colorRepository.save(color));
            
            /*
            Dibuja la interfaz
            */
            unitView.h1("Registros de colores");
            unitView.form();
            unitView.panel();
            unitView.panelRow();
            unitView.panelAdd(Arrays.asList(new InputText("idcolor", color.getIdcolor()), 
                    new InputText("activo", color.getActivo())));
            unitView.panelRowClose();
            unitView.panelClose();
            unitView.button("Save");
            unitView.formClose();
            if(save){
                unitView.message("se guardo exitosamente");
            }else{
                unitView.error("No se pudo guardar");
            }
            

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String findAll() {
        try {
            //titulo de la tabla
            List<Color> colorList = colorRepository.findAll();
            if (colorList.isEmpty()) {
               unitView.message("no hay colores en en findAll()");
            } else {
                  unitView.h2("ejecutare un  colorRepositoryfindAll()");
               unitView.tableHeader(Arrays.asList(new RowView("idcolor"), new RowView("activo")));
               colorRepository.findAll().forEach((c) -> {
                   unitView.tableCol(Arrays.asList(new ColView(c.getIdcolor()), new ColView(c.getActivo())));
                   //  System.out.println("color: " + c.getIdcolor());
                });
               unitView.tableClose();
            }

            unitTest.assertEquals("findAll", 1, colorList.size());
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return "";
    }

    @PreDestroy
    public void destroy() {

    }

    @Test
    public void failure() {
        unitTest.fail("failure", "Fallo intencional");
    }
}
