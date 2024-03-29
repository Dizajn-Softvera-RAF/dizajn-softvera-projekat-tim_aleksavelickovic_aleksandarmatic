package raf.dsw.classycraft.app.gui.swing.view;

//import lombok.Getter;
//import lombok.Setter;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNodeComposite;
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
import raf.dsw.classycraft.app.gui.swing.tree.controller.MyTreeMouseListner;

import javax.swing.*;
import javax.swing.border.Border;
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

    private PackageView packageView;
    private TabbedPane tabbedPane;
    private ConnectionSelectionFrame connectionSelectionFrame;
    private NewInterClassFrame newInterClassFrame;
    private EditFrame editFrame;


    private MainFrame(MessageGeneratorImplementation mgi){
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
    public InfoLine getInfoLine() {
        return infoLine;
    }

    public PackageView getPackageView() {
        return packageView;
    }

    private void initialize(){
        actionManager=new ActionManager();
        classyTreeImplementation=new ClassyTreeImplementation();
        infoLine=new InfoLine();
        authorFrame=new AuthorFrame();
        packageOrProjectSelectionFrame=new PackageOrProjectSelectionFrame();
        packegeSelectedAction=new PackegeSelectedAction();
        diagramSelectedAction=new DiagramSelectedAction();

        tabbedPane=new TabbedPane();
        packageView=new PackageView(infoLine,tabbedPane);
        connectionSelectionFrame = new ConnectionSelectionFrame();
        newInterClassFrame = new NewInterClassFrame();
        editFrame = null;


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth , screenHeight );
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        MyMenyBar menu = new MyMenyBar();
        setJMenuBar(menu);

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
        MyToolBar2 toolBar2 = new MyToolBar2();
        add(toolBar2,BorderLayout.EAST);

        JTree projectExplorer = classyTreeImplementation.generateTree(ApplicationFramework.getInstance().getClassyRepositoryImplementation().getProjectExplorer());
        MyTreeMouseListner myTreeMouseListner = new MyTreeMouseListner(projectExplorer);
        projectExplorer.addMouseListener(myTreeMouseListner);



        JScrollPane scroll=new JScrollPane(projectExplorer);
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,packageView);
        getContentPane().add(split,BorderLayout.CENTER);


        split.setDividerLocation(200);
        split.setOneTouchExpandable(true);

    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame(ApplicationFramework.getInstance().getMessageGeneratorImplementation());
            instance.initialize();
        }
        return instance;
    }

    public AuthorFrame getAuthorFrame() {
        return authorFrame;
    }



    public DiagramSelectedAction getDiagramSelectedAction() {
        return diagramSelectedAction;
    }

    public PackegeSelectedAction getPackegeSelectedAction() {
        return packegeSelectedAction;
    }

    public TabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public MessageGeneratorImplementation getMgi() {
        return mgi;
    }

    public ConnectionSelectionFrame getConnectionSelectionFrame() {
        return connectionSelectionFrame;
    }

    public NewInterClassFrame getNewInterClassFrame() {
        return newInterClassFrame;
    }

    public EditFrame getEditFrame() {
        return editFrame;
    }

    public void setEditFrame(EditFrame editFrame) {
        this.editFrame = editFrame;
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message) {
            String string = "[" + ((Message) notification).getType() + "] [" + ((Message) notification).getTimestamp() + "] " + ((Message) notification).getText();
            if (((Message) notification).getType().equals(MessageType.ERROR)) {
                JOptionPane.showMessageDialog(this, string, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            if (((Message) notification).getType().equals(MessageType.WARNING)){
                JOptionPane.showMessageDialog(this,string,"WARNING",JOptionPane.WARNING_MESSAGE);
            }
            if (((Message) notification).getType().equals(MessageType.ALERT)){
                JOptionPane.showMessageDialog(this,string,"ALERT",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}


