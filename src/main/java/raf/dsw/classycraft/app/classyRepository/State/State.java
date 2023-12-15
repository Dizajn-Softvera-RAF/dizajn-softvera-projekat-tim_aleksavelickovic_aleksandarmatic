package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public interface State {
    void misKlik(Point point,DiagramView diagramView);
    void misPusten(Point initPoint, Point endPoint, DiagramView diagramView);
    void misPritisnut(Point initPoint,DiagramView diagramView);
    void misPovucen(Point currPoint,int i,DiagramView diagramView);

}
