package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

import java.awt.*;

public abstract class Connection extends DiagramElement{
    private InterClass from;
    private InterClass to;


    public Connection(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Connection(String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        super(name, parent, color, stroke);
        this.from = from;
        this.to = to;
    }

    public InterClass getFrom() {
        return from;
    }

    public void setFrom(InterClass from) {
        this.from = from;
    }

    public InterClass getTo() {
        return to;
    }

    public void setTo(InterClass to) {
        this.to = to;
    }
}
