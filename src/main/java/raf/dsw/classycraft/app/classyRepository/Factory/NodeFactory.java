package raf.dsw.classycraft.app.classyRepository.Factory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;

abstract public class NodeFactory extends ClassyNode {
    public NodeFactory(String name, ClassyNode parent) {
        super(name, parent);
    }
    abstract public ClassyNode createNode(ClassyNodeComposite parent);

    public ClassyNode getNode(ClassyNodeComposite parent){
        ClassyNode node=createNode(parent);
     //   node.setName(name);
       // node.setParent(parent);
        return node;
    }
}
