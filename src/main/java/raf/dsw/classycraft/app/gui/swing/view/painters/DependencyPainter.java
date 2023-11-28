package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;

import java.awt.*;

public class DependencyPainter extends ConnectionPainter{
    public DependencyPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
