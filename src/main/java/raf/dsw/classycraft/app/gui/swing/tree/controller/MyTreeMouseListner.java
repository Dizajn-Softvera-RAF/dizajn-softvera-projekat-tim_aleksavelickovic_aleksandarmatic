package raf.dsw.classycraft.app.gui.swing.tree.controller;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

public class MyTreeMouseListner implements MouseListener {
    private JTree jTree;

    public MyTreeMouseListner(JTree tree){
        this.jTree = tree;
        jTree.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()==2){
            TreePath path = jTree.getSelectionPath();

            if (path != null){
                Object node = path.getLastPathComponent();
                if (node instanceof ClassyTreeItem){
                    ClassyTreeItem treeItem = (ClassyTreeItem) node;
                    ClassyNode cvor = treeItem.getClassyNode();
                    if(cvor instanceof Package){
                        Package paket = (Package) cvor;
                        paket.show();
                        //ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(paket);

                        System.out.println("NApravi paket i notifyuje");


                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
