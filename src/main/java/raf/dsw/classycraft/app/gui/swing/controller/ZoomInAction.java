package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomInAction extends AbstractClassyAction {
    public ZoomInAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/ZoomIn.png"));
        putValue(NAME, "ZoomIn");
        putValue(SHORT_DESCRIPTION, "ZoomIn");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startZoomIn();
    }
}
