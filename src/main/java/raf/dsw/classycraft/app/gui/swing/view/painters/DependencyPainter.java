package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class DependencyPainter extends ConnectionPainter{
    public DependencyPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    public DependencyPainter(DiagramElement diagramElement, DiagramView diagramView) {
        super(diagramElement, diagramView);
    }

    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {
        g.setColor(Color.yellow);
        diagramElement.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g.setStroke(diagramElement.getStroke());
        super.draw(g, diagramElement);
    }

    @Override
    public boolean elementAt(DiagramElement element, Point position, DiagramView diagramView) {
        return false;
    }


}
