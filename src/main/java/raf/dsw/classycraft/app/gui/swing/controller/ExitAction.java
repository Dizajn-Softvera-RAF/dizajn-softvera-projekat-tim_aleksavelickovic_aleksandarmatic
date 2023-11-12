package raf.dsw.classycraft.app.gui.swing.controller;

//import lombok.Getter;
//import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
//@Getter
//@Setter
public class ExitAction extends AbstractClassyAction {

    public ExitAction(){
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/log-out.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");//ne prikazuje se
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
