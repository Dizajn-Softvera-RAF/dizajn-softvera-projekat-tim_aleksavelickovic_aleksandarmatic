package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer() {
        ApplicationFramework.getInstance().getClassyRepositoryImplementation().setRoot(this);
    }
}
