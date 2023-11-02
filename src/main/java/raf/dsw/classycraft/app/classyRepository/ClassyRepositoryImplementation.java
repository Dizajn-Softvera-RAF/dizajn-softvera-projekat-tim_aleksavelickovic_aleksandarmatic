package raf.dsw.classycraft.app.classyRepository;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public class ClassyRepositoryImplementation implements ClassyRepository{
    private ProjectExplorer projectExplorer;

    //@Override
   // public ProjectExplorer getRoot() {
       // return root;
  //  }
   // public void setRoot(ProjectExplorer root) {
     //   this.root = root;
   // }


    public void setProjectExplorer(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
    }

    public ClassyRepositoryImplementation() {
        projectExplorer=new ProjectExplorer();

    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(ClassyNodeComposite parent, ClassyNode child) {

    }
}
