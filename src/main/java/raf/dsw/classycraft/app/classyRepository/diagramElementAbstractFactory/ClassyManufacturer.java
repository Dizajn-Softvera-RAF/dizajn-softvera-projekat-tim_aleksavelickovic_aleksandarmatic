package raf.dsw.classycraft.app.classyRepository.diagramElementAbstractFactory;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;

import java.awt.*;

public class ClassyManufacturer extends ClassyAbstractFactory{

    @Override
    public InterClass createInterClass(String type, String name, ClassyNode parent, Color color, Stroke stroke, AccessModifier accessModifier, Point postition, Dimension size) {
        if(type.equals("CLASS")) {
         //   int t=0;
           // for(ClassyNode cn: ((ClassyNodeComposite) parent).getChildren()){ ovo je bolji nacin ali ne radi trenutno
             //   if(cn instanceof Class)
               //     t++;
            //}


                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Class (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new  Class("Class (" + i + ")", parent, color, stroke, accessModifier, postition, size);
                }

        }
        else if(type.equals("ENUM")) {

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Enum (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Enum("Enum (" + i + ")", parent, color, stroke, accessModifier, postition, size);
                }

        }
        else if(type.equals("INTERFACE")) {

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Interface (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Interface("Interface (" + i + ")", parent, color, stroke, accessModifier, postition, size);
                }

        }
        return null ;
    }

    @Override
    public Connection createConnection(String type,String name, ClassyNode parent, Color color, Stroke stroke, InterClass from, InterClass to) {
        if(type.equals("AGREGATION")){

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Agregation (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Agregation("Agregation (" + i + ")", parent, color, stroke, from, to);
                }

        }
        else if (type.equals("COMPOSITION")) {

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Composition (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Composition("Composition (" + i + ")", parent, color, stroke, from, to);
                }

        }
        else if(type.equals("DEPENDENCY")) {
           // int t=0;
            //for(ClassyNode cn: ((ClassyNodeComposite) parent).getChildren()){

             //   if(cn instanceof  Dependency)
               //     t++;
           // }

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Dependency (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Dependency("Dependency (" + i + ")", parent, color, stroke, from, to);
                }

        }
        else if(type.equals("GENERALIZATION")) {

                int i = 0;
                while(true) {
                    i++;
                    boolean exist = false;

                    for(ClassyNode classyNode : ((ClassyNodeComposite)parent).getChildren())
                        if (classyNode.getName().equals("Generalization (" + i + ")")) {

                            exist = true;
                            break;
                        }
                    if(!exist)
                        return new Generalization("Generalization (" + i + ")", parent, color, stroke, from, to);
                }
          
        }

        return null;
    }
}
