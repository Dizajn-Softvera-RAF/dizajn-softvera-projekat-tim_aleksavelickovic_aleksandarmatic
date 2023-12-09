package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractClassyAction{
    public MoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Move_tool.png"));
        putValue(NAME, "Move Tool");
        putValue(SHORT_DESCRIPTION, "Move Tool");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startMove();

    }
}
