package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class ConnectionSelectionFrame extends JFrame {

    public ConnectionSelectionFrame(){
        setTitle("Select connection type");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4, screenHeight/4);
        setLocationRelativeTo(MainFrame.getInstance().getPackageView());
        setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        JButton aButton = new JButton();
        JButton cButton = new JButton();
        JButton dButton = new JButton();
        JButton gButton = new JButton();
        aButton.setAction(MainFrame.getInstance().getActionManager().getAgregationSelectionAction());
        cButton.setAction(MainFrame.getInstance().getActionManager().getCompositionSelectionAction());
        dButton.setAction(MainFrame.getInstance().getActionManager().getDependencySelectionAction());
        gButton.setAction(MainFrame.getInstance().getActionManager().getGeneralizationSelectionAction());
        add(aButton);
        add(cButton);
        add(dButton);
        add(gButton);
    }
}
