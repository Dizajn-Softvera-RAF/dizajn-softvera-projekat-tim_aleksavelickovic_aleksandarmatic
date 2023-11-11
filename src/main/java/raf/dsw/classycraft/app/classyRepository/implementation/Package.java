package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Package extends ClassyNodeComposite implements Pubsliher {
    private ArrayList<Subscriber>subscribers;

    public Package(String name, ClassyNode parent) {
        super(name, parent);
        subscribers = new ArrayList<>();
        subscribers.add(MainFrame.getInstance().getPackageView());
    }

    @Override
    public void addChild(ClassyNode child) {
        if(child!=null && (child instanceof Package|| child instanceof Diagram)) {
            if (child instanceof Package) {
                Package pack = (Package) child;
                if (!this.getChildren().contains(pack)) {
                    this.getChildren().add(pack);
                }
            }
            if (child instanceof Diagram) {
                Diagram diagram = (Diagram) child;
                if (!this.getChildren().contains(diagram)) {
                    this.getChildren().add(diagram);
                    System.out.println(diagram.getName()+"u paaket");
                    System.out.println(getName()+getChildren());
                    System.out.println("imena diagrama");
                    for(ClassyNode c:getChildren())
                        System.out.println(c.getName());
                    System.out.println("gotova imena");
                }
            }
        }

        else {
            LoggerFactory lf = new LoggerFactory();
            Logger l = lf.creatLogger("CONSOLE", ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            Logger l2 = lf.creatLogger("FILE",ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now()));
            l.Print();
            l2.Print();
        }
    }
    public ClassyNodeComposite findProject() {
        ClassyNodeComposite project = (ClassyNodeComposite) this.getParent();
        while (!(project instanceof Project)) {
            project = (ClassyNodeComposite) project.getParent();
        }
        return project;
    }
    public void projectRename(String message,ClassyNode classyNode,String content){
        if(this.findProject()!=classyNode)
             return;
        notifySubscribers(new InterCommunicationNotification(message,classyNode,content));
        System.out.println("Notifajao je ime projekta"+content);

    }
    public void show(){
        notifySubscribers(new InterCommunicationNotification("SHOW",this));
    }
    public void projectAuthorRename(String message,ClassyNode classyNode,String content){
        if(this.findProject()!=classyNode)
            return;

        System.out.println("content u packegu je "+content);
        notifySubscribers(new InterCommunicationNotification(message,classyNode,content));//prepravi ovo
        System.out.println("notifay se notifayao");

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
