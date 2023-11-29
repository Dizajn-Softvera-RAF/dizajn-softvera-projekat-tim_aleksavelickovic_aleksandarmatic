package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddInterclassAction extends AbstractClassyAction {
    public AddInterclassAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Class");
        putValue(SHORT_DESCRIPTION, "New Class");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startAddInterclass();
    }
}
