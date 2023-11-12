package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

public class RemoveAction extends AbstractClassyAction{

    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/log-out.png"));
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Remove");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode();
        MainFrame.getInstance().getClassyTreeImplementation().remove(selected);
        if (selected.getClassyNode() instanceof Package || selected.getClassyNode() instanceof Project){
            if(selected.getClassyNode() instanceof Package)
                ((Package) selected.getClassyNode()).notifySubscribers(new InterCommunicationNotification("CLEAR",selected.getClassyNode(),"PACKAGE"));
            if(selected.getClassyNode() instanceof  Project){
              for(ClassyNode classyNode:  ( (Project)selected.getClassyNode()).getChildren()){
                  ((Package)classyNode).notifySubscribers(new InterCommunicationNotification("CLEAR",((Package) classyNode).findProject(),"Project"));
                  return;
              }

            }
        }

           // ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("CLEAR", MessageType.NOTIFICATION, LocalDateTime.now()));
        else if (selected.getClassyNode() instanceof Diagram) {

             ((Package) selected.getClassyNode().getParent()). notifySubscribers(new InterCommunicationNotification("DELETED",selected.getClassyNode(),selected.getClassyNode().getParent()));


            // ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("DELETED_DIAGRAM", MessageType.NOTIFICATION, LocalDateTime.now()));
        }
    }
}
