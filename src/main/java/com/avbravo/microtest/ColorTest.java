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
import com.avbravo.jmoordbunit.htmlcomponents.Checkbox;
import com.avbravo.jmoordbunit.htmlcomponents.InputText;
import com.avbravo.jmoordbunit.htmlcomponents.Item;
import com.avbravo.jmoordbunit.htmlcomponents.Radio;
import com.avbravo.jmoordbunit.htmlcomponents.SelectOneMenu;
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
        panelSelectOneMenu();
        panelDataTable();
        findAll();
      failure();
        selectOneMenu();
        radio();
        checkbox();
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
            Boolean save = unitTest.assertEquals("save", true, colorRepository.save(color));

            /*
            Dibuja la interfaz
             */
            unitView.form();
            unitView.formTitle("Registros de colores");
            unitView.panel();

            unitView.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
                    new InputText("activo", color.getActivo())));

            unitView.panelClose();
            unitView.buttonGreen("Save");
            unitView.formClose();
            if (save) {
                unitView.message("se guardo exitosamente");
            } else {
                unitView.errorMessage("No se pudo guardar");
            }

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String panelSelectOneMenu() {
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
            Boolean save = unitTest.assertEquals("panelSelectOneMenu", true, colorRepository.save(color));

            /*
            Dibuja la interfaz
             */
            unitView.form();
            unitView.formTitle("panelSelectOneMenu()");
            unitView.panel();

            unitView.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
                    new InputText("activo", color.getActivo())));

            //-----------------------------
            List<Color> colorList = colorRepository.findAll();
            List<Item> itemList = new ArrayList<>();
            colorList.stream().map((c) -> new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor())).forEachOrdered((item) -> {
                itemList.add(item);
            });
            unitView.panelAddSelectOneMenu(
                    Arrays.asList(new SelectOneMenu("color", itemList)));

            //------------------
            unitView.panelClose();
            
            unitView.buttonGreen("Save");
            unitView.formClose();
            if (save) {
                unitView.message("se guardo exitosamente");
            } else {
                unitView.errorMessage("No se pudo guardar");
            }

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String panelSelectOneMenuCompuesto() {
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
            Boolean save = unitTest.assertEquals("panelSelectOneMenu", true, colorRepository.save(color));

            /*
            Dibuja la interfaz
             */
            unitView.form();
            unitView.formTitle("panelSelectOneMenu()");
            unitView.panel();

            unitView.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
                    new InputText("activo", color.getActivo())));

            //-----------------------------
            List<Color> colorList = colorRepository.findAll();
            List<Item> itemList = new ArrayList<>();
            for (Color c : colorList) {
                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
                itemList.add(item);
            }
            unitView.panelAddSelectOneMenu(
                    Arrays.asList(new SelectOneMenu("color", itemList)));

            //------------------
            unitView.panelClose();
            
            unitView.buttonGreen("Save");
            unitView.formClose();
            if (save) {
                unitView.message("se guardo exitosamente");
            } else {
                unitView.errorMessage("No se pudo guardar");
            }

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    @Test
    public String panelDataTable() {
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
            Boolean save = unitTest.assertEquals("panelDataTable", true, colorRepository.save(color));

            /*
            Dibuja la interfaz
             */
            unitView.form();
            unitView.formTitle("panelDataTable()");
            unitView.panel();

            unitView.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
                    new InputText("activo", color.getActivo())));

            //-----------------------------
            List<Color> colorList = colorRepository.findAll();
            List<Item> itemList = new ArrayList<>();
            for (Color c : colorList) {
                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
                itemList.add(item);
            }
            unitView.panelAddSelectOneMenu(
                    Arrays.asList(new SelectOneMenu("color", itemList)));

            //------------------
            unitView.panelAddTableHeader("colores", Arrays.asList(new RowView("idcolor"), new RowView("activo")));
            colorRepository.findAll().forEach((c) -> {
                unitView.panelAddTableCol(Arrays.asList(new ColView(c.getIdcolor()), new ColView(c.getActivo())));
            });
            unitView.panelAddTableClose();

            unitView.panelClose();
            unitView.buttonGreen("Save");
            unitView.formClose();
            if (save) {
                unitView.message("se guardo exitosamente");
            } else {
                unitView.errorMessage("No se pudo guardar");
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
                unitView.formTitle("findAll()");
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

    @Test
    public String radio() {
        try {
            //titulo de la tabla
            List<Color> colorList = colorRepository.findAll();
            if (colorList.isEmpty()) {
                unitView.message("no hay colores en en findAll()");
            } else {

                unitView.form();
                unitView.formTitle("Radio");
                unitView.panel();

                unitView.panelAddRadio(Arrays.asList(new Radio("sexo",
                        Arrays.asList(new Item("sexo", "Masculino", "Masculino"),
                                new Item("sexo", "Femenino", "Femenino")))));

                unitView.panelClose();
                unitView.formClose();

            }

            unitTest.assertEquals("radio", 1, colorList.size());
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return "";
    }

    @Test
    public String checkbox() {
        try {
            //titulo de la tabla
            List<Color> colorList = colorRepository.findAll();
            if (colorList.isEmpty()) {
                unitView.message("no hay colores en en findAll()");
            } else {

                unitView.form();
                unitView.formTitle("Checkbox");
                unitView.panel();

                unitView.panelAddCheckbox("sexo", Arrays.asList(new Checkbox("masculino", "Masculino", "Masculino"),
                        new Checkbox("femenino", "Femenino", "Femenino")));

                unitView.panelClose();
                unitView.formClose();

            }

            unitTest.assertEquals("findAll", 1, colorList.size());
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return "";
    }

    @Test
    public String selectOneMenu() {
        try {
            List<Color> colorList = colorRepository.findAll();
            if (colorList.isEmpty()) {
                unitView.message("no hay colores en en findAll()");
            } else {
            }

            //titulo de la tabla
            /*
            Dibuja la interfaz
             */
            unitView.form();
            unitView.formTitle("SelectOneMenu");
            unitView.panel();
            List<Item> itemList = new ArrayList<>();
            for (Color c : colorList) {
                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
                itemList.add(item);
            }
            unitView.panelAddSelectOneMenu(
                    Arrays.asList(new SelectOneMenu("color", itemList)));
            unitView.panelClose();

            unitView.formClose();

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
