package raf.dsw.classycraft.app.gui.swing.view;

import javafx.scene.layout.HBox;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.ClassContents;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.ArrayList;

public class EditFrame {
    private JComboBox classSelection;
    private JComboBox vidljivostPolja;
    private JTextField imePolja;
    private JTextField klasaIme;
    private JComboBox odabirPolja;
    public EditFrame(){init();}

    private void init() {
        JFrame editFrame = new JFrame();
        editFrame.setLayout(new BorderLayout());
        editFrame.setSize(500,500);
        editFrame.setTitle("Edit");
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.getInsets().set(10,5,10,5);

        //combobox na vrhu
        ArrayList<DiagramElement> diagramElements = new ArrayList<>();
        JPanel comboBox = new JPanel();
        comboBox.setLayout(new FlowLayout());
        classSelection = new JComboBox<>();
        classSelection.setEditable(false);
        if (MainFrame.getInstance().getPackageView().getDiagramView() != null){
            for(ElementPainter elementPainter: MainFrame.getInstance().getPackageView().getDiagramView().getPainters()){
                if (elementPainter instanceof InterClassPainter){
                    diagramElements.add(elementPainter.getDiagramElement());
                }
            }
        }
        for (DiagramElement diagramElement: diagramElements){
            classSelection.addItem(diagramElement.getName());
        }
        comboBox.add(classSelection);

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
        JComboBox vidljivost = new JComboBox();
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
        comboBox2.add(odabirPolja);
        odabirPolja.addItem("New field");
        odabirPolja.addItem("New method");
        if (classSelection.getSelectedItem()!= ""){
            for (DiagramElement diagramElement: diagramElements){
                if (diagramElement.getName().equals(classSelection.getSelectedItem()) && (diagramElement instanceof Class)){
                    Class klasa = (Class) diagramElement;
                    System.out.println(klasa);
                    for(ClassContents classContents:klasa.getClassContents()){
                        odabirPolja.addItem(classContents.getName());
                    }

                }
            }
        }

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
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(confirm);
        buttons.add(remove);



        editFrame.add(comboBox,BorderLayout.NORTH);
        editFrame.add(centar,BorderLayout.WEST);
        editFrame.add(buttons,BorderLayout.SOUTH);

        editFrame.setVisible(true);

    }

    public void setClassSelection(JComboBox classSelection) {
        this.classSelection = classSelection;
    }

    public JComboBox getClassSelection() {
        return classSelection;
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
}
