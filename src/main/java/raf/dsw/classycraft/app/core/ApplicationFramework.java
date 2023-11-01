package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

public class ApplicationFramework {

    private static ApplicationFramework instance;

    private MessageGeneratorImplementation messageGeneratorImplementation;
    //buduca polja za model celog projekta

    private ApplicationFramework(){
        classyRepositoryImplementation=new ClassyRepositoryImplementation();
        messageGeneratorImplementation=new MessageGeneratorImplementation();
    }
    private ClassyRepositoryImplementation classyRepositoryImplementation;

    public static void setInstance(ApplicationFramework instance) {
        ApplicationFramework.instance = instance;
    }

    public ClassyRepositoryImplementation getClassyRepositoryImplementation() {
        return classyRepositoryImplementation;
    }

    public void setClassyRepositoryImplementation(ClassyRepositoryImplementation classyRepositoryImplementation) {
        this.classyRepositoryImplementation = classyRepositoryImplementation;
    }

    public MessageGeneratorImplementation getMessageGeneratorImplementation() {
        return messageGeneratorImplementation;
    }

    public void setMessageGeneratorImplementation(MessageGeneratorImplementation messageGeneratorImplementation) {
        this.messageGeneratorImplementation = messageGeneratorImplementation;
    }
    protected Gui gui;
    protected ClassyRepository classyRepository;

    public void initialize(){
        MainFrame.getInstance().setVisible(true);
        this.gui = gui;
        this.classyRepository = classyRepository;

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

}
