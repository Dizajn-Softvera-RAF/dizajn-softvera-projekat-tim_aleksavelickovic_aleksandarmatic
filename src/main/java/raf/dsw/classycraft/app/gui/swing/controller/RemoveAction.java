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

        if (selected.getClassyNode() instanceof Package || selected.getClassyNode() instanceof Project)
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("CLEAR", MessageType.NOTIFICATION, LocalDateTime.now());
        else if (selected.getClassyNode() instanceof Diagram)
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("DELETED_DIAGRAM"+selected.getClassyNode().getParent().getName()+" "+selected.getClassyNode(), MessageType.NOTIFICATION, LocalDateTime.now());


    }
}
