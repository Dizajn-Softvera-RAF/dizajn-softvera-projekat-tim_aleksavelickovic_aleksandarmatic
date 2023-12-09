package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddInterclass;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class InterfaceButtonAction extends AbstractClassyAction{
    public InterfaceButtonAction() {
        putValue(SMALL_ICON, loadIcon("/images/interface.png"));
        putValue(NAME, "Interface");
        putValue(SHORT_DESCRIPTION, "New interface");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AddInterclass klasa = (AddInterclass) MainFrame.getInstance().getPackageView().getStateManager().getCurrState();
        klasa.setType("INTERFACE");
        MainFrame.getInstance().getNewInterClassFrame().dispose();
    }
}
