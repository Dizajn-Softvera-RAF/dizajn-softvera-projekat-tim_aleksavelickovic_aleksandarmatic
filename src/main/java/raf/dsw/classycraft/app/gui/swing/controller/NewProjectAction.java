package raf.dsw.classycraft.app.gui.swing.controller;

//import lombok.Getter;
//import lombok.Setter;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Console;

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
        if(selected.getClassyNode() instanceof Package) {
            System.out.println("Izbor");
            MainFrame.getInstance().getPackageOrProjectSelectionFrame().setVisible(true);
        }
        else {

            MainFrame.getInstance().getClassyTreeImplementation().addChild(selected);
        }


    }
}
