package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public interface State {
    void misKlik(Point point,DiagramView diagramView);
    void misPusten();
    void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView);
}
