package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.ExitAction;
import raf.dsw.classycraft.app.gui.swing.controller.NewProjectAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().actionManager.getExitAction());
        add(MainFrame.getInstance().actionManager.getNewProjectAction());


    }
}
