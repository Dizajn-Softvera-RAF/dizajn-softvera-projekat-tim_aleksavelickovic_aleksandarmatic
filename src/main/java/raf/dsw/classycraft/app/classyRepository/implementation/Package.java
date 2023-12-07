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
                    notifySubscribers(new InterCommunicationNotification("ADDED_PACKAGE",pack));
                }
            }
            if (child instanceof Diagram) {
                Diagram diagram = (Diagram) child;
                if (!this.getChildren().contains(diagram)) {
                    this.getChildren().add(diagram);
                    if(!(diagram.getParent()==null))
                        System.out.println("nije null parent");
                    notifySubscribers(new InterCommunicationNotification("ADDED_DIAGRAM",diagram,diagram.getParent()));
                }
            }
        }

        else {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now());
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

    }
    public void show(){
        notifySubscribers(new InterCommunicationNotification("SHOW",this));
    }
    public void projectAuthorRename(String message,ClassyNode classyNode,String content){
        if(this.findProject()!=classyNode)
            return;


        notifySubscribers(new InterCommunicationNotification(message,classyNode,content));

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
