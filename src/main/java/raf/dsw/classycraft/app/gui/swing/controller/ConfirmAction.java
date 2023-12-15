package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfirmAction implements ActionListener {
    JButton dugme = new JButton();
    JComboBox box = new JComboBox<>();
    public ConfirmAction(JComboBox box){
        this.box = box;
        box.addActionListener(this);
    }

    public ConfirmAction(JButton dugme) {
        this.dugme = dugme;
        dugme.addActionListener(this);
        if (dugme.getText().equalsIgnoreCase("Confirm"))dugme.setActionCommand("Confirm");
        if (dugme.getText().equalsIgnoreCase("Remove"))dugme.setActionCommand("Remove");
    }

    public ConfirmAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String comand = e.getActionCommand();
        DiagramElement diagramElement = MainFrame.getInstance().getEditFrame().getDiagramElement();
        if (diagramElement instanceof Class){
            //rad sa poljima klase

            Class klasa = (Class)diagramElement;
            if(source.equals(MainFrame.getInstance().getEditFrame().getOdabirPolja())){
                if(getItemFromClassContentsList((String)MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem(),klasa.getClassContents())!=null){
                    ClassContents content = getItemFromClassContentsList((String)MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem(),klasa.getClassContents());//***
                    MainFrame.getInstance().getEditFrame().getImePolja().setText(content.getName());
                    MainFrame.getInstance().getEditFrame().getVidljivostPolja().setSelectedItem(content.getAccessModifier());
                    MainFrame.getInstance().getEditFrame().getTypeReturn().setText(content.getReturnType());

                }
                else {
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                    MainFrame.getInstance().getEditFrame().getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                    MainFrame.getInstance().getEditFrame().getTypeReturn().setText("");
                }
            }
            //izmena klase
            if (comand.equals("Confirm")){
                klasa.setName(MainFrame.getInstance().getEditFrame().getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                klasa.setAccessModifier(accessModifier);

                if (MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New field")){
                    AccessModifier ac=null;
                    if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac=AccessModifier.PRIVATE;
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac=AccessModifier.PUBLIC;
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac=AccessModifier.PACKAGE;
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac=AccessModifier.PROTECTED;
                    Atribute classContents1 = new Atribute(MainFrame.getInstance().getEditFrame().getImePolja().getText(),ac);
                    String type = MainFrame.getInstance().getEditFrame().getTypeReturn().getText();
                    classContents1.setReturnType(type);
                    klasa.addClassContents(classContents1);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New field");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                    if (!(klasa.getClassContents().isEmpty())) {
                        for (ClassContents cc : klasa.getClassContents()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(cc.getName());
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(classContents1.getName());
                } else if (MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                    AccessModifier ac = null;
                    if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac = AccessModifier.PRIVATE;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac = AccessModifier.PUBLIC;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac = AccessModifier.PACKAGE;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac = AccessModifier.PROTECTED;
                    Method classContents1 = new Method(MainFrame.getInstance().getEditFrame().getImePolja().getText(), ac);
                    String type = MainFrame.getInstance().getEditFrame().getTypeReturn().getText();
                    classContents1.setReturnType(type);
                    klasa.addClassContents(classContents1);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New field");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                    if (!(klasa.getClassContents().isEmpty())) {
                        for (ClassContents cc : klasa.getClassContents()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(cc.getName());
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(classContents1.getName());

                }
                else if(!(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals(""))){
                    Object currSelected = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem();
                    ClassContents currField = getItemFromClassContentsList((String)currSelected,klasa.getClassContents());//***
                    ClassContents polje = currField;
                    polje.setName(MainFrame.getInstance().getEditFrame().getImePolja().getText());
                    polje.setReturnType(MainFrame.getInstance().getEditFrame().getTypeReturn().getText());
                    if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if(MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                    MainFrame.getInstance().getEditFrame().getTypeReturn().setText("");
                    klasa.addClassContents(polje);
                    klasa.removeClassContents(currField);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New field");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem("New field");
                    if (!(klasa.getClassContents().isEmpty())) {
                        for (ClassContents cc : klasa.getClassContents()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(cc.getName());
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(polje.getName());
                }
            }if(comand.equals("Remove")&&!((MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals(""))||(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New field"))||(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New method")))){
                Object currSelected = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem();
                int i = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedIndex();
                ClassContents currField = getItemFromClassContentsList((String) currSelected,klasa.getClassContents());
                klasa.removeClassContents(currField);
                MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New field");
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                if (!(klasa.getClassContents().isEmpty())) {
                    for (ClassContents cc : klasa.getClassContents()) {
                        MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(cc.getName());
                    }
                }
                MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedIndex(i-1);

            }
        }
        ///INTEFEJS///
        else if (diagramElement instanceof Interface){
            Interface interfejs = (Interface) diagramElement;
            if(source.equals(MainFrame.getInstance().getEditFrame().getOdabirPolja())){
                if(getItemFromMethodList((String)MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem(),interfejs.getMethods())!=null){
                    Method metoda = getItemFromMethodList((String)MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem(),interfejs.getMethods());
                    MainFrame.getInstance().getEditFrame().getImePolja().setText(metoda.getName());
                    MainFrame.getInstance().getEditFrame().getVidljivostPolja().setSelectedItem(metoda.getAccessModifier());
                    MainFrame.getInstance().getEditFrame().getTypeReturn().setText(metoda.getReturnType());
                }
                else {
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                    MainFrame.getInstance().getEditFrame().getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                    MainFrame.getInstance().getEditFrame().getTypeReturn().setText("");
                }
            }
            //izmena klase
            if (comand.equals("Confirm")) {
                interfejs.setName(MainFrame.getInstance().getEditFrame().getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                interfejs.setAccessModifier(accessModifier);

                if (MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                    AccessModifier ac = null;
                    if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac = AccessModifier.PRIVATE;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac = AccessModifier.PUBLIC;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac = AccessModifier.PACKAGE;
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac = AccessModifier.PROTECTED;
                    Method metoda = new Method(MainFrame.getInstance().getEditFrame().getImePolja().getText(), ac);
                    metoda.setReturnType(MainFrame.getInstance().getEditFrame().getTypeReturn().getText());
                    interfejs.addMethods(metoda);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                    if (!(interfejs.getMethods().isEmpty())) {
                        for (Method method : interfejs.getMethods()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method.getName());
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(metoda.getName());

                } else if (!(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals(""))){
                    Object currChosen= MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem();
                    Method currMethod = getItemFromMethodList((String) currChosen,interfejs.getMethods());
                    Method polje = currMethod;
                    polje.setName(MainFrame.getInstance().getEditFrame().getImePolja().getText());
                    polje.setReturnType(MainFrame.getInstance().getEditFrame().getTypeReturn().getText());
                    if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if (MainFrame.getInstance().getEditFrame().getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                    interfejs.addMethods(polje);
                    interfejs.removeMethods(currMethod);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem("New method");
                    if (!(interfejs.getMethods().isEmpty())) {
                        for (Method method : interfejs.getMethods()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method.getName());
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(polje.getName());

                }
            }if (comand.equals("Remove")&&!((MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("")||(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New method"))))){

                Object currChosen= MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem();
                int i = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedIndex();
                Method currMethod = getItemFromMethodList((String) currChosen,interfejs.getMethods());
                interfejs.removeMethods(currMethod);
                MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New method");
                if (!(interfejs.getMethods().isEmpty())) {
                    for (Method method : interfejs.getMethods()) {
                        MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method.getName());
                    }
                }
                MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedIndex(i-1);
            }
        }
        ///ENUM///
        else if (diagramElement instanceof Enum) {
            Enum enum2 = (Enum) diagramElement;
            if(source.equals(MainFrame.getInstance().getEditFrame().getOdabirPolja())){
                if(!(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equalsIgnoreCase("New type"))){
                    String type = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString();
                    MainFrame.getInstance().getEditFrame().getImePolja().setText(type);
                }
                else {
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                }
            }
            if(comand.equals("Confirm")){
                enum2.setName(MainFrame.getInstance().getEditFrame().getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (MainFrame.getInstance().getEditFrame().getVidljivost().getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                enum2.setAccessModifier(accessModifier);
                if (MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New type")) {
                    String type = MainFrame.getInstance().getEditFrame().getImePolja().getText();
                    enum2.addTypes(type);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New type");
                    if (!(enum2.getTypes().isEmpty())) {
                        for (String method : enum2.getTypes()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method);
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(type);
                }else if (!(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().equals(""))){
                    String currType = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString();
                    String type = MainFrame.getInstance().getEditFrame().getImePolja().getText();
                    MainFrame.getInstance().getEditFrame().getImePolja().setText("");
                    enum2.addTypes(type);
                    enum2.removeTypes(currType);
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New type");
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem("New type");
                    if (!(enum2.getTypes().isEmpty())) {
                        for (String method : enum2.getTypes()) {
                            MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method);
                        }
                    }
                    MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedItem(type);
                }
            }
            if (comand.equals("Remove")&&!((MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals(""))||(MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString().equals("New type")))){
                int i = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedIndex();
                String currType = MainFrame.getInstance().getEditFrame().getOdabirPolja().getSelectedItem().toString();
                enum2.removeTypes(currType);
                MainFrame.getInstance().getEditFrame().getOdabirPolja().removeAllItems();
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("");
                MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem("New type");
                if (!(enum2.getTypes().isEmpty())) {
                    for (String method : enum2.getTypes()) {
                        MainFrame.getInstance().getEditFrame().getOdabirPolja().addItem(method);
                    }
                }
                MainFrame.getInstance().getEditFrame().getOdabirPolja().setSelectedIndex(i-1);
            }
        }
        ///VEZE///
        else if (comand.equals("Confirm")) {
            if (diagramElement instanceof Agregation) {
                Agregation veza = (Agregation) diagramElement;
                veza.setNameOfVariable(MainFrame.getInstance().getEditFrame().getNameOfVariable().getText());
                veza.setKardinalnost(MainFrame.getInstance().getEditFrame().getCardinality().getText());
                MainFrame.getInstance().getEditFrame().dispose();

            }
            if (diagramElement instanceof Composition) {
                Composition veza = (Composition) diagramElement;
                veza.setNameOfVariable(MainFrame.getInstance().getEditFrame().getNameOfVariable().getText());
                veza.setKardinalnost(MainFrame.getInstance().getEditFrame().getCardinality().getText());
                MainFrame.getInstance().getEditFrame().dispose();
            }
            if (diagramElement instanceof Generalization) {
                Generalization veza = (Generalization) diagramElement;
                veza.setNameOf(MainFrame.getInstance().getEditFrame().getNameOf().getText());
                MainFrame.getInstance().getEditFrame().dispose();
            }
            if (diagramElement instanceof Dependency) {
                Dependency veza = (Dependency) diagramElement;
                veza.setType(MainFrame.getInstance().getEditFrame().getType().getText());
                MainFrame.getInstance().getEditFrame().dispose();
            }
        }
    }
    public ClassContents getItemFromClassContentsList(String ime, ArrayList<ClassContents> classContents){
        ClassContents trazeni;
        for(ClassContents cc: classContents){
            if(cc.getName().equals(ime)){trazeni = cc;return trazeni;}
        }
        return null;
    }
    public  Method getItemFromMethodList(String ime, ArrayList<Method> metode){
        Method metoda;
        for (Method metod: metode){
            if (metod.getName().equals(ime)){metoda = metod;return metoda;}
        }

        return null;
    }
}
