package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.util.ArrayList;

public class Edit implements State{
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                if(ep.elementAt(ep.getDiagramElement(),point,diagramView)) {
                    new EditFrame(ep.getDiagramElement());
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
}
