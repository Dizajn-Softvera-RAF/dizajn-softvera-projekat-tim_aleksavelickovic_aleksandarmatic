package raf.dsw.classycraft.app.gui.swing.tree;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;

import javax.swing.tree.DefaultTreeCellRenderer;

public interface ClassyTree  {

    ClassyTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(ClassyTreeItem parent);
    ClassyTreeItem getSelectedNode();
    void addChild(ClassyTreeItem parent,ClassyTreeItem child);
    void addChild(ClassyTreeItem grandparent,ClassyTreeItem parent,ClassyTreeItem child);
    void addChild(ClassyTreeItem grandparent, ClassyNode parent,ClassyTreeItem child );
    void addChild(ClassyNode grandparent, ClassyNode parent, ClassyTreeItem child);
    void addChild(ClassyNode grandparent, ClassyNode parent, ClassyNode child);
    void remove(ClassyTreeItem node);
    void remove(ClassyNode node);




}
