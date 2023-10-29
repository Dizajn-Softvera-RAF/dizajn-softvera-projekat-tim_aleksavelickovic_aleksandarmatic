package raf.dsw.classycraft.app.classyRepository.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassyNodeComposite extends ClassyNode{
    private ArrayList<ClassyNode> children;

    public ClassyNodeComposite(String name, ClassyNode parent) {
        super(name, parent);
    }



    public ArrayList<ClassyNode> getChildren() {
        return children;
    }
    public void addChild(ClassyNode child){
        children.add(child);
    }
    public void removeChild(ClassyNode child){
        children.remove(child);
    }

}
