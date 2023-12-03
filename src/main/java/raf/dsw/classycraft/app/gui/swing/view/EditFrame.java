package raf.dsw.classycraft.app.gui.swing.view;

import javafx.scene.layout.HBox;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditFrame implements ActionListener{
    private JComboBox vidljivost;
    private JTextField klasaIme;
    private JComboBox vidljivostPolja;
    private JTextField imePolja;
    private JComboBox odabirPolja;
    private ArrayList<ClassContents> classContents;
    private JButton confirm;
    private DiagramElement diagramElement;
    public EditFrame(DiagramElement diagramElement){init(diagramElement);}

    private void init(DiagramElement diagramElement) {
        JFrame editFrame = new JFrame();
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.getInsets().set(10,5,10,5);





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
        imePolja = new JTextField();
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

        odabirPolja.addItem("New field");
        odabirPolja.addItem("New method");

        if(diagramElement instanceof Class){
            Class klasa = (Class) diagramElement;
            this.diagramElement = klasa;
            klasaIme.setText(klasa.getName());
            vidljivost.setSelectedItem(klasa.getAccessModifier().toString());
            System.out.println(klasa);
            if (!(klasa.getClassContents().isEmpty())){
                for(ClassContents classContents:klasa.getClassContents()){
                    this.classContents.add(classContents);
                    odabirPolja.addItem(classContents.getName());
                }
            }
        } else if (diagramElement instanceof Interface) {
            Interface interfejs = (Interface) diagramElement;
            this.diagramElement = interfejs;
            klasaIme.setText(interfejs.getName());
            System.out.println(interfejs);
            if (!(interfejs.getMethods().isEmpty())){
                for (Method method: interfejs.getMethods()){
                    //this.metode.add(method);
                    odabirPolja.addItem(method.getName());
                }
            }
        }

        odabirPolja.addActionListener(this);
        comboBox2.add(odabirPolja);

        atributi.add(comboBox2);
        atributi.add(imenaPolja);
        atributi.add(vidljivostiPolja);

        centar.add(imeKlase);
        centar.add(vidljivostKlase);
        centar.add(atributi);


        //Buttons na dnu
        JButton confirm = new JButton();
        JButton remove = new JButton();
        confirm.setText("Confirm");
        remove.setText("Remove");
        confirm.addActionListener(this);
        confirm.setActionCommand("Confirm");

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(confirm);
        buttons.add(remove);




        editFrame.add(centar,BorderLayout.WEST);
        editFrame.add(buttons,BorderLayout.SOUTH);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String comand = e.getActionCommand();
        System.out.println("Ima promene");
        if (diagramElement instanceof Class){
            //rad sa poljima klase
            if(source.equals(odabirPolja)){
                System.out.println("source je odabir polja");
                if(getItemFromClassContentsList((String)odabirPolja.getSelectedItem(),classContents)!=null){
                    ClassContents content = getItemFromClassContentsList((String)odabirPolja.getSelectedItem(),classContents);
                    getImePolja().setText(content.getName());
                    getVidljivostPolja().setSelectedItem(content.getAccessModifier());
                }
                else {
                    getImePolja().setText("");
                    getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                }
            }
            //izmena klase
            if (comand.equals("Confirm")){
                System.out.println("Detektuje dugme");
                Class klasa = (Class)diagramElement;
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
                    klasa.getClassContents().add(new Atribute(getImePolja().getText(),ac));
                } else if (getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                    if (getOdabirPolja().getSelectedItem().toString().equals("New field")) {
                        AccessModifier ac = null;
                        if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                            ac = AccessModifier.PRIVATE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                            ac = AccessModifier.PUBLIC;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                            ac = AccessModifier.PACKAGE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                            ac = AccessModifier.PROTECTED;
                        klasa.getClassContents().add(new Method(getImePolja().getText(), ac));
                    }
                }
                else{
                    ClassContents polje = getItemFromClassContentsList((String)odabirPolja.getSelectedItem(),classContents);
                    polje.setName(getImePolja().getText());
                 //   polje.setAccessModifier(getVidljivostPolja().getSelectedItem().toString()); ovo sam ja promenio da bude enum samo se uzme classModifier.getname da bi dobio string
                    if(getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if(getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                }
            }

        }else if (diagramElement instanceof Interface){
            Interface interfejs = (Interface) diagramElement;
            if(source.equals(odabirPolja)){
                System.out.println("source je odabir polja");
                if(getItemFromMethodList((String)odabirPolja.getSelectedItem(),interfejs.getMethods())!=null){
                    Method metoda = getItemFromMethodList((String)odabirPolja.getSelectedItem(),interfejs.getMethods());
                    getImePolja().setText(metoda.getName());
                    getVidljivostPolja().setSelectedItem(metoda.getAccessModifier());
                }
                else {
                    getImePolja().setText("");
                    getVidljivostPolja().setSelectedItem(AccessModifier.PACKAGE);
                }
            }
            //izmena klase
            if (comand.equals("Confirm")) {
                System.out.println("Detektuje dugme u interfejs");
                if (getOdabirPolja().getSelectedItem().toString().equals("New field")) {
                    AccessModifier ac = null;
                    if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        ac = AccessModifier.PRIVATE;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        ac = AccessModifier.PUBLIC;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        ac = AccessModifier.PACKAGE;
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        ac = AccessModifier.PROTECTED;
                    interfejs.getMethods().add(new Method(getImePolja().getText(), ac));
                } else if (getOdabirPolja().getSelectedItem().toString().equals("New method")) {
                    if (getOdabirPolja().getSelectedItem().toString().equals("New field")) {
                        AccessModifier ac = null;
                        if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                            ac = AccessModifier.PRIVATE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                            ac = AccessModifier.PUBLIC;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                            ac = AccessModifier.PACKAGE;
                        else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                            ac = AccessModifier.PROTECTED;
                        interfejs.getMethods().add(new Method(getImePolja().getText(), ac));
                    }
                } else {
                    Method polje = getItemFromMethodList((String) odabirPolja.getSelectedItem(),interfejs.getMethods());
                    polje.setName(getImePolja().getText());
                    //   polje.setAccessModifier(getVidljivostPolja().getSelectedItem().toString()); ovo sam ja promenio da bude enum samo se uzme classModifier.getname da bi dobio string
                    if (getVidljivostPolja().getSelectedItem().toString().equals("PRIVATE"))
                        polje.setAccessModifier(AccessModifier.PRIVATE);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PUBLIC"))
                        polje.setAccessModifier(AccessModifier.PUBLIC);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PACKAGE"))
                        polje.setAccessModifier(AccessModifier.PACKAGE);
                    else if (getVidljivostPolja().getSelectedItem().toString().equals("PROTECTED"))
                        polje.setAccessModifier(AccessModifier.PROTECTED);
                }
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
