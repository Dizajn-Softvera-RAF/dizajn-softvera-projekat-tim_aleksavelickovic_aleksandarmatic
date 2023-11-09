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
            LoggerFactory lf = new LoggerFactory();
            Logger l = lf.creatLogger("CONSOLE", ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            Logger l2 = lf.creatLogger("FILE", ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now()));
            l.Print();
            l2.Print();

        }
        else if(selected.getClassyNode() instanceof Package) {
            System.out.println("Izbor");
            MainFrame.getInstance().getPackageOrProjectSelectionFrame().setVisible(true);
        }
        else {

            MainFrame.getInstance().getClassyTreeImplementation().addChild(selected);
        }


    }
}
