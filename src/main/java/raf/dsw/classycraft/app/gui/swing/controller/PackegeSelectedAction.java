package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PackegeSelectedAction extends AbstractClassyAction{


    public PackegeSelectedAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/tpakage.png"));
        putValue(NAME, "Add package");
        putValue(SHORT_DESCRIPTION, "Add a package to the current package");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ClassyTreeItem selected = MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode();

        ((ClassyTreeImplementation) MainFrame.getInstance().getClassyTreeImplementation()).setSelection(0);
        MainFrame.getInstance().getPackageOrProjectSelectionFrame().setVisible(false);


        MainFrame.getInstance().getClassyTreeImplementation().addChild(selected);
    }
}
