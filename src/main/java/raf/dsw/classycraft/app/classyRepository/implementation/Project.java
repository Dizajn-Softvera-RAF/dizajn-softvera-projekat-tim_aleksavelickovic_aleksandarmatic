package raf.dsw.classycraft.app.classyRepository.implementation;


import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;

public class Project extends ClassyNodeComposite {
    private String autorName;

    private String path;
    public String getAutorName() {
        return autorName;
    }



    public String getPath() {
        return path;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }



    public void setPath(String path) {
        this.path = path;
    }

    public Project(String name, ClassyNode parent, String autorName, String path) {
        super(name, parent);
        this.autorName = autorName;
        this.path = path;
    }
}
