package raf.dsw.classycraft.app.gui.swing.tree.model;


import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class ClassyTreeItem extends DefaultMutableTreeNode {
    ClassyNode classyNode;

    public ClassyTreeItem(ClassyNode classyNode) {

        this.classyNode = classyNode;
    }

    @Override
    public String toString() {
        return classyNode.getName();
    }
    public void setName(String name){
        this.classyNode.setName(name);
    }

    public ClassyNode getClassyNode() {
        return classyNode;
    }
}
