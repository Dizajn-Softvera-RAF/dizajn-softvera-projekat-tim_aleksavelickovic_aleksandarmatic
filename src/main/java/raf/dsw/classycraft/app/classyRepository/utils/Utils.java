package raf.dsw.classycraft.app.classyRepository.utils;

import raf.dsw.classycraft.app.classyRepository.Factory.*;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;

public class Utils {
    public static NodeFactory getNodeFactory(ClassyNode parent,int selection) {
       if(parent==null)
           return new ProjectExplorerFactory("ProjectExproler",null);

        if (parent instanceof ProjectExplorer) {

            return new ProjectFactory("Project", parent);
        }
        if (parent instanceof Project) {

            return new PackageFactory("Package", parent);
        }
        if (parent instanceof Package) {


            if (selection == 1)
                return new DiagramFactory("Diagram", parent);

            if (selection == 0)
                return new PackageFactory("Package", parent);

        }
        return null;
    }
}
