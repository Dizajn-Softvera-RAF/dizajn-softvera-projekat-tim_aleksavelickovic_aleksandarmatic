package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction ;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class AboutUsFrame  {
    public AboutUsFrame(){init();}
    public void init() {

        JFrame aboutUsProzor = new JFrame();
        aboutUsProzor.setSize(800, 800);
        aboutUsProzor.setAlwaysOnTop(true);
        aboutUsProzor.setTitle("AboutUs");
        aboutUsProzor.setLocationRelativeTo(null);
        aboutUsProzor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aboutUsProzor.setLayout(null);


        //paneli
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.setBounds(0, 0, 400, 100);
        panel2.setBounds(400, 0, 400, 100);
        panel3.setBounds(0, 100, 400, 700);
        panel4.setBounds(400, 100, 400, 700);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());



        //labele sa imenima
        JLabel ime1 = new JLabel();
        JLabel ime2 = new JLabel();

        JLabel slika2 = new JLabel(loadIcon("/images/Info3.jpg"));
        JLabel slika1 = new JLabel(loadIcon("/images/Info4.png"));

        ime1.setText("Aleksa Veličković");
        ime2.setText("Aleksandar Miodragović");

        ime1.setFont(new Font("Info", Font.BOLD, 28));
        ime2.setFont(new Font("Info", Font.BOLD, 28));

        ime1.setVerticalAlignment(JLabel.CENTER);
        ime2.setVerticalAlignment(JLabel.CENTER);
        ime1.setHorizontalAlignment(JLabel.CENTER);
        ime2.setHorizontalAlignment(JLabel.CENTER);
        ime1.setVerticalTextPosition(JLabel.TOP);
        ime2.setVerticalTextPosition(JLabel.TOP);

        panel1.add(ime1);
        panel2.add(ime2);
        panel3.add(slika1);
        panel4.add(slika2);

        aboutUsProzor.add(panel1);
        aboutUsProzor.add(panel2);
        aboutUsProzor.add(panel3);
        aboutUsProzor.add(panel4);
        aboutUsProzor.setVisible(true);


    }
    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }


}
