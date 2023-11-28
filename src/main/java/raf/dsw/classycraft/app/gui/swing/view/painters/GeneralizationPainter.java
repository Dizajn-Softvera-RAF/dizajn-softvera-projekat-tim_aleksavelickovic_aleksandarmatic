package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;

import java.awt.*;

public class GeneralizationPainter extends ConnectionPainter{
    public GeneralizationPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {
        super.draw(g, diagramElement);
    }

    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
