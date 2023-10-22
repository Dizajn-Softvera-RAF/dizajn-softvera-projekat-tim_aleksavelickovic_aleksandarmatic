package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter

public class MainFrame extends JFrame {
    private static MainFrame instance;

    private ActionManager actionManager ;

    private JMenuBar menu;
    private JToolBar toolBar;
    private MainFrame(){
       // MainFrame.getInstance().setVisible(true);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    private void initialize(){
        actionManager=new ActionManager();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        MyMenyBar menu = new MyMenyBar();
        setJMenuBar(menu);

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }
}
