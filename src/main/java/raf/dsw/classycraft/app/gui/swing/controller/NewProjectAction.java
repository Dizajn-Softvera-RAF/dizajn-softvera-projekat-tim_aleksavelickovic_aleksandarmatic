package raf.dsw.classycraft.app.gui.swing.controller;

//import lombok.Getter;
//import lombok.Setter;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.time.LocalDateTime;

public class NewProjectAction extends AbstractClassyAction{
    public NewProjectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode();
        if(selected==null) {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now());
        }
        else if(selected.getClassyNode() instanceof Package) {
            MainFrame.getInstance().getPackageOrProjectSelectionFrame().setVisible(true);
        }
        else {
            MainFrame.getInstance().getClassyTreeImplementation().addChild(selected);
        }


    }
}
