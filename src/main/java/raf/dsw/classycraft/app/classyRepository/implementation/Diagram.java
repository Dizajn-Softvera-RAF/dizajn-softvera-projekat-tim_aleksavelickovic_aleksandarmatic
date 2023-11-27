package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.util.ArrayList;
import java.util.concurrent.Flow;

public class Diagram extends ClassyNodeComposite implements Pubsliher {
    private ArrayList<Subscriber>subscribers;
    private String name;
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        this.name = name;
        subscribers = new ArrayList<>();
    }

    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
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
