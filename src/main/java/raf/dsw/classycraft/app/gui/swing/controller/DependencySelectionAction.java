package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddConnection;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DependencySelectionAction extends AbstractClassyAction{
    public DependencySelectionAction() {
        putValue(SMALL_ICON, loadIcon("/images/Veza5.png"));
        putValue(NAME, "Dependency");
        putValue(SHORT_DESCRIPTION, "Selects Dependency connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getPackageView().getStateManager().getCurrState() instanceof AddConnection){
            ((AddConnection) MainFrame.getInstance().getPackageView().getStateManager().getCurrState()).setType("DEPENDENCY");
            MainFrame.getInstance().getConnectionSelectionFrame().dispose();
        }
    }
}
