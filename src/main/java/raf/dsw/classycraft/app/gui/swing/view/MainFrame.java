package raf.dsw.classycraft.app.gui.swing.view;

//import lombok.Getter;
//import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.controller.DiagramSelectedAction;
import raf.dsw.classycraft.app.gui.swing.controller.PackegeSelectedAction;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;

import javax.swing.*;
import java.awt.*;
//@Getter
//@Setter

public class MainFrame extends JFrame implements Subscriber {
    private static MainFrame instance;

    private ActionManager actionManager ;
    private MessageGeneratorImplementation mgi;
    private JMenuBar menu;
    private JToolBar toolBar;
    private ClassyTreeImplementation classyTreeImplementation;
    private InfoLine infoLine;
    private AuthorFrame authorFrame;
    private  PackageOrProjectSelectionFrame packageOrProjectSelectionFrame;
    private ClassyTree classyTree;
    private DiagramSelectedAction diagramSelectedAction;
    private PackegeSelectedAction packegeSelectedAction;


    private MainFrame(MessageGeneratorImplementation mgi){
       // MainFrame.getInstance().setVisible(true);
        this.mgi = mgi;
        this.mgi.addSubscriber(this);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public ClassyTree getClassyTreeImplementation() {
        return classyTreeImplementation;
    }

    public PackageOrProjectSelectionFrame getPackageOrProjectSelectionFrame() {
        return packageOrProjectSelectionFrame;
    }

    private void initialize(){
        actionManager=new ActionManager();
        classyTreeImplementation=new ClassyTreeImplementation();
        infoLine=new InfoLine();
        authorFrame=new AuthorFrame();
        packageOrProjectSelectionFrame=new PackageOrProjectSelectionFrame();
        packegeSelectedAction=new PackegeSelectedAction();
        diagramSelectedAction=new DiagramSelectedAction();







           // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            //add(infoLine);




            //treba da se popravi umesto ovog treba getSelectedNode
            infoLine.populate("ime1","Autor1");
            repaint();



           // InfoLine.clear();



        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        MyMenyBar menu = new MyMenyBar();
        setJMenuBar(menu);

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);

        JTree projectExplorer = classyTreeImplementation.generateTree(ApplicationFramework.getInstance().getClassyRepositoryImplementation().getProjectExplorer());
        JPanel desktop = new JPanel();

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame(new MessageGeneratorImplementation());
            instance.initialize();
        }
        return instance;
    }

    public AuthorFrame getAuthorFrame() {
        return authorFrame;
    }

    public InfoLine getInfoLine() {
        return infoLine;
    }

    public DiagramSelectedAction getDiagramSelectedAction() {
        return diagramSelectedAction;
    }

    public PackegeSelectedAction getPackegeSelectedAction() {
        return packegeSelectedAction;
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            String string = "["+((Message) notification).getType()+"] ["+((Message) notification).getTimestamp()+"] "+((Message) notification).getText();
            if (((Message) notification).getType().toString().equals("ERROR")){
                JOptionPane.showMessageDialog(this,string,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
            if (((Message) notification).getType().toString().equals("NOTIFICATION")){
                JOptionPane.showMessageDialog(this,string,"NOTIFICATION",JOptionPane.INFORMATION_MESSAGE);
            }
            if (((Message) notification).getType().toString().equals("WARNING")){
                JOptionPane.showMessageDialog(this,string,"NOTIFICATION",JOptionPane.WARNING_MESSAGE);
            }else JOptionPane.showMessageDialog(this,"abc","greska",JOptionPane.WARNING_MESSAGE);
        }else JOptionPane.showMessageDialog(this,"abd","GRESKA",JOptionPane.ERROR_MESSAGE);
    }
}
