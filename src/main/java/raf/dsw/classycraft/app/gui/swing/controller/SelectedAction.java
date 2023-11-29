package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectedAction extends AbstractClassyAction{
    public SelectedAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Select Tool");
        putValue(SHORT_DESCRIPTION, "Select TOOL");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startSelected();
    }
}
