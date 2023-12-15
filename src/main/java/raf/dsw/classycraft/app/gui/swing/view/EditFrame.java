package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.gui.swing.controller.ConfirmAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditFrame {
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
    private JFrame editFrame;
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
        editFrame = new JFrame();
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
        MainFrame.getInstance().getActionManager().setConfirmAction(odabirPolja);
        //new ConfirmAction(odabirPolja);
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
        MainFrame.getInstance().getActionManager().setConfirmAction(confirm);
        MainFrame.getInstance().getActionManager().setConfirmAction(remove);
        //new ConfirmAction(confirm);
        //new ConfirmAction(remove);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(confirm);
        buttons.add(remove);




        editFrame.add(centar,BorderLayout.WEST);
        editFrame.add(buttons,BorderLayout.SOUTH);
        editFrame.setVisible(true);


    }
    private void init1(DiagramElement diagramElement){
        editFrame = new JFrame();
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
        MainFrame.getInstance().getActionManager().setConfirmAction(confirm);
        //new ConfirmAction(confirm);
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
    private void init2(DiagramElement diagramElement){
        editFrame = new JFrame();
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
        MainFrame.getInstance().getActionManager().setConfirmAction(confirm);
        //new ConfirmAction(confirm);
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
        body.add(name);
        body.add(kardinalnost);

        editFrame.add(body,BorderLayout.CENTER);
        editFrame.add(confirm,BorderLayout.SOUTH);
        editFrame.setVisible(true);
    }

    private void init3(DiagramElement diagramElement){
        editFrame = new JFrame();
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
        MainFrame.getInstance().getActionManager().setConfirmAction(confirm);
        //new ConfirmAction(confirm);

        editFrame.add(typePanel,BorderLayout.CENTER);
        editFrame.add(confirm,BorderLayout.SOUTH);
        editFrame.setVisible(true);
        }
    private void init4(DiagramElement diagramElement){
        editFrame = new JFrame();
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
        MainFrame.getInstance().getActionManager().setConfirmAction(confirm);
        //new ConfirmAction(confirm);

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

    public DiagramElement getDiagramElement() {
        return diagramElement;
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

    public JTextField getNameOfVariable() {
        return nameOfVariable;
    }

    public JTextField getCardinality() {
        return cardinality;
    }

    public JTextField getNameOf() {
        return nameOf;
    }

    public JTextField getType() {
        return type;
    }
    public void dispose(){
        this.editFrame.dispose();
    }
}
