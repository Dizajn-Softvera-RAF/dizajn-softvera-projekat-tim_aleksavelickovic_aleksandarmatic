package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddConnection;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CompositionSelectionAction extends AbstractClassyAction{
    public CompositionSelectionAction() {
        putValue(SMALL_ICON, loadIcon("/images/Veza3.png"));
        putValue(NAME, "Composition");
        putValue(SHORT_DESCRIPTION, "Selects Composition connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getPackageView().getStateManager().getCurrState() instanceof AddConnection){
            ((AddConnection) MainFrame.getInstance().getPackageView().getStateManager().getCurrState()).setType("COMPOSITION");
            MainFrame.getInstance().getConnectionSelectionFrame().dispose();
        }
    }
}
