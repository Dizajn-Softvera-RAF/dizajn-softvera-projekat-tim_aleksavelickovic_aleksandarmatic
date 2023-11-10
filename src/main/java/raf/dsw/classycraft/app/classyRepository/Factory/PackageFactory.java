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


        if(parent.getChildren().size()>0) {
            int i = 0;
            while(true) {
                i++;
                boolean exist = false;

                for(ClassyNode classyNode : parent.getChildren())
                    if (classyNode.getName().equals("Package (" + i + ")")) {

                        exist = true;
                        break;
                    }

                if(!exist)
                    return new Package("Package (" + i + ")",parent);
            }
        }
        return new Package("Package",parent);
    }
}
