package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;

public  class Interface extends InterClass {
    private Method method;


    public Interface(String name, ClassyNode parent, Color color, Stroke stroke, String naziv, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke, naziv, accessModifier, postition, size);
    }
}
