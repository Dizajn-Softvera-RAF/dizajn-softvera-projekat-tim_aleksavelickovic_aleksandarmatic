package raf.dsw.classycraft.app.gui.swing.controller;

import javafx.geometry.Pos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoAction extends AbstractClassyAction{

    public InfoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(NAME, "AboutUs");
        putValue(SHORT_DESCRIPTION, "AboutUs");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //novi prozor za AboutUs
        JFrame aboutUsProzor = new JFrame();
        aboutUsProzor.setSize(800, 800);
        aboutUsProzor.setAlwaysOnTop(true);
        aboutUsProzor.setTitle("AboutUs");
        aboutUsProzor.setLocationRelativeTo(null);
        aboutUsProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutUsProzor.setLayout(null);
        //aboutUsProzor.getContentPane().setLayout(new );

        //paneli
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.BLACK);
        panel4.setBackground(Color.DARK_GRAY);
        panel1.setBounds(0, 0, 400, 100);
        panel2.setBounds(400, 0, 400, 100);
        panel3.setBounds(0,100,400,700);
        panel4.setBounds(400,100,400,700);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        //Slike


        //labele sa imenima
        JLabel ime1 = new JLabel();

        JLabel slika2 = new JLabel(loadIcon("/images/Info3.jpg"));
        JLabel slika1 = new JLabel(loadIcon("/images/Info4.png"));
        JLabel ime2 = new JLabel();
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

}
