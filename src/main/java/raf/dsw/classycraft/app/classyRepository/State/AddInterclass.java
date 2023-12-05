package raf.dsw.classycraft.app.classyRepository.State;

import javafx.scene.shape.StrokeType;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.util.ArrayList;

public class AddInterclass implements State{
    private int i = 0;
    private InterClass interClass;
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        System.out.println("misKlik");

        System.out.println(diagramView.getDiagram().getName());
      /* Class klasa = (Class) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("CLASS","klasa"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(150,100));
        i++;
        ClassContents cc=new Atribute("atribut",AccessModifier.PROTECTED);//gledaj sta ce da se desi
        ClassContents cc1=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc2=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc3=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc4=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc5=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc6=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc7=new Atribute("atribut1",AccessModifier.PACKAGE);
        ClassContents cc8=new Atribute("atribut1",AccessModifier.PACKAGE);
        klasa.addClassContents(cc);
        klasa.addClassContents(cc1);
        klasa.addClassContents(cc2);
        klasa.addClassContents(cc3);
        klasa.addClassContents(cc4);
        klasa.addClassContents(cc5);
        klasa.addClassContents(cc6);
        klasa.addClassContents(cc7);
        klasa.addClassContents(cc8);



       */

       Interface klasa = (Interface) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("INTERFACE","INTERFACE"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(150,100));
        i++;
        Method cc=new Method("atribut",AccessModifier.PROTECTED);//gledaj sta ce da se desi

        Method cc1=new Method("atribut1",AccessModifier.PROTECTED);
        Method cc2=new Method("atribut2",AccessModifier.PROTECTED);
        Method cc3=new Method("atribut3",AccessModifier.PROTECTED);
        Method cc4=new Method("atribut4",AccessModifier.PROTECTED);
        Method cc5=new Method("atribut5",AccessModifier.PROTECTED);
        Method cc6=new Method("atribut6",AccessModifier.PROTECTED);
        cc.setReturnType("int");
        cc1.setReturnType("int");
        cc2.setReturnType("int");
        cc3.setReturnType("int");
        cc4.setReturnType("int");
        cc5.setReturnType("int");
        cc6.setReturnType("int");
        klasa.addMethods(cc);
        klasa.addMethods(cc1);
        klasa.addMethods(cc2);
        klasa.addMethods(cc3);
        klasa.addMethods(cc4);
        klasa.addMethods(cc5);
        klasa.addMethods(cc6);






        InterClassPainter icp = new InterClassPainter(klasa);
        diagramView.getDiagram().addChild(klasa);
        this.setInterClass(klasa);
        //ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode();

        System.out.println(klasa.getName());

        //icp.setDiagramElement(klasa);
        if(icp.getDiagramElement()==null)
            System.out.println("null je na pocetku");
        diagramView.getPainters().add(icp);
        ClassyTreeItem parent=new ClassyTreeItem(diagramView.getDiagram());
        ClassyTreeItem child=new ClassyTreeItem(klasa);
//ovaj je bio pre i radi        MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),child); //3 sva tri treba ju da se odkomentarisu kad krenem novo
      //  MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),parent,child);
        MainFrame.getInstance().getClassyTreeImplementation().addChild(null,diagramView.getDiagram(),child);
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                System.out.println(ep.getDiagramElement().getName());
                if(ep.elementAt(ep.getDiagramElement(),point,diagramView))
                    System.out.println("jeste tu");
            }

        }




    }

    public InterClass getInterClass() {
        return interClass;
    }

    public void setInterClass(InterClass interClass) {
        this.interClass = interClass;
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }
}
