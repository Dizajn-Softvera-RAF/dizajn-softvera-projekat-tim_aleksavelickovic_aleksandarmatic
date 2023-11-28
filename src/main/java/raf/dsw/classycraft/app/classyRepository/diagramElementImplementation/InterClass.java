package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

import java.awt.*;

public abstract class InterClass extends DiagramElement{
  //  private String naziv;
    private AccessModifier accessModifier;
    private Point  postition;
    private Dimension size;

    public InterClass(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke);
        this.accessModifier = accessModifier;
        this.postition = postition;
        this.size = size;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public Point getPostition() {
        return postition;
    }

    public void setPostition(Point postition) {
        this.postition = postition;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }
}
