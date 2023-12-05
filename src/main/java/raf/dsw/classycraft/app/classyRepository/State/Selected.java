package raf.dsw.classycraft.app.classyRepository.State;

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
            }
            else {
                for(ElementPainter elementPainter:diagramView.getPainters()){
                    if (elementPainter instanceof InterClassPainter || elementPainter instanceof ConnectionPainter)elementPainter.getDiagramElement().setSelected(false);
                }
            }


        }
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        diagramView.removeMultiSelectionPainter();
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
