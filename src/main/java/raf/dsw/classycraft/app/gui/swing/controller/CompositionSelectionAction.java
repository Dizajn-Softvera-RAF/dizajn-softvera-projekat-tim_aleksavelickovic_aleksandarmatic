package raf.dsw.classycraft.app.gui.swing.controller;

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

    }
}
