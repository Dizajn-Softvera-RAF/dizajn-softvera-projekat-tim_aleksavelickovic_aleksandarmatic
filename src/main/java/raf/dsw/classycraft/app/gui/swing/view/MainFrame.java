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
    public InfoLine getInfoLine() {
        return infoLine;
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


        if(ApplicationFramework.getInstance().getMessageGeneratorImplementation().getSubscribers().isEmpty())
            System.out.println("prazana lista");
        for(Subscriber subscriber:ApplicationFramework.getInstance().getMessageGeneratorImplementation().getSubscribers())
            System.out.println(subscriber);
           // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            //add(infoLine);




            //treba da se popravi umesto ovog treba getSelectedNode
          //  infoLine.populate("ime1","Autor1");
          //  repaint();



           // InfoLine.clear();

        //update();

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
        MyTreeMouseListner myTreeMouseListner = new MyTreeMouseListner(projectExplorer);
        projectExplorer.addMouseListener(myTreeMouseListner);



        JScrollPane scroll=new JScrollPane(projectExplorer);
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,packageView);//bio desktop na kraju
        getContentPane().add(split,BorderLayout.CENTER);


        split.setDividerLocation(250);
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

    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            String string = "["+((Message) notification).getType()+"] ["+((Message) notification).getTimestamp()+"] "+((Message) notification).getText();
            if (((Message) notification).getType().equals(MessageType.ERROR)){
                JOptionPane.showMessageDialog(this,string,"ERROR",JOptionPane.ERROR_MESSAGE);
                System.out.println("hvata error");
            }
            if (((Message) notification).getType().equals(MessageType.NOTIFICATION)){
                //JOptionPane.showMessageDialog(this,string,"NOTIFICATION",JOptionPane.INFORMATION_MESSAGE);
                //  mnogo bitno treba dea se vrati u if ospod
                if(tabbedPane.getCpackage() == null)
                    System.out.println("Mora da je null");
                if(tabbedPane.getCpackage() != null&&(((Message) notification).getText().toString().equals("ADDED")|| ((Message) notification).getText().toString().equals("DELETED_DIAGRAM"))) {
                 //   System.out.println( tabbedPane.getCpackage().getName()+"abrakadabra");
                    packageView.view(tabbedPane.getCpackage());//ne treba ovaj pakage
                //  for(ClassyNode cn: tabbedPane.getCpackage().getChildren())
                  //    System.out.println( "imena u mainfrejmu su "+cn.getName());
                  //  tb.getChildren();
                 //   if(tabbedPane.getCpackage().getChildren().isEmpty())
                   //     System.out.println("Nema nista u package");//dodaju se novi diajgrami sa raz imenima sto zanaci da nije prazan pa je onda vrv  los package
                  //  if(tabbedPane.getDiagrams().isEmpty())
                     //   System.out.println("Prazan jeee");
                    //System.out.println(tabbedPane.getCpackage().getName()+tabbedPane.getCpackage().getChildren());//problem je u get pac od tabbpane
                  //  System.out.println("evo su imena");
                    //  for(DiagramView dv:tabbedPane.getDiagrams())
                      //    System.out.println(dv);
                }
                else if(((Message) notification).getText().toString().equals("CLEAR"))
                    packageView.clear();
            }
            if (((Message) notification).getType().equals(MessageType.WARNING)){
                JOptionPane.showMessageDialog(this,string,"NOTIFICATION",JOptionPane.WARNING_MESSAGE);
            }
        }
        if(notification instanceof Package)
          packageView.view((Package) notification) ;
    }
}


