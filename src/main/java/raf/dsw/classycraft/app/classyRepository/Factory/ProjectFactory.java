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
        String name = "Project";

        if(parent.getChildren().size()>0)
            name += " (" + parent.getChildren().size() + ")";
        return new Project(name,parent);
    }
}
