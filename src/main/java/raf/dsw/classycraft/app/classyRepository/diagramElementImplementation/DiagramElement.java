package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import java.awt.*;
import java.util.ArrayList;

public abstract class DiagramElement extends ClassyNode implements Pubsliher {
    protected Color color;
    protected Stroke stroke;
    protected boolean selected;
    private ArrayList<Subscriber> subscribers;

    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
    }

    public DiagramElement(String name, ClassyNode parent, Color color, Stroke stroke) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
        this.selected = false;
        subscribers = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifySubscribers(new InterCommunicationNotification("COLOR_CHANGED"));
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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


    public boolean getSelected() {
        return this.selected;
    }
}
