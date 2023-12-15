package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddInterclass;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ClassButtonAction extends AbstractClassyAction{
    public ClassButtonAction() {
        putValue(SMALL_ICON, loadIcon("/images/class.png"));
        putValue(NAME, "Class");
        putValue(SHORT_DESCRIPTION, "New class");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AddInterclass klasa = (AddInterclass)MainFrame.getInstance().getPackageView().getStateManager().getCurrState();
        klasa.setType("CLASS");
        MainFrame.getInstance().getNewInterClassFrame().dispose();
    }
}
