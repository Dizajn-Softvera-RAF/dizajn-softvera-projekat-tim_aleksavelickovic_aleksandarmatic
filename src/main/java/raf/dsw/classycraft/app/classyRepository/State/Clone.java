package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.util.ArrayList;

public class Clone implements State{
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        boolean exist=false;
        InterClass clone= null;
        for (ElementPainter ep : diagramView.getPainters()) {
            if (ep.elementAt(ep.getDiagramElement(), point, diagramView)){
                System.out.println("tu je kalsa");

                if(((InterClass)ep.getDiagramElement() instanceof Interface)) {
                    System.out.println("uslo u pravljenje interfejsa");
                    clone = (Interface) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("INTERFACE", ((InterClass) ep.getDiagramElement()).getName(), diagramView.getDiagram(), ep.getDiagramElement().getColor(), ep.getDiagramElement().getStroke(), ((InterClass) ep.getDiagramElement()).getAccessModifier(), new Point(((InterClass) ep.getDiagramElement()).getPostition().x + ((InterClass) ep.getDiagramElement()).getSize().width + 20, ((InterClass) ep.getDiagramElement()).getPostition().y + ((InterClass) ep.getDiagramElement()).getSize().height + 20), ((InterClass) ep.getDiagramElement()).getSize());
                    ((InterClass) clone).setName(ep.getDiagramElement().getName());
                    System.out.println("Ime clone elementa"+ep.getDiagramElement().getName());
                    for(Method m:((Interface) ep.getDiagramElement()).getMethods())
                        ((Interface)clone).addMethods(m);

                }
                if(((InterClass)ep.getDiagramElement() instanceof Class)) {
                    System.out.println("uslo u pravljenje interfejsa");
                    clone = (Class) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("CLASS", ((InterClass) ep.getDiagramElement()).getName(), diagramView.getDiagram(), ep.getDiagramElement().getColor(), ep.getDiagramElement().getStroke(), ((InterClass) ep.getDiagramElement()).getAccessModifier(), new Point(((InterClass) ep.getDiagramElement()).getPostition().x + ((InterClass) ep.getDiagramElement()).getSize().width + 20, ((InterClass) ep.getDiagramElement()).getPostition().y + ((InterClass) ep.getDiagramElement()).getSize().height + 20), ((InterClass) ep.getDiagramElement()).getSize());
                    ((InterClass) clone).setName(ep.getDiagramElement().getName());
                    for(ClassContents cc: ((Class) (InterClass) ep.getDiagramElement()).getClassContents())
                        ((Class) clone).addClassContents(cc);

                }
                if(((InterClass)ep.getDiagramElement() instanceof Enum)) {
                    System.out.println("uslo u pravljenje interfejsa");
                    clone = (Enum) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("ENUM", ((InterClass) ep.getDiagramElement()).getName(), diagramView.getDiagram(), ep.getDiagramElement().getColor(), ep.getDiagramElement().getStroke(), ((InterClass) ep.getDiagramElement()).getAccessModifier(), new Point(((InterClass) ep.getDiagramElement()).getPostition().x + ((InterClass) ep.getDiagramElement()).getSize().width + 20, ((InterClass) ep.getDiagramElement()).getPostition().y + ((InterClass) ep.getDiagramElement()).getSize().height + 20), ((InterClass) ep.getDiagramElement()).getSize());
                    ((InterClass) clone).setName(ep.getDiagramElement().getName());
                    for(String s:((Enum)ep.getDiagramElement()).getTypes())
                        ((Enum) clone).addTypes(s);

                }

            }

        }
        if(clone!= null) {
            InterClassPainter icp = new InterClassPainter(clone);
            diagramView.getDiagram().addChild(clone);
            diagramView.getPainters().add(icp);
        }



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

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {

    }
}
