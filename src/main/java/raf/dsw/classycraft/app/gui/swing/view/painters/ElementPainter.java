package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public abstract class ElementPainter {
    private DiagramElement diagramElement;
    private DiagramView diagramView;
    public ElementPainter(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }

    public ElementPainter(DiagramElement diagramElement, DiagramView diagramView) {
        this.diagramElement = diagramElement;
        this.diagramView = diagramView;
    }

    public abstract void draw(Graphics2D g, DiagramElement diagramElement);
    public abstract boolean elementAt(DiagramElement element, Point position, DiagramView diagramView);

    public DiagramElement getDiagramElement() {
        return diagramElement;
    }

    public void setDiagramElement(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }
}
