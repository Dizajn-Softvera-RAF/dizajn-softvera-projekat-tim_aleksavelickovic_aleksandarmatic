package raf.dsw.classycraft.app.classyRepository.Factory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public class ProjectExplorerFactory extends NodeFactory{
    ProjectExplorer projectExplorer;

    public ProjectExplorerFactory(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public ClassyNode createNode(ClassyNodeComposite parent) {

        return new ProjectExplorer();
    }
}
