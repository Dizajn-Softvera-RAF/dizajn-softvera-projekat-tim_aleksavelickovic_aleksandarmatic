package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;

public class Composition extends Connection {
    String nameOfVariable="";
    String kardinalnost="";
    public Composition(String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        super(name, parent, color, stroke, from, to);
    }

    public String getNameOfVariable() {
        return nameOfVariable;
    }

    public String getKardinalnost() {
        return kardinalnost;
    }

    public void setNameOfVariable(String nameOfVariable) {
        this.nameOfVariable = nameOfVariable;
    }

    public void setKardinalnost(String kardinalnost) {
        this.kardinalnost = kardinalnost;
    }
}
