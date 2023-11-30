package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class MyToolBar2 extends JToolBar {
    public MyToolBar2(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddInterclassAction());
        add(MainFrame.getInstance().getActionManager().getAddConnectionAction());
        add(MainFrame.getInstance().getActionManager().getEditAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getSelectedAction());



    }
}
