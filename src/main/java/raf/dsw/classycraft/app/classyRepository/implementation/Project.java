package raf.dsw.classycraft.app.classyRepository.implementation;

import lombok.Getter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
@Getter
public class Project extends ClassyNodeComposite {
    public String getAutorName() {
        return autorName;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String autorName;
    private String name;
    private String path;
}
