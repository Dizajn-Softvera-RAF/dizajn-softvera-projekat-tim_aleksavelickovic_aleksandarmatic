package raf.dsw.classycraft.app.gui.swing.view;

import javafx.scene.layout.HBox;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class EditFrame implements ActionListener{
    private JComboBox vidljivost;
    private JTextField klasaIme;
    private JComboBox vidljivostPolja;
    private JTextField imePolja;
    private JComboBox odabirPolja;
    private ArrayList<ClassContents> classContents;
    private JButton confirm;
    private DiagramElement diagramElement;
    private JTextField typeReturn;
    private JTextField nameOfVariable;
    private JTextField cardinality;
    private JTextField type;
    private JTextField nameOf;
    public EditFrame(DiagramElement diagramElement){if(diagramElement instanceof InterClass)init(diagramElement);
    else if (diagramElement instanceof Agregation) {
        init1(diagramElement);
    } else if (diagramElement instanceof Composition) {
        init2(diagramElement);
    } else if (diagramElement instanceof Generalization) {
        init4(diagramElement);
    } else if (diagramElement instanceof Dependency) {
        init3(diagramElement);
    }
    }

    private void init(DiagramElement diagramElement) {
        JFrame editFrame = new JFrame();
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);






        //centar
        JPanel centar = new JPanel();
        BoxLayout box = new BoxLayout(centar,BoxLayout.Y_AXIS);
        centar.setLayout(box);

        //ime klase
        JPanel imeKlase = new JPanel();
        imeKlase.setLayout(new FlowLayout());
        klasaIme = new JTextField();
        klasaIme.setEditable(true);
        klasaIme.setPreferredSize(new Dimension(200,20));
        imeKlase.add(new JLabel("Class Name"));
        imeKlase.add(klasaIme);

        //vidljivost klase
        JPanel vidljivostKlase = new JPanel();
        vidljivostKlase.setLayout(new FlowLayout());
        vidljivostKlase.add(new JLabel("Access Modifier:"));
        vidljivost = new JComboBox();
        vidljivost.setEditable(false);
        vidljivost.addItem(AccessModifier.PRIVATE);
        vidljivost.addItem(AccessModifier.PACKAGE);
        vidljivost.addItem(AccessModifier.PUBLIC);
        vidljivost.addItem(AccessModifier.PROTECTED);
        vidljivostKlase.add(vidljivost);

        //polja i metoda odabrane klase
        JPanel atributi = new JPanel();
        atributi.setLayout(new BoxLayout(atributi,BoxLayout.Y_AXIS));

        JPanel imenaPolja = new JPanel();
        imenaPolja.setLayout(new FlowLayout());
        imenaPolja.add(new JLabel("Name:"));
        imePolja = new JTextField("");
        imePolja.setEditable(true);
        imePolja.setPreferredSize(new Dimension(200,20));
        imenaPolja.add(imePolja);

        JPanel vidljivostiPolja = new JPanel(new FlowLayout());
        vidljivostiPolja.add(new JLabel("Access Modifier of field or method:"));
        vidljivostPolja = new JComboBox();
        vidljivostPolja.setEditable(false);
        vidljivostPolja.addItem(AccessModifier.PRIVATE);
        vidljivostPolja.addItem(AccessModifier.PACKAGE);
        vidljivostPolja.addItem(AccessModifier.PUBLIC);
        vidljivostPolja.addItem(AccessModifier.PROTECTED);
        vidljivostiPolja.add(vidljivostPolja);

        JPanel comboBox2 = new JPanel(new FlowLayout());
        odabirPolja = new JComboBox<>();
        odabirPolja.addItem("");

        JPanel returnType = new JPanel(new FlowLayout());
        returnType.add(new JLabel("Return type:"));
        typeReturn = new JTextField("");
        typeReturn.setEditable(true);
        typeReturn.setPreferredSize(new Dimension(200,20));
        returnType.add(typeReturn);

        if(diagramElement instanceof Class){
            Class klasa = (Class) diagramElement;//***
            klasaIme.setText(klasa.getName());
            vidljivost.setSelectedItem(klasa.getAccessModifier().toString());
            this.diagramElement = klasa;
            System.out.println(klasa);
            odabirPolja.addItem("New field");
            odabirPolja.addItem("New method");
            if (!(klasa.getClassContents().isEmpty())){
                for(ClassContents classContents:klasa.getClassContents()){
                    odabirPolja.addItem(classContents.getName());
                }
            }
        } else if (diagramElement instanceof Interface) {
            Interface interfejs = (Interface) diagramElement;
            this.diagramElement = interfejs;
            klasaIme.setText(interfejs.getName());
            vidljivost.setSelectedItem(interfejs.getAccessModifier().toString());

            odabirPolja.addItem("New method");
            if (!(interfejs.getMethods().isEmpty())){
                for (Method method: interfejs.getMethods()){
                    odabirPolja.addItem(method.getName());
                }
            }
        } else if (diagramElement instanceof Enum) {
            Enum enum1 = (Enum) diagramElement;
            klasaIme.setText(enum1.getName());
            this.diagramElement = enum1;
            odabirPolja.addItem("New type");
            if (!(enum1.getTypes().isEmpty())){
                for (String type:enum1.getTypes())odabirPolja.addItem(type);
            }
        }
        odabirPolja.setSelectedItem("");
        odabirPolja.addActionListener(this);
        comboBox2.add(odabirPolja);

        atributi.add(comboBox2);
        atributi.add(imenaPolja);
        if (diagramElement instanceof Class || diagramElement instanceof Interface){atributi.add(vidljivostiPolja);atributi.add(returnType);}


        centar.add(imeKlase);
        centar.add(vidljivostKlase);
        centar.add(atributi);


        //Buttons na dnu
        confirm = new JButton();
        JButton remove = new JButton();
        confirm.setText("Confirm");
        remove.setText("Remove");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");
        remove.addActionListener(this);
        remove.setActionCommand("Remove");

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(confirm);
        buttons.add(remove);




        editFrame.add(centar,BorderLayout.WEST);
        editFrame.add(buttons,BorderLayout.SOUTH);

        editFrame.setVisible(true);

    }
    private void init1(DiagramElement diagramElement){JFrame editFrame = new JFrame();
        Agregation veza = (Agregation)diagramElement;
        this.diagramElement = veza;
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.getInsets().set(10,5,10,5);

        JPanel name = new JPanel(new FlowLayout());
        name.add(new JLabel("Name of variable:"));
        nameOfVariable = new JTextField();
        nameOfVariable.setPreferredSize(new Dimension(200,20));
        nameOfVariable.setText(veza.getNameOfVariable());
        name.add(nameOfVariable);

        JPanel kardinalnost = new JPanel(new FlowLayout());
        kardinalnost.add(new JLabel("Cardinality:"));
        cardinality = new JTextField();
        cardinality.setPreferredSize(new Dimension(200,20));
        cardinality.setText(veza.getKardinalnost());
        kardinalnost.add(cardinality);

        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
        body.add(name);
        body.add(kardinalnost);
        JPanel bot = new JPanel(new FlowLayout());
        bot.add(confirm);

        editFrame.add(body,BorderLayout.CENTER);

        editFrame.add(bot,BorderLayout.SOUTH);
        editFrame.setVisible(true);
    }
    private void init2(DiagramElement diagramElement){JFrame editFrame = new JFrame();
        Composition veza = (Composition) diagramElement;
        this.diagramElement = veza;
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.getInsets().set(10,5,10,5);

        JPanel name = new JPanel(new FlowLayout());
        name.add(new JLabel("Name of variable:"));
        nameOfVariable = new JTextField();
        nameOfVariable.setPreferredSize(new Dimension(200,20));
        nameOfVariable.setText(veza.getNameOfVariable());
        name.add(nameOfVariable);

        JPanel kardinalnost = new JPanel(new FlowLayout());
        kardinalnost.add(new JLabel("Cardinality:"));
        cardinality = new JTextField();
        cardinality.setPreferredSize(new Dimension(200,20));
        cardinality.setText(veza.getKardinalnost());
        kardinalnost.add(cardinality);

        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
        body.add(name);
        body.add(kardinalnost);

        editFrame.add(body,BorderLayout.CENTER);
        editFrame.add(confirm,BorderLayout.SOUTH);
        editFrame.setVisible(true);
    }

    private void init3(DiagramElement diagramElement){JFrame editFrame = new JFrame();
        Dependency veza = (Dependency)diagramElement;
        this.diagramElement = veza;
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel typePanel = new JPanel(new FlowLayout());
        typePanel.add(new JLabel("Type:"));
        type = new JTextField();
        type.setPreferredSize(new Dimension(200,20));
        type.setText(veza.getType());
        typePanel.add(type);

        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");

        editFrame.add(typePanel,BorderLayout.CENTER);
        editFrame.add(confirm,BorderLayout.SOUTH);
        editFrame.setVisible(true);
        }
    private void init4(DiagramElement diagramElement){JFrame editFrame = new JFrame();
        Generalization veza = (Generalization)diagramElement;
        this.diagramElement = veza;
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel centar = new JPanel(new FlowLayout());
        centar.add(new JLabel("Name of:"));
        nameOf = new JTextField();
        nameOf.setPreferredSize(new Dimension(200,20));
        nameOf.setEditable(true);
        nameOf.setText(veza.getNameOf());
        centar.add(nameOf);
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");

        editFrame.add(centar,BorderLayout.CENTER);
        editFrame.add(confirm,BorderLayout.SOUTH);
        editFrame.setVisible(true);
        }


    public JComboBox getVidljivostPolja() {
        return vidljivostPolja;
    }

    public JTextField getImePolja() {
        return imePolja;
    }

    public JTextField getKlasaIme() {
        return klasaIme;
    }

    public void setVidljivostPolja(JComboBox vidljivostPolja) {
        this.vidljivostPolja = vidljivostPolja;
    }

    public void setImePolja(JTextField imePolja) {
        this.imePolja = imePolja;
    }

    public void setKlasaIme(JTextField klasaIme) {
        this.klasaIme = klasaIme;
    }


    public JComboBox getVidljivost() {
        return vidljivost;
    }

    public JComboBox getOdabirPolja() {
        return odabirPolja;
    }

    public ArrayList<ClassContents> getClassContents() {
        return classContents;
    }

    public JButton getConfirm() {
        return confirm;
    }

    public void setOdabirPolja(JComboBox odabirPolja) {
        this.odabirPolja = odabirPolja;
    }

    public void setVidljivost(JComboBox vidljivost) {
        this.vidljivost = vidljivost;
    }



    public void setClassContents(ArrayList<ClassContents> classContents) {
        this.classContents = classContents;
    }

    public void setConfirm(JButton confirm) {
        this.confirm = confirm;
    }

    public JTextField getTypeReturn() {
        return typeReturn;
    }

    public void setTypeReturn(JTextField typeReturn) {
        this.typeReturn = typeReturn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String comand = e.getActionCommand();

        if (diagramElement instanceof Class){
            //rad sa poljima klase
            Class klasa = (Class)diagramElement;
            if(source.equals(odabirPolja)){
                if(getItemFromClassContentsList((String)odabirPolja.getSelectedItem(),klasa.getClassContents())!=null){
                    ClassContents content = getItemFromClassContentsList((String)odabirPolja.getSelectedItem(),klasa.getClassContents());//***
                    getImePolja().setText(content.getName());
                    getVidljivostPolja().setSelectedItem(content.getAccessModifier());
                    getTypeReturn().setText(content.getReturnType());

                }
                else {
                    getImePolja().setText("");
                    getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                    getTypeReturn().setText("");
                }
            }
            //izmena klase
            if (comand.equals("Confirm")){
                klasa.setName(getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(vidljivost.getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                klasa.setAccessModifier(accessModifier);

                if (getOdabirPolja().getSelectedItem().toString().equals("New field")){
                    AccessModifier ac=null;
                    if(getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac=AccessModifier.PRIVATE;
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac=AccessModifier.PUBLIC;
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac=AccessModifier.PACKAGE;
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac=AccessModifier.PROTECTED;
                    Atribute classContents1 = new Atribute(getImePolja().getText(),ac);
                    String type = getTypeReturn().getText();
                    classContents1.setReturnType(type);
                    klasa.addClassContents(classContents1);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("");
                    odabirPolja.addItem("New field");
                    odabirPolja.addItem("New method");
                    if (!(klasa.getClassContents().isEmpty())) {
                        for (ClassContents cc : klasa.getClassContents()) {
                            odabirPolja.addItem(cc.getName());
                        }
                    }
                    odabirPolja.setSelectedItem(classContents1.getName());
                } else if (getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                        AccessModifier ac = null;
                        if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                            ac = AccessModifier.PRIVATE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                            ac = AccessModifier.PUBLIC;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                            ac = AccessModifier.PACKAGE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                            ac = AccessModifier.PROTECTED;
                        Method classContents1 = new Method(getImePolja().getText(), ac);
                        String type = getTypeReturn().getText();
                        classContents1.setReturnType(type);
                        klasa.addClassContents(classContents1);
                        odabirPolja.removeAllItems();
                        odabirPolja.addItem("");
                        odabirPolja.addItem("New field");
                        odabirPolja.addItem("New method");
                        if (!(klasa.getClassContents().isEmpty())) {
                            for (ClassContents cc : klasa.getClassContents()) {
                                odabirPolja.addItem(cc.getName());
                            }
                        }
                        odabirPolja.setSelectedItem(classContents1.getName());

                }
                else if(!(odabirPolja.getSelectedItem().toString().equals(""))){
                    Object currSelected = odabirPolja.getSelectedItem();
                    ClassContents currField = getItemFromClassContentsList((String)currSelected,klasa.getClassContents());//***
                    ClassContents polje = currField;
                    polje.setName(getImePolja().getText());
                    polje.setReturnType(getTypeReturn().getText());
                    if(getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                    getImePolja().setText("");
                    getTypeReturn().setText("");
                    klasa.addClassContents(polje);
                    klasa.removeClassContents(currField);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("");
                    odabirPolja.addItem("New field");
                    odabirPolja.addItem("New method");
                    odabirPolja.setSelectedItem("New field");
                    if (!(klasa.getClassContents().isEmpty())) {
                        for (ClassContents cc : klasa.getClassContents()) {
                            odabirPolja.addItem(cc.getName());
                        }
                    }
                    odabirPolja.setSelectedItem(polje.getName());
                }
            }if(comand.equals("Remove")&&!((odabirPolja.getSelectedItem().toString().equals(""))||(odabirPolja.getSelectedItem().toString().equals("New field"))||(odabirPolja.getSelectedItem().toString().equals("New method")))){
                Object currSelected = odabirPolja.getSelectedItem();
                int i = odabirPolja.getSelectedIndex();
                ClassContents currField = getItemFromClassContentsList((String) currSelected,klasa.getClassContents());
                klasa.removeClassContents(currField);
                odabirPolja.removeAllItems();
                odabirPolja.addItem("");
                odabirPolja.addItem("New field");
                odabirPolja.addItem("New method");
                if (!(klasa.getClassContents().isEmpty())) {
                    for (ClassContents cc : klasa.getClassContents()) {
                        odabirPolja.addItem(cc.getName());
                    }
                }
                odabirPolja.setSelectedIndex(i-1);

            }

        ///INTEFEJS///
        }else if (diagramElement instanceof Interface){
            Interface interfejs = (Interface) diagramElement;
            if(source.equals(odabirPolja)){
                if(getItemFromMethodList((String)odabirPolja.getSelectedItem(),interfejs.getMethods())!=null){
                    Method metoda = getItemFromMethodList((String)odabirPolja.getSelectedItem(),interfejs.getMethods());
                    getImePolja().setText(metoda.getName());
                    getVidljivostPolja().setSelectedItem(metoda.getAccessModifier());
                    getTypeReturn().setText(metoda.getReturnType());
                }
                else {
                    getImePolja().setText("");
                    getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                    getTypeReturn().setText("");
                }
            }
            //izmena klase
            if (comand.equals("Confirm")) {
                interfejs.setName(getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(vidljivost.getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                interfejs.setAccessModifier(accessModifier);

                if (getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                    AccessModifier ac = null;
                    if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac = AccessModifier.PRIVATE;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac = AccessModifier.PUBLIC;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac = AccessModifier.PACKAGE;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac = AccessModifier.PROTECTED;
                    Method metoda = new Method(getImePolja().getText(), ac);
                    metoda.setReturnType(getTypeReturn().getText());
                    interfejs.addMethods(metoda);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("");
                    odabirPolja.addItem("New method");
                    if (!(interfejs.getMethods().isEmpty())) {
                        for (Method method : interfejs.getMethods()) {
                            odabirPolja.addItem(method.getName());
                        }
                    }
                    odabirPolja.setSelectedItem(metoda.getName());

                } else if (!(odabirPolja.getSelectedItem().toString().equals(""))){
                    Object currChosen= odabirPolja.getSelectedItem();
                    Method currMethod = getItemFromMethodList((String) currChosen,interfejs.getMethods());
                    Method polje = currMethod;
                    polje.setName(getImePolja().getText());
                    polje.setReturnType(getTypeReturn().getText());
                    if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                    getImePolja().setText("");
                    interfejs.addMethods(polje);
                    interfejs.removeMethods(currMethod);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("");
                    odabirPolja.addItem("New method");
                    odabirPolja.setSelectedItem("New method");
                    if (!(interfejs.getMethods().isEmpty())) {
                        for (Method method : interfejs.getMethods()) {
                            odabirPolja.addItem(method.getName());
                        }
                    }
                    odabirPolja.setSelectedItem(polje.getName());

                }
            }if (comand.equals("Remove")&&!((odabirPolja.getSelectedItem().toString().equals("")||(odabirPolja.getSelectedItem().toString().equals("New method"))))){

                Object currChosen= odabirPolja.getSelectedItem();
                int i = odabirPolja.getSelectedIndex();
                Method currMethod = getItemFromMethodList((String) currChosen,interfejs.getMethods());
                interfejs.removeMethods(currMethod);
                odabirPolja.removeAllItems();
                odabirPolja.addItem("");
                odabirPolja.addItem("New method");
                if (!(interfejs.getMethods().isEmpty())) {
                    for (Method method : interfejs.getMethods()) {
                        odabirPolja.addItem(method.getName());
                    }
                }
                odabirPolja.setSelectedIndex(i-1);
            }
         ///ENUM///
        }else if (diagramElement instanceof Enum) {
            Enum enum2 = (Enum) diagramElement;
            if(source.equals(odabirPolja)){
                if(!(odabirPolja.getSelectedItem().toString().equalsIgnoreCase("New type"))){
                    String type = odabirPolja.getSelectedItem().toString();
                    getImePolja().setText(type);
                }
                else {
                    getImePolja().setText("");
                }
            }
            if(comand.equals("Confirm")){
                enum2.setName(getKlasaIme().getText());
                AccessModifier accessModifier = null;
                if(vidljivost.getSelectedItem().toString().equals(AccessModifier.PRIVATE.toString()))accessModifier = AccessModifier.PRIVATE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PACKAGE.toString()))accessModifier = AccessModifier.PACKAGE;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PROTECTED.toString()))accessModifier = AccessModifier.PROTECTED;
                else if (vidljivost.getSelectedItem().toString().equals(AccessModifier.PUBLIC.toString()))accessModifier = AccessModifier.PUBLIC;
                enum2.setAccessModifier(accessModifier);
                if (getOdabirPolja().getSelectedItem().toString().equals("New type")) {
                    String type = imePolja.getText();
                    enum2.addTypes(type);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("New type");
                    if (!(enum2.getTypes().isEmpty())) {
                        for (String method : enum2.getTypes()) {
                            odabirPolja.addItem(method);
                        }
                    }
                    odabirPolja.setSelectedItem(type);
                }else if (!(odabirPolja.getSelectedItem().equals(""))){
                    String currType = odabirPolja.getSelectedItem().toString();
                    String type = imePolja.getText();
                    getImePolja().setText("");
                    enum2.addTypes(type);
                    enum2.removeTypes(currType);
                    odabirPolja.removeAllItems();
                    odabirPolja.addItem("");
                    odabirPolja.addItem("New type");
                    odabirPolja.setSelectedItem("New type");
                    if (!(enum2.getTypes().isEmpty())) {
                        for (String method : enum2.getTypes()) {
                            odabirPolja.addItem(method);
                        }
                    }
                    odabirPolja.setSelectedItem(type);
                }
            }
            if (comand.equals("Remove")&&!((odabirPolja.getSelectedItem().toString().equals(""))||(odabirPolja.getSelectedItem().toString().equals("New type")))){
                int i = odabirPolja.getSelectedIndex();
                String currType = odabirPolja.getSelectedItem().toString();
                enum2.removeTypes(currType);
                odabirPolja.removeAllItems();
                odabirPolja.addItem("");
                odabirPolja.addItem("New type");
                if (!(enum2.getTypes().isEmpty())) {
                    for (String method : enum2.getTypes()) {
                        odabirPolja.addItem(method);
                    }
                }
                odabirPolja.setSelectedIndex(i-1);
            }
        }else if (comand.equals("Confirm")) {
            if (diagramElement instanceof Agregation) {
                Agregation veza = (Agregation) diagramElement;
                veza.setNameOfVariable(nameOfVariable.getText());
                veza.setKardinalnost(cardinality.getText());

            }
            if (diagramElement instanceof Composition) {
                Composition veza = (Composition) diagramElement;
                veza.setNameOfVariable(nameOfVariable.getText());
                veza.setKardinalnost(cardinality.getText());
            }
            if (diagramElement instanceof Generalization) {
                Generalization veza = (Generalization) diagramElement;
                veza.setNameOf(nameOf.getText());
            }
            if (diagramElement instanceof Dependency) {

                Dependency veza = (Dependency) diagramElement;
                veza.setType(type.getText());
            }
        }
    }
    public  Method getItemFromMethodList(String ime, ArrayList<Method> metode){
        Method metoda;
        for (Method metod: metode){
            if (metod.getName().equals(ime)){metoda = metod;return metoda;}
        }

        return null;
    }
    public ClassContents getItemFromClassContentsList(String ime, ArrayList<ClassContents> classContents){
        ClassContents trazeni;
        for(ClassContents cc: classContents){
            if(cc.getName().equals(ime)){trazeni = cc;return trazeni;}
        }
        return null;
    }

}
