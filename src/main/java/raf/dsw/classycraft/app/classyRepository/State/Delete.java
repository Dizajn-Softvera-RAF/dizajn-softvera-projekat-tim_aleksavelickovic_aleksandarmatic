package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.util.ArrayList;

public class Delete implements State{

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        for (int i =0;i<diagramView.getPainters().size();i++) {
            ElementPainter ep = diagramView.getPainters().get(i);
            if (ep.elementAt(ep.getDiagramElement(), point, diagramView)) {
                diagramView.getPainters().remove(ep);
                diagramView.getDiagram().removeChild(ep.getDiagramElement());

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
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {


    }
}
