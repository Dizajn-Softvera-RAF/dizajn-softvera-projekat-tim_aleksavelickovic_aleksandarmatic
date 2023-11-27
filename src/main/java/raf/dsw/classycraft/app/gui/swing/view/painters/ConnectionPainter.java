package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;

import java.awt.*;

public class ConnectionPainter extends ElementPainter{
    public ConnectionPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
