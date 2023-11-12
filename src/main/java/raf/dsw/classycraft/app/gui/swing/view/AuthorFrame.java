package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class AuthorFrame extends JFrame {
    JTextField textField;
    public AuthorFrame() {
        setTitle("Change project author");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/8, screenHeight/6);

        setLayout(new BorderLayout(20, 20));

        JLabel label = new JLabel("New author name:");
        label.setHorizontalAlignment(SwingConstants.CENTER);



        JButton caButton = new JButton();
        caButton.setAction(MainFrame.getInstance().getActionManager().getAuthorNameConfrimationAction());
        textField = new JTextField();
        add(label, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);
        add(caButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public JTextField getCaTextField() {
        return textField;
    }

}
