package raf.dsw.classycraft.app.classyRepository;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public class ClassyRepositoryImplementation implements ClassyRepository{
    private ProjectExplorer root;
    @Override
    public ProjectExplorer getRoot() {
        return root;
    }
    public void setRoot(ProjectExplorer root) {
        this.root = root;
    }

}
