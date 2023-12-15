package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class AddElement implements State{

    ArrayList<DiagramElement>elements=new ArrayList<>();
    Point lastPoint;


    @Override
    public void misKlik(Point point, DiagramView diagramView) {

    }



    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        elements.removeAll(elements);
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
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
      //  System.out.println("drag za novu kordiantu");
        for(DiagramElement dg:elements){

                if(dg instanceof InterClass) {
                  //  System.out.println("Prosla tacka " + lastPoint + " " + "Trenutna tacka " + currPoint);
                 Point newPoint= new Point((((InterClass) dg).getPostition().x + (currPoint.x - lastPoint.x)), (((InterClass) dg).getPostition().y + (currPoint.y - lastPoint.y)));
                 boolean exist=false;
                   for(ElementPainter dv: diagramView.getPainters()){
                       if(dv.getDiagramElement() instanceof InterClass){

                           Rectangle2D klasa=new Rectangle2D.Double(((InterClass) dv.getDiagramElement()).getPostition().x,((InterClass) dv.getDiagramElement()).getPostition().y,((InterClass) dv.getDiagramElement()).getSize().width,((InterClass) dv.getDiagramElement()).getSize().height);
                           Shape shape;
                           shape=new GeneralPath();
                           ((GeneralPath)shape).moveTo(newPoint.getX(),newPoint.getY());
                           ((GeneralPath)shape).lineTo(newPoint.x+((InterClass) dg).getSize().width, newPoint.y);
                           ((GeneralPath)shape).lineTo(newPoint.x+((InterClass) dg).getSize().width, newPoint.y+((InterClass) dg).getSize().height);
                           ((GeneralPath)shape).lineTo(newPoint.x, newPoint.y+((InterClass) dg).getSize().height);
                           ((GeneralPath)shape).closePath();


                           if(dv.getDiagramElement().equals(dg))
                               continue;

                           if(shape.intersects(klasa))
                               exist=true;




                           if(dv.elementAt(dv.getDiagramElement(),newPoint,diagramView)){
                               exist=true;
                               continue;
                           }

                           if(dv.elementAt(dv.getDiagramElement(),new Point(newPoint.x+((InterClass) dg).getSize().width, newPoint.y),diagramView)){
                               exist=true;
                               continue;
                           }

                           if(dv.elementAt(dv.getDiagramElement(),new Point(newPoint.x+((InterClass) dg).getSize().width, newPoint.y+((InterClass) dg).getSize().height),diagramView)){
                               exist=true;
                               continue;
                           }

                           if(dv.elementAt(dv.getDiagramElement(),new Point(newPoint.x, newPoint.y+((InterClass) dg).getSize().height),diagramView)){
                               exist=true;
                               continue;
                           }


                       }

                   }
                   if(exist==false)

                    ((InterClass) dg).setPostition(newPoint);
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
