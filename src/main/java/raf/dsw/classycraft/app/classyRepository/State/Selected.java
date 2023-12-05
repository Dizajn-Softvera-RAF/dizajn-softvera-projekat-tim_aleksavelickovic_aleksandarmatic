package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.util.ArrayList;

public class Selected implements State{

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
