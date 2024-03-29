package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Method;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.time.LocalDateTime;
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

        if(child!=null && (child instanceof Class|| child instanceof Enum || child instanceof Interface || child instanceof Agregation || child instanceof Dependency|| child instanceof Generalization || child instanceof Composition)) {
            if (child instanceof Class) {
                Class clas = (Class) child;
                if (!this.getChildren().contains(clas)) {
                    this.getChildren().add(clas);
                }
            }
            if (child instanceof Enum) {
                Enum enumm = (Enum) child;
                if (!this.getChildren().contains(enumm)) {
                    this.getChildren().add(enumm);
                }
            }
            if (child instanceof Interface) {
                Interface interfacee= (Interface) child;
                if (!this.getChildren().contains(interfacee)) {
                    this.getChildren().add(interfacee);
                }
            }
            if (child instanceof Agregation) {
                Agregation agregation= (Agregation) child;
                if (!this.getChildren().contains(agregation)) {
                    this.getChildren().add(agregation);
                }
            }
            if (child instanceof Dependency) {
                Dependency dependency= (Dependency) child;
                if (!this.getChildren().contains(dependency)) {
                    this.getChildren().add(dependency);
                }
            }
            if (child instanceof Composition) {
                Composition composition= (Composition) child;
                if (!this.getChildren().contains(composition)) {
                    this.getChildren().add(composition);
                }
            }
            if (child instanceof Generalization) {
                Generalization generalization= (Generalization) child;
                if (!this.getChildren().contains(generalization)) {
                    this.getChildren().add(generalization);
                }

            }


            notifySubscribers(new InterCommunicationNotification("DIAGRAM_ELEMENT"));//treba el novi da se notifayuje ili samo repaint
        }

        else {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now());
        }

    }

    @Override
    public void removeChild(ClassyNode child) {
        super.removeChild(child);
        notifySubscribers(new InterCommunicationNotification("CHILD_REMOVED"));
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
