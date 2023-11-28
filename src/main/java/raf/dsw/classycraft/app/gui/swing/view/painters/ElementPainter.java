package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;

import java.awt.*;

public abstract class ElementPainter {
    private DiagramElement diagramElement;

    public ElementPainter(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }

    public abstract void draw(Graphics2D g,DiagramElement diagramElement);
    public abstract boolean elementAt(DiagramElement element,Point position);

    public DiagramElement getDiagramElement() {
        return diagramElement;
    }

    public void setDiagramElement(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }
}
