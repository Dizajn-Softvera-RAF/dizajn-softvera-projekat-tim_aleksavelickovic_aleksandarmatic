package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AgregationPainter extends ConnectionPainter{
    public AgregationPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    public AgregationPainter(DiagramElement diagramElement, DiagramView diagramView) {
        super(diagramElement, diagramView);
    }

    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {
       // g.setColor(Color.red);
        super.draw(g, diagramElement);
    }

    @Override
    public boolean elementAt(DiagramElement element, Point position, DiagramView diagramView) {
        return super.elementAt(element, position, diagramView);
    }
}
