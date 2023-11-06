package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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

    }
}
