package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DiagramSelectedAction extends AbstractClassyAction{
    public DiagramSelectedAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/tdiag.png"));
        putValue(NAME, "Add diagram");
        putValue(SHORT_DESCRIPTION, "Add a diagram to the current package");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((ClassyTreeImplementation) MainFrame.getInstance().getClassyTree()).setSelection(1);
    }
}
