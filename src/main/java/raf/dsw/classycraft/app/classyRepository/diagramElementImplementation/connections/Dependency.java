package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import java.awt.*;

public class Dependency extends Connection {
    String type = "";
    public Dependency(String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        super(name, parent, color, stroke, from, to);
    }

    public void setType(String type) {
        this.type = type;
        //notifySubscribers(new InterCommunicationNotification("DEPENDENCY_TYPE_CHANGED"));
    }

    public String getType() {
        return type;
    }
}
