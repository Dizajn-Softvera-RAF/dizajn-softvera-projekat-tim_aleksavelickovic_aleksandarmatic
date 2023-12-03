package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;
import java.util.ArrayList;

public  class Class extends InterClass {
    private ArrayList<ClassContents> classContents;


    public Class(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke, accessModifier, postition, size);
        classContents = new ArrayList<>();

    }


    public ArrayList<ClassContents> getClassContents() {
        return classContents;
    }

    public void setClassContents(ArrayList<ClassContents> classContents) {
        this.classContents = classContents;
    }
}
