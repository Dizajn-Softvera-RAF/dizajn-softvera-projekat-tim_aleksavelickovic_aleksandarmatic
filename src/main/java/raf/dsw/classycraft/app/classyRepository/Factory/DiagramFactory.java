package raf.dsw.classycraft.app.classyRepository.Factory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;

public class DiagramFactory extends NodeFactory{
    Diagram diagram;
    public DiagramFactory(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public ClassyNode createNode(ClassyNodeComposite parent) {
        String name = "Diagram";
        ClassyTreeItem classyTreeItem;

        if(parent.getChildren().size()>0)
            name += " (" + parent.getChildren().size() + ")";
        return new Diagram(name,parent);
    }
}
