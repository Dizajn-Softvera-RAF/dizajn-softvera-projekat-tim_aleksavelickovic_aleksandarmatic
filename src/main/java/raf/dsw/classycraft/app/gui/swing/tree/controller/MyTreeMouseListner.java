package raf.dsw.classycraft.app.gui.swing.tree.controller;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

                System.out.println(node);
                if (node instanceof ClassyTreeItem){
                    ClassyTreeItem treeItem = (ClassyTreeItem) node;
                    ClassyNode cvor = treeItem.getClassyNode();
                    if(cvor instanceof Package){
                        System.out.println("Dupli klik");
                        Package paket = (Package) cvor;
                        //JLabel projekat = MainFrame.getInstance().getInfoLine().getProjectLabel();
                       // JLabel autor = MainFrame.getInstance().getInfoLine().getAuthorLabel();
                      //  PackageView pw = new PackageView(paket,projekat,autor);
                     //
                    // ovo gledaj   PackageView pw=new PackageView(MainFrame.getInstance().getInfoLine(),MainFrame.getInstance().getTabbedPane());
                     //   MainFrame.getInstance().getDesktop().add(pw);

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
