package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import java.awt.*;

public  class Agregation extends Connection {
    private String nameOfVariable="abcd";
    private String kardinalnost="1..*";
    public Agregation(String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
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
        //notifySubscribers(new InterCommunicationNotification("AGREGATION_CHANGED"));
    }

    public void setKardinalnost(String kardinalnost) {
        this.kardinalnost = kardinalnost;
        //notifySubscribers(new InterCommunicationNotification("AGREGATION_CHANGED"));
    }

}
