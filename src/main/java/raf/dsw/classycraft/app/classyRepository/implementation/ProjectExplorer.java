package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;

import java.time.LocalDateTime;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer() {
        super("Project Exproler",null);

        ApplicationFramework.getInstance().getClassyRepositoryImplementation().setRoot(this);
    }

    @Override
    public void addChild(ClassyNode child) {
        if(child instanceof Package)
            super.addChild(child);
        else
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("Node_CANNOT_BE_ADDED",  MessageType.ERROR, LocalDateTime.now()));
    }

}
