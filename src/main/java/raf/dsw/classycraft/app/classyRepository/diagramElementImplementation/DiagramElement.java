package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

import java.awt.*;

public abstract class DiagramElement extends ClassyNode {
    protected Color color;
    protected Stroke stroke;

    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
    }

    public DiagramElement(String name, ClassyNode parent, Color color, Stroke stroke) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
    }
}
