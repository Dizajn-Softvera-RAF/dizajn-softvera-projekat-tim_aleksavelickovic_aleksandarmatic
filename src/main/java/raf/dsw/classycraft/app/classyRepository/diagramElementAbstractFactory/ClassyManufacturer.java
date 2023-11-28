package raf.dsw.classycraft.app.classyRepository.diagramElementAbstractFactory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;

import java.awt.*;

public class ClassyManufacturer extends ClassyAbstractFactory{

    @Override
    public InterClass createInterClass(String type, String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        if(type.equals("CLASS"))
            return new Class(name, parent, color,stroke, accessModifier, postition, size);
        else if(type.equals("ENUM"))
            return new Enum(name, parent, color,stroke, accessModifier, postition, size);
        else if(type.equals("INTERFACE"))
            return new Interface(name, parent, color,stroke, accessModifier, postition, size);

        return null;
    }

    @Override
    public Connection createConnection(String type,String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        if(type.equals("AGREGATION"))
            return new Agregation(name, parent, color, stroke,  from,  to);
        else if (type.equals("COMPOSITION"))
            return new Composition(name, parent, color, stroke,  from,  to);
        else if(type.equals("DEPENDENCY"))
            return new Dependency(name, parent, color, stroke,  from,  to);
        else if(type.equals("GENERALIZATION"))
            return new Generalization(name, parent, color, stroke,  from,  to);

        return null;
    }
}
