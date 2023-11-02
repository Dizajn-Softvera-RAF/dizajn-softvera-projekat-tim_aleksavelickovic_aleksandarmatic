package raf.dsw.classycraft.app.classyRepository;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public interface ClassyRepository {
    //ClassyNode getRoot();
    ProjectExplorer getProjectExplorer();
    void addChild(ClassyNodeComposite parent, ClassyNode child);

}
