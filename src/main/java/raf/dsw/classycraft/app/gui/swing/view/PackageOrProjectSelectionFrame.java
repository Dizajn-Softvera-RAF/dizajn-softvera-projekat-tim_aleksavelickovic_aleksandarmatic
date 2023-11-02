package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class PackageOrProjectSelectionFrame extends JFrame {
   private JButton bt1=new JButton("Package");
    private JButton bt2=new JButton("Diagram");
    public void view(){
        JFrame packageOrProject=new JFrame();
        packageOrProject.setSize(300, 150);
        packageOrProject.setAlwaysOnTop(true);
        packageOrProject.setTitle("Izbor");
        packageOrProject.setLocationRelativeTo(null);
        packageOrProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        packageOrProject.setLayout(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBounds(0, 0, 300, 150);
      //  JButton bt1=new JButton("Package");
       // JButton bt2=new JButton("Diagram");
        bt1.setHorizontalAlignment(JLabel.LEFT);
        bt2.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(bt1);
        panel2.add(bt2);

        panel2.setBounds(0,0,300,100);
        JLabel jLabel=new JLabel("Choose what you want to create");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setHorizontalTextPosition(JLabel.CENTER);
        panel3.add(jLabel);
        panel3.setBounds(0,100,300,50);



        packageOrProject.add(panel2);
        packageOrProject.add(panel3);

        packageOrProject.setVisible(true);

    }

    public JButton getBt1() {
        return bt1;
    }

    public JButton getBt2() {
        return bt2;
    }
}
