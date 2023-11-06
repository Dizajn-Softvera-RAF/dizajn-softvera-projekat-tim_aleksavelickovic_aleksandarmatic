package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class PackageOrProjectSelectionFrame extends JFrame {
   private JButton bt1=new JButton("Package");
    private JButton bt2=new JButton("Diagram");
        public PackageOrProjectSelectionFrame(){




        setTitle("Select what you want to create ");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/6, screenHeight/5);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        JButton pButton = new JButton();
        JButton dButton = new JButton();
        pButton.setAction(MainFrame.getInstance().getActionManager().getPackegeSelectedAction());

        dButton.setAction(MainFrame.getInstance().getActionManager().getDiagramSelectedAction());
        add(pButton);
        add(dButton);


    }

    public JButton getBt1() {
        return bt1;
    }

    public JButton getBt2() {
        return bt2;
    }

}
