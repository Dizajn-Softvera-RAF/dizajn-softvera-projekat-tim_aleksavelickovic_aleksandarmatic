package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.State.StateManager;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PackageView extends JPanel implements Subscriber {
    private StateManager stateManager;
    private final InfoLine infoLine;
    private final TabbedPane tabbedPane;
    private DiagramView diagramView = null;


    public PackageView(InfoLine infoLine,TabbedPane tabbedPane) {
        MainFrame.getInstance().getMgi().addSubscriber(this);
        this.infoLine=infoLine;
        this.tabbedPane=tabbedPane;
        stateManager = new StateManager();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(infoLine);
        add(tabbedPane);
    }
    public void view(Package opackage){

        this.tabbedPane.loadcpackage(opackage);
        this.infoLine.populate(tabbedPane.getproject().getName(),tabbedPane.getproject().getAuthorName());

    }
    public void clear(){
        this.infoLine.clear();
        this.tabbedPane.clear();
        this.tabbedPane.revalidate();
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    @Override
    public void update(Object notification) {


        if(notification instanceof Message){
            if (((Message) notification).getType().equals(MessageType.NOTIFICATION)){

                if(tabbedPane.getCpackage() != null&&(((Message) notification).getText().toString().equals("ADDED")|| ((Message) notification).getText().toString().equals("DELETED_DIAGRAM"))){
                   view(tabbedPane.getCpackage());
                }
                else if(((Message) notification).getText().toString().equals("CLEAR"))
                   clear();
                }
                else if (( ((Message) notification).getText().toString().contains("RENAME_PROJECT")))
                    infoLine.setupProjectName( ((Message) notification).getText().replace("RENAME_PROJECT", ""));
        }
            if(notification instanceof Package) {
            view((Package) notification);
            }
             if(notification instanceof InterCommunicationNotification){
                if(((InterCommunicationNotification) notification).getMessage().toString().equals("RENAME_AUTHOR")) {
                    infoLine.setupAuthor(((InterCommunicationNotification) notification).getContent().toString());
                }
                if ( ((InterCommunicationNotification) notification).getMessage().toString().equals("RENAME_PROJECT"))
                    infoLine.setupProjectName(((InterCommunicationNotification) notification).getContent().toString());
            }

    }

    public void startAddInterclass(){stateManager.setAddInterclass();
        System.out.println("State Interclasse");}
    public void startAddConnection(){stateManager.setAddConnection();
        System.out.println("State Connection");}
    public void startAddElement(){stateManager.setAddElement();
        System.out.println("State AddElement");}
    public void startDelete(){stateManager.setDelete();
        System.out.println("State Delete");}
    public void startSelected(){stateManager.setSelected();
        System.out.println("State Selected");}
    public void startEdit(){stateManager.setEdit();
        System.out.println("State Edit");}
    public void misKlik(Point point, DiagramView dw){
        stateManager.getCurrState().misKlik(point,dw);
        this.diagramView = dw;
    }
    public  void misPusten(){stateManager.getCurrState().misPusten();}
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView dw){stateManager.getCurrState().misPrevucen(initPoint,endPoint,dw);}
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView){
        stateManager.getCurrState().misPrevucen(points, diagramView);
    }
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        stateManager.getCurrState().misPusten(initPoint,endPoint,diagramView);
    }
    public void misPritisnut(Point initPoint, DiagramView diagramView){
        stateManager.getCurrState().misPritisnut(initPoint,diagramView);
    }
    public void misPovucen(Point currPoint,DiagramView diagramView){
        stateManager.getCurrState().misPovucen(currPoint,diagramView);
    }

    public DiagramView getDiagramView() {
        return diagramView;
    }
}
