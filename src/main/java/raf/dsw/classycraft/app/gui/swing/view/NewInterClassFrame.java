package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class NewInterClassFrame extends JFrame{
    public NewInterClassFrame(){init();}

    private void init() {
        setTitle("Select connection type");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4, screenHeight/4);
        setLocationRelativeTo(MainFrame.getInstance().getPackageView());
        setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        JButton classButton = new JButton();
        JButton interfejsButton = new JButton();
        JButton enumButton = new JButton();
        classButton.setAction(MainFrame.getInstance().getActionManager().getClassButtonAction());
        interfejsButton.setAction(MainFrame.getInstance().getActionManager().getInterfaceButtonAction());
        enumButton.setAction(MainFrame.getInstance().getActionManager().getEnumButtonAction());
        add(classButton);
        add(interfejsButton);
        add(enumButton);

    }
}
