package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuthorNameConfrimationAction extends AbstractClassyAction implements Pubsliher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public AuthorNameConfrimationAction() {
        putValue(NAME, "Confirm author name");
        putValue(SHORT_DESCRIPTION, "Confirm the new name of the author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selected = MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode();

        String newAuthor = MainFrame.getInstance().getAuthorFrame().getCaTextField().getText();//ovo krsi mvc

        MainFrame.getInstance().getAuthorFrame().setVisible(false);
        MainFrame.getInstance().getAuthorFrame().getCaTextField().setText("");

        if(newAuthor.isEmpty()) {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("AUTHOR_NAME_CANNOT_BE_EMPTY", MessageType.ERROR, LocalDateTime.now()));
            return;
        }

        ((Project)selected.getClassyNode()).setAuthorName(newAuthor);
        ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("RENAME_AUTHOR"+newAuthor, MessageType.NOTIFICATION, LocalDateTime.now()));
        System.out.println("new author:" + newAuthor);
        MainFrame.getInstance().getInfoLine().setVisible(true);
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
        for (Subscriber subscriber : subscribers)
            subscriber.update(notification);
    }


}
