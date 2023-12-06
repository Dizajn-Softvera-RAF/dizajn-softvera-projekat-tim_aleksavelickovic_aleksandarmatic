package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import java.awt.*;
import java.util.ArrayList;

public class AddElement implements State{

    ArrayList<DiagramElement>elements=new ArrayList<>();


    @Override
    public void misKlik(Point point, DiagramView diagramView) {

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
        for(ElementPainter ep:diagramView.getPainters()) {
           if(ep.getDiagramElement().isSelected())
               elements.add(ep.getDiagramElement());

        }
    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
        for(DiagramElement dg:elements){
            if(dg instanceof InterClass)
                ((InterClass)dg).setPostition(currPoint);
        }
    }
}
