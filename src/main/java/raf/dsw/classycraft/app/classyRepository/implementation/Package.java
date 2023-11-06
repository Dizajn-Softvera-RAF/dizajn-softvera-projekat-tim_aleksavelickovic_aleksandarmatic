package raf.dsw.classycraft.app.classyRepository.implementation;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;

import java.time.LocalDateTime;

public class Package extends ClassyNodeComposite {


    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if(child!=null && (child instanceof Package|| child instanceof Diagram)) {
            if (child instanceof Package) {
                Package pack = (Package) child;
                if (!this.getChildren().contains(pack)) {
                    this.getChildren().add(pack);
                }
            }
            if (child instanceof Diagram) {
                Diagram diagram = (Diagram) child;
                if (!this.getChildren().contains(diagram)) {
                    this.getChildren().add(diagram);
                }
            }
        }
        //  super.addChild(child);
        else {
            LoggerFactory lf = new LoggerFactory();
            Logger l = lf.creatLogger("CONSOLE", ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            Logger l2 = lf.creatLogger("FILE",ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(new Message("Node_CANNOT_BE_ADDED", MessageType.ERROR, LocalDateTime.now()));
            l.Print();
            l2.Print();
        }
    }
}
