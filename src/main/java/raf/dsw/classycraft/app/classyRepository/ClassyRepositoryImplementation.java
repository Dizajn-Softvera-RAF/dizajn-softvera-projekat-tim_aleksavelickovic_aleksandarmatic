package raf.dsw.classycraft.app.classyRepository;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public class ClassyRepositoryImplementation implements ClassyRepository{
    ProjectExplorer projectExplorer=new ProjectExplorer();
    @Override
    public ClassyNode getRoot() {
        return projectExplorer;
    }
}
