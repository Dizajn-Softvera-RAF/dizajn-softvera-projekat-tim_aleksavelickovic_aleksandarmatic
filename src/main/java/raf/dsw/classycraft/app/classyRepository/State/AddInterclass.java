package raf.dsw.classycraft.app.classyRepository.State;

import javafx.scene.shape.StrokeType;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Atribute;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.ClassContents;
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
        Class klasa = (Class) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("CLASS","klasa"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(150,100));
        i++;
        ClassContents cc=new Atribute("atribut",AccessModifier.PROTECTED);//gledaj sta ce da se desi
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
        MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),child); //3 sva tri treba ju da se odkomentarisu kad krenem novo
      //  MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),parent,child);
       // MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),diagramView.getDiagram(),child);
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
}
