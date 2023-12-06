package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddConnection;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AgregationSelectionAction extends AbstractClassyAction{
    public AgregationSelectionAction() {
        putValue(SMALL_ICON, loadIcon("/images/Veza2.png"));
        putValue(NAME, "Agregation");
        putValue(SHORT_DESCRIPTION, "Selects Agregation connectionj");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getPackageView().getStateManager().getCurrState() instanceof AddConnection){
            ((AddConnection) MainFrame.getInstance().getPackageView().getStateManager().getCurrState()).setType("AGREGATION");
            MainFrame.getInstance().getConnectionSelectionFrame().dispose();
        }
    }
}
