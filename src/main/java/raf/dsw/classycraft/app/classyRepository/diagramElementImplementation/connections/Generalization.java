package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;

public class Generalization extends Connection {

    public Generalization(String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        super(name, parent, color, stroke, from, to);
    }
}
