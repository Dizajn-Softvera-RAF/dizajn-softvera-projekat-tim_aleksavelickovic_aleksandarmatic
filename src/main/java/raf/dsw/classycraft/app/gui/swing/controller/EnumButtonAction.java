package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.State.AddInterclass;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EnumButtonAction  extends AbstractClassyAction{
    public EnumButtonAction() {
        putValue(SMALL_ICON, loadIcon("/images/enum.png"));
        putValue(NAME, "Enum");
        putValue(SHORT_DESCRIPTION, "New enum");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AddInterclass klasa = (AddInterclass) MainFrame.getInstance().getPackageView().getStateManager().getCurrState();
        klasa.setType("ENUM");
        MainFrame.getInstance().getNewInterClassFrame().dispose();
    }
}
