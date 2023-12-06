package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.MultiSelectionPainter;

import java.awt.*;
import java.util.ArrayList;

public class Selected implements State{
    private Point init;

    public Point getInit() {
        return init;
    }

    public void setInit(Point init) {
        this.init = init;
    }

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        for(ElementPainter ep:diagramView.getPainters()) {
            if(ep.elementAt(ep.getDiagramElement(),point,diagramView)) {
                    System.out.println(ep.getDiagramElement().getName());
                    System.out.println("jeste tu");
                    ep.getDiagramElement().setSelected(true);
                    System.out.println(ep.getDiagramElement().getSelected());

            }
            else {
                for(ElementPainter elementPainter:diagramView.getPainters()) {
                    if (elementPainter instanceof InterClassPainter ) {
                        elementPainter.getDiagramElement().setSelected(false);


                    }
                    else if( elementPainter instanceof ConnectionPainter){
                        elementPainter.getDiagramElement().setSelected(false);


                    }
                }
            }




        }for (ElementPainter ep: diagramView.getPainters()){
            if(ep.getDiagramElement().isSelected())ep.getDiagramElement().setColor(Color.red);
            else{
                if (ep.getDiagramElement() instanceof InterClass)ep.getDiagramElement().setColor(Color.blue);
                else if (ep.getDiagramElement() instanceof Connection) {ep.getDiagramElement().setColor(Color.black);}

            }
        }
        /*
        for(ElementPainter ep:diagramView.getPainters()){
            if(ep.getDiagramElement().isSelected()==true){
                ep .getDiagramElement().setSelected(false);
                ep.getDiagramElement().setColor(Color.blue);
                //deselekt samo mora da se pomeri mesto
            }
        }

         */
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        diagramView.getMultiSelectionPainters().removeAll(diagramView.getMultiSelectionPainters());

        for(ElementPainter ep: diagramView.getPainters()){
            /*if(ep.getDiagramElement() instanceof InterClass && ep.getDiagramElement().isSelected()==true ){
                ep.getDiagramElement().setColor(Color.red);
            }
            else
                ep.getDiagramElement().setColor(ep.getDiagramElement().getColor());

            if(ep.getDiagramElement()instanceof Connection && ep.getDiagramElement().isSelected()==true)
                ep.getDiagramElement().setColor(Color.red);
            else
                ep.getDiagramElement().setColor(ep.getDiagramElement().getColor());

             */

            if(ep.getDiagramElement().isSelected()==true){
                if(ep.getDiagramElement() instanceof InterClass){
                    ep.getDiagramElement().setColor(Color.red);
                }
                else if(ep.getDiagramElement() instanceof Connection){
                    ep.getDiagramElement().setColor(Color.red);

                }

            }
            else
                ep.getDiagramElement().setColor(ep.getDiagramElement().getColor());


        }



       //diagramView.repaint();
    }
    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {
       // if(initPoint==null)
            System.out.println("jeste null");
              this.setInit(initPoint);

    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
        diagramView.removeMultiSelectionPainter();
        MultiSelectionPainter multiSelectionPainter=new MultiSelectionPainter(this.getInit(),currPoint,diagramView);
        diagramView.getMultiSelectionPainters().add(multiSelectionPainter);
        diagramView.repaint();
    }
}
