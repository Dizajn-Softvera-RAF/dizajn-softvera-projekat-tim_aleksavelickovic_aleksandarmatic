package raf.dsw.classycraft.app.core;


import raf.dsw.classycraft.app.classyRepository.ClassyRepository;
import raf.dsw.classycraft.app.classyRepository.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.core.Loggeri.Logger;
import raf.dsw.classycraft.app.core.Loggeri.LoggerFactory;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

public class ApplicationFramework {

    private static ApplicationFramework instance;

    private MessageGeneratorImplementation messageGeneratorImplementation;
    //buduca polja za model celog projekta
    private Logger loger1;
    private  Logger loger2;
    private LoggerFactory lf;
    private ApplicationFramework(){
        classyRepositoryImplementation=new ClassyRepositoryImplementation();
        messageGeneratorImplementation=new MessageGeneratorImplementation();
        lf = new LoggerFactory();
        loger1 = lf.creatLogger("FILE",messageGeneratorImplementation);
        loger2 = lf.creatLogger("CONSOLE",messageGeneratorImplementation);
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
    public void log(Message message){
        loger1.Print(message);
        loger2.Print(message);
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
