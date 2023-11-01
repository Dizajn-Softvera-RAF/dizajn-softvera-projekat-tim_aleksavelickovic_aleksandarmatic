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
    public  abstract void addChild(ClassyNode child);
    public void removeChild(ClassyNode child){
        children.remove(child);
    }
    public ClassyNode getChildByName(String name) {
        for (ClassyNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }


}
