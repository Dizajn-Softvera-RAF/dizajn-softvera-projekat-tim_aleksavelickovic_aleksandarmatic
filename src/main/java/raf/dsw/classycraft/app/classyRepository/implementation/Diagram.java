package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

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

       // if(child instanceof Class)
           // return new Class()
      //  return new DiagramElement("DiagramElement",this);
        notifySubscribers(new InterCommunicationNotification("DIAGRAM_ELEMENT"));//treba el novi da se notifayuje ili samo repaint
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
