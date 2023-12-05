package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddConnectionAction extends AbstractClassyAction{
    public AddConnectionAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Connection");
        putValue(SHORT_DESCRIPTION, "New Connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startAddConnection();
        MainFrame.getInstance().getConnectionSelectionFrame().setVisible(true);
    }
}
