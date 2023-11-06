package raf.dsw.classycraft.app.classyRepository.Factory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;

public class PackageFactory extends NodeFactory{
    Package aPackage;
    public PackageFactory(String name, ClassyNode parent) {
        super(name, parent);
    }



    @Override
    public ClassyNode createNode(ClassyNodeComposite parent) {
        String name = "Package";

        if(parent.getChildren().size()>0)
            name += " (" + parent.getChildren().size() + ")";
        return new Package(name,parent);
    }
}
