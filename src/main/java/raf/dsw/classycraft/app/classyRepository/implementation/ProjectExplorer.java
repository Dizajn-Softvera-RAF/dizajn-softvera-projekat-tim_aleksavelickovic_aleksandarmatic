package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;


import java.time.LocalDateTime;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer() {
        super("Project Exproler",null);
    }

    @Override
    public void addChild(ClassyNode child) {
        if(child!=null && child instanceof Project){
            Project project=(Project) child;

           if(!this.getChildren().contains(project)){
                this.getChildren().add(project);
            }
        }
        else {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now());
        }
    }


}
