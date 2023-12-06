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

public  class  Interface extends InterClass implements Pubsliher {
    private ArrayList<Method> methods;
    private ArrayList<Subscriber> subscribers;

    public Interface(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke, accessModifier, postition, size);

        methods=new ArrayList<>();
        subscribers = new ArrayList<>();

    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    public void addMethods(Method method){
        methods.add(method);
        notifySubscribers(new InterCommunicationNotification("METHOD_ADDED"));
    }
    public void removeMethods(Method method){
        methods.remove(method);
        notifySubscribers(new InterCommunicationNotification("METHOD_REMOVED"));
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(Subscriber subscriber:subscribers)
            subscriber.update(notification);
    }

}
