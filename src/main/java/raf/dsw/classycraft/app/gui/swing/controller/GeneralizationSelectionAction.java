package raf.dsw.classycraft.app.gui.swing.controller;

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

    }
}
