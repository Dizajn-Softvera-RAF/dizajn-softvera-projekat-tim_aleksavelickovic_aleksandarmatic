package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageOrProjectSelectionFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ClassyTreeImplementation implements ClassyTree {
    private ClassyTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
        ClassyTreeItem root = new ClassyTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new ClassyTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(ClassyTreeItem parent) {

        if (!(parent.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyNode child = createChild(parent.getClassyNode());
        //  System.out.println("napravio je dete");
        parent.add(new ClassyTreeItem(child));
        //  System.out.println("dodao je dete u perenta");
        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void remove(ClassyTreeItem node) {
        if(node.getClassyNode() instanceof ClassyNode ){
            node.remove(getSelectedNode());

        }
        else{
            ClassyNodeComposite classyNodeComposite=(ClassyNodeComposite) node.getClassyNode();
            if(classyNodeComposite.getChildren().isEmpty()){
                node.remove(getSelectedNode());
            }
            else{
                node.removeAllChildren();
            }
        }
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private ClassyNode createChild(ClassyNode parent) {

        if (parent instanceof ProjectExplorer) {

            return new Project("Project" + new Random().nextInt(100), parent);
        }
        if (parent instanceof Project) {

            return new Package("Package" + new Random().nextInt(100), parent);
        }
        if (parent instanceof Package) {

            PackageOrProjectSelectionFrame packageOrProjectSelectionFrame = new PackageOrProjectSelectionFrame();
            packageOrProjectSelectionFrame.view();
            packageOrProjectSelectionFrame.getBt1().addActionListener(e ->{
               create(parent);
             });

            packageOrProjectSelectionFrame.getBt2().addActionListener(e ->{
                create1(parent);
            });


        }

        return null;
    }
    public Package create(ClassyNode parent){
        return   new Package("Package" + new Random().nextInt(100), parent);
    }
    public Diagram create1(ClassyNode parent){
        return   new Diagram("Diagram" + new Random().nextInt(100), parent);
    }




}
