package raf.dsw.classycraft.app.classyRepository.diagramElementAbstractFactory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;

import java.awt.*;

public abstract class ClassyAbstractFactory {
    public abstract InterClass createInterClass(String type,String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size);
    public abstract Connection createConnection(String type,String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to);
}
