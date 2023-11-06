package raf.dsw.classycraft.app.classyRepository;

import raf.dsw.classycraft.app.classyRepository.Factory.NodeFactory;
import raf.dsw.classycraft.app.classyRepository.Factory.ProjectExplorerFactory;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.classyRepository.utils.Utils;

public class ClassyRepositoryImplementation implements ClassyRepository{
    private ProjectExplorer projectExplorer;
     private NodeFactory nodeFactory ;
     private ClassyNode parent=null;

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
      //  projectExplorer=new ProjectExplorer();

        NodeFactory nf= Utils.getNodeFactory(parent,0);
        projectExplorer= (ProjectExplorer) nf.getNode((ClassyNodeComposite) parent);


    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(ClassyNodeComposite parent, ClassyNode child) {

    }
}
