package raf.dsw.classycraft.app.gui.swing.controller;

import javafx.geometry.Pos;
import raf.dsw.classycraft.app.gui.swing.view.AboutUsFrame;

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
        putValue(SMALL_ICON, loadIcon("/images/info.png"));
        putValue(SHORT_DESCRIPTION, "AboutUs");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutUsFrame();
    }

}
