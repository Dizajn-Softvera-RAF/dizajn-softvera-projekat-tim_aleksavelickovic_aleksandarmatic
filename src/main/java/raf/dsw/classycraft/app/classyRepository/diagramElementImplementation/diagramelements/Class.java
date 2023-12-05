package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import java.awt.*;
import java.util.ArrayList;

public  class Class extends InterClass implements Pubsliher {
    private ArrayList<ClassContents> classContents;
    private ArrayList<Subscriber> subscribers;


    public Class(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke, accessModifier, postition, size);
        classContents = new ArrayList<>();
        subscribers = new ArrayList<>();

    }


    public ArrayList<ClassContents> getClassContents() {
        return classContents;
    }

    public void setClassContents(ArrayList<ClassContents> classContents) {
        this.classContents = classContents;
        notifySubscribers(new InterCommunicationNotification("RETURN_TYPE_CHANGED"));
    }

    public void addClassContents(ClassContents classContent){
        classContents.add(classContent);
        notifySubscribers(new InterCommunicationNotification("CLASSCONTENT_ADDED"));
    }
    public void removeClassContents(ClassContents classContent){
        classContents.remove(classContent);
        notifySubscribers(new InterCommunicationNotification("CLASSCONTENT_REMOVED"));
    }
}
