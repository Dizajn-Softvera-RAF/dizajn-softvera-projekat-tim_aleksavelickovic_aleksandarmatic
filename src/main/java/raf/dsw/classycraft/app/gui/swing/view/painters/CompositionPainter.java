package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class CompositionPainter extends ConnectionPainter{
    public CompositionPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    public CompositionPainter(DiagramElement diagramElement, DiagramView diagramView) {
        super(diagramElement, diagramView);
    }

    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {

        super.draw(g, diagramElement);
    }

    @Override
    public boolean elementAt(DiagramElement element, Point position, DiagramView diagramView) {
        return super.elementAt(element, position, diagramView);
    }
}
