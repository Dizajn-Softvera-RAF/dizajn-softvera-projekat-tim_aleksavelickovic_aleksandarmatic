package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.classyRepository.Factory.NodeFactory;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.classyRepository.utils.Utils;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
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
    private DiagramElement diagramElement;
    private int nesto;


    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public int getNesto() {
        return nesto;
    }

    public void setNesto(int nesto) {
        this.nesto = nesto;
    }

    public DiagramElement getDiagramElement() {
        return diagramElement;
    }

    public void setDiagramElement(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
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

                ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("NODE_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now());

                return;

            }
            if (!(parent.getClassyNode() instanceof ClassyNodeComposite)) {

                return;
            }
            NodeFactory nf= Utils.getNodeFactory(parent.getClassyNode(),getSelection());
            nf.getNode((ClassyNodeComposite) parent.getClassyNode());
            ClassyNode child =nf.getNode((ClassyNodeComposite) parent.getClassyNode());

            parent.add(new ClassyTreeItem(child));

            ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);







        ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("ADDED", MessageType.NOTIFICATION, LocalDateTime.now());

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void addChild(ClassyTreeItem parent, ClassyTreeItem child) {
     //   if(parent.getClassyNode() instanceof Diagram){

         //   for(ClassyNode cn: ((ClassyNodeComposite)parent.getClassyNode()).getChildren()) {
           //     if (!parent.isNodeChild(new ClassyTreeItem(cn)))
             //       parent.add(new ClassyTreeItem(cn));
            //}
            if(parent.getClassyNode() instanceof Diagram)
                parent.add(child);
            else
                ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("ERROR DIAGRAM MUST BE SELECTED TO ADD ELEMENTS TO TREE", MessageType.ERROR, LocalDateTime.now());
           //ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("ADDED", MessageType.NOTIFICATION, LocalDateTime.now());

            treeView.expandPath(treeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(treeView);

        //}
    }

    @Override
    public void addChild(ClassyTreeItem grandparent, ClassyTreeItem parent, ClassyTreeItem child) {
        if(!grandparent.isNodeChild(parent))
            System.out.println("nije mu roditelj");
        System.out.println("broj dece "+grandparent.getChildCount());

        parent.add(child);
        //ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("ADDED", MessageType.NOTIFICATION, LocalDateTime.now());

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addChild(ClassyTreeItem grandparent, ClassyNode parent, ClassyTreeItem child) {
       // if(parent.equals((ClassyNode)grandparent.getFirstChild() ))
          //  System.out.println("jesuuu jednakii");

    }

    @Override
    public void remove(ClassyTreeItem node) {

        if(node.getClassyNode().getParent() == null) {

            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("NODE_CANNOT_BE_DELETED", MessageType.ERROR, LocalDateTime.now());
            return;
        }

        ((ClassyNodeComposite)node.getClassyNode().getParent()).removeChild(node.getClassyNode());

        node.removeFromParent();
        SwingUtilities.updateComponentTreeUI(treeView);

    }
}
