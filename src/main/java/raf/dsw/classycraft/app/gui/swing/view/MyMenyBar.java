package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ExitAction;
import raf.dsw.classycraft.app.gui.swing.controller.NewProjectAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        //MainFrame.getInstance().setVisible(true);
       fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        editMenu.add(MainFrame.getInstance().getActionManager().getAboutUs());



        add(fileMenu);
        add(editMenu);
    }

}
