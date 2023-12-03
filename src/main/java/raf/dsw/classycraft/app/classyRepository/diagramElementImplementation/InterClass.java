package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import java.awt.*;
import java.util.ArrayList;

public abstract class InterClass extends DiagramElement implements Pubsliher {
  //  private String naziv;
    private AccessModifier accessModifier;
    private Point  postition;
    private Dimension size;
    private ArrayList<Subscriber> subscribers;

    public InterClass(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        super(name, parent, color, stroke);
        this.accessModifier = accessModifier;
        this.postition = postition;
        this.size = size;
        subscribers = new ArrayList<>();
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        notifySubscribers(new InterCommunicationNotification("MODIFER_SET"));
    }

    public Point getPostition() {
        return postition;
    }

    public void setPostition(Point postition) {
        this.postition = postition;
        // treba i za sve notify u setu
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
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
