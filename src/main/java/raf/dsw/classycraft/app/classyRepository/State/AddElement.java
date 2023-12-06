package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import java.awt.*;
import java.util.ArrayList;

public class AddElement implements State{

    ArrayList<DiagramElement>elements=new ArrayList<>();
    Point lastPoint;


    @Override
    public void misKlik(Point point, DiagramView diagramView) {

    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        elements.removeAll(elements);
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
        this.setLastPoint(initPoint);
    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
      //  System.out.println("drag za novu kordiantu");
        for(DiagramElement dg:elements){

                if(dg instanceof InterClass) {
                  //  System.out.println("Prosla tacka " + lastPoint + " " + "Trenutna tacka " + currPoint);
                    ((InterClass) dg).setPostition(new Point((((InterClass) dg).getPostition().x + (currPoint.x - lastPoint.x)), (((InterClass) dg).getPostition().y + (currPoint.y - lastPoint.y))));
                }

        }
        this.setLastPoint(currPoint);
    }

    public Point getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }
}
