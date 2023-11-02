package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageOrProjectSelectionFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.Random;

public class ClassyTreeImplementation implements ClassyTree {
    private ClassyTreeView treeView;
    private DefaultTreeModel treeModel;
    private  int selection;
    LoggerFactory lf = new LoggerFactory();
    Logger l = lf.creatLogger("CONSOLE",ApplicationFramework.getInstance().getMessageGeneratorImplementation());
    Logger l2 = lf.creatLogger("FILE",ApplicationFramework.getInstance().getMessageGeneratorImplementation());

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    @Override
    public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
        ClassyTreeItem root = new ClassyTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new ClassyTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(ClassyTreeItem parent) {
        if(parent==null){
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("NODE_CANNOT_BE_DELETED", MessageType.ERROR, LocalDateTime.now()));
            l.Print();
            l2.Print();
            return;
        }
        if (!(parent.getClassyNode() instanceof ClassyNodeComposite)) {

            return;
        }
            System.out.println("nesto");
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

        if(node.getClassyNode().getParent() == null) {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("NODE_CANNOT_BE_DELETED", MessageType.ERROR, LocalDateTime.now()));
            l.Print();
            l2.Print();
            return;
        }

        ((ClassyNodeComposite)node.getClassyNode().getParent()).removeChild(node.getClassyNode());

        node.removeFromParent();
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
            if(selection==1)
                return   new Diagram("Diagram" + new Random().nextInt(100), parent);
            packageOrProjectSelectionFrame.view();
            if(selection==0)
                return   new Package("Package" + new Random().nextInt(100), parent);




        }

        return null;
    }





}
