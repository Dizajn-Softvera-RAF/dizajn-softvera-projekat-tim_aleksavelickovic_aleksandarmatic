package raf.dsw.classycraft.app.gui.swing.tree;

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

    void remove(ClassyTreeItem node);



}
