package raf.dsw.classycraft.app.gui.swing.tree.view;

import raf.dsw.classycraft.app.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.gui.swing.tree.controller.ClassyTreeCellEditor;
import raf.dsw.classycraft.app.gui.swing.tree.controller.ClassyTreeSelectionListener;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTreeView extends JTree {
    public ClassyTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        ClassyRepositoryImplementation classyRepostitoryImplementation=new ClassyRepositoryImplementation();
        ClassyTreeItem classyTreeItem=new ClassyTreeItem(classyRepostitoryImplementation.getProjectExplorer());
        defaultTreeModel.setRoot(classyTreeItem);
        ClassyTreeCellRenderer classyTreeCellRenderer = new ClassyTreeCellRenderer();
        addTreeSelectionListener(new ClassyTreeSelectionListener());
        setCellEditor(new ClassyTreeCellEditor(this, classyTreeCellRenderer));
        setCellRenderer(classyTreeCellRenderer);
        setEditable(true);
    }

}
