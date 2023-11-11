package raf.dsw.classycraft.app.classyRepository.implementation;


import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;

import java.time.LocalDateTime;

public class Project extends ClassyNodeComposite {
    private String authorName;

    private String path;
    public String getAuthorName() {
        return authorName;
    }



    public String getPath() {
        return path;
    }

    public void setAuthorName(String autorName) {

        this.authorName = autorName;
        System.out.println("U set autr neame je "+autorName);
        for(ClassyNode cn: this.getChildren())
            ((Package) cn).projectAuthorRename("RENAME_AUTHOR",this,autorName);

    }



    public void setPath(String path) {
        this.path = path;
    }

    public Project(String name, ClassyNode parent, String autorName, String path) {
        super(name, parent);
        this.authorName = autorName;
        this.path = path;
    }

    public Project(String name ,ClassyNode parent) {
        super(name, parent);

    }

    @Override
    public void setName(String name) {
        super.setName(name);
        for(ClassyNode cn:this.getChildren())
            ((Package)cn).projectRename("RENAME_PROJECT",this,name);
    }

    @Override
    public void addChild(ClassyNode child) {
       if(child!=null && child instanceof Package){

           Package pack=(Package) child;
           if(!this.getChildren().contains(pack)){
               this.getChildren().add(pack);

           }
       }


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
