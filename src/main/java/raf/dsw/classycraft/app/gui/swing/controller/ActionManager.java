package raf.dsw.classycraft.app.gui.swing.controller;

import javax.swing.*;
import java.net.URL;

public class ActionManager extends AbstractClassyAction{

    @Override
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
