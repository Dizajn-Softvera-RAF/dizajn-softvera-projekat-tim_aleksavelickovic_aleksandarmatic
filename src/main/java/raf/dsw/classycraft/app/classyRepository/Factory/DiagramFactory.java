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
        if (parent.getChildren().size() > 0) {
            int i = 0;
            while(true) {
                i++;
                boolean exist = false;

                for(ClassyNode cn : parent.getChildren())
                    if (cn.getName().equals("Diagram (" + i + ")")) {
                        exist = true;
                        break;
                    }

                if(!exist)
                    return new Diagram("Diagram (" + i + ")",parent);
            }
        }

        return new Diagram("Diagram",parent);
    }
}
