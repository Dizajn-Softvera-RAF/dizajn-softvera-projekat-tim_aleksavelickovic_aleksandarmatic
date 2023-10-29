package raf.dsw.classycraft.app.classyRepository.composite;

public abstract class ClassyNode {
    private String name;
   private   ClassyNode parent;

    public ClassyNode(String name, ClassyNode parent) {
        this.name = name;
        this.parent = parent;
    }
}
