package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddConnection;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GeneralizationSelectionAction extends AbstractClassyAction{
    public GeneralizationSelectionAction() {
        putValue(SMALL_ICON, loadIcon("/images/Veza4.png"));
        putValue(NAME, "Generalization");
        putValue(SHORT_DESCRIPTION, "Selects Generalization connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getPackageView().getStateManager().getCurrState() instanceof AddConnection){
            ((AddConnection) MainFrame.getInstance().getPackageView().getStateManager().getCurrState()).setType("GENERALIZATION");
            MainFrame.getInstance().getConnectionSelectionFrame().dispose();
        }
    }
}
