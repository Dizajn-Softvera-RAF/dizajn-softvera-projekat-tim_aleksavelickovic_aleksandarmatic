package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;
import java.util.ArrayList;

public  class Interface extends InterClass {
    private ArrayList<ClassContents> methods;


    public Interface(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke, accessModifier, postition, size);

    }

    public ArrayList<ClassContents> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<ClassContents> methods) {
        this.methods = methods;
    }

}
