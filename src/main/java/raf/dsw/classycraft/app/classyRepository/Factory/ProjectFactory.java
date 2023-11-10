package raf.dsw.classycraft.app.classyRepository.Factory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{
    Project project;
    public ProjectFactory(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public ClassyNode createNode(ClassyNodeComposite parent) {
        if (parent.getChildren().size() > 0) {
            int i = 0;
            while(true) {
                i++;
                boolean exist = false;

                for(ClassyNode classyNode : parent.getChildren())
                    if (classyNode.getName().equals("Project (" + i + ")")) {
                        exist = true;
                        break;
                    }

                if(!exist)
                    return new Project("Project (" + i + ")", parent,"default Author", "/");
            }
        }

        return new Project("Project",parent, "default Author", "/");
    }
}
