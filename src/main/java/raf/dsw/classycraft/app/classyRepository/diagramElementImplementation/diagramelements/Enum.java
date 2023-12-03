package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.awt.*;
import java.util.ArrayList;

public  class Enum extends InterClass implements Pubsliher {
    private ArrayList<String> types;
    private ArrayList<Subscriber> subscribers;

    public Enum(String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {

        super(name, parent, color, stroke, accessModifier, postition, size);
        types=new ArrayList<>();
        subscribers = new ArrayList<>();

    }

    public ArrayList<String> getTypes() {
        return types;
    }
    public void addTypes(String type){
        types.add(type);

    }
    public void removeTypes(String type){
        types.remove(type);
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
