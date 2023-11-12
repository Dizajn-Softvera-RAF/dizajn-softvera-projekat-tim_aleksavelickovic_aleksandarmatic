package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;

import javax.swing.*;
import java.awt.*;


public class PackageView extends JPanel implements Subscriber {

    private final InfoLine infoLine;
    private final TabbedPane tabbedPane;


    public PackageView(InfoLine infoLine,TabbedPane tabbedPane) {
        MainFrame.getInstance().getMgi().addSubscriber(this);
        this.infoLine=infoLine;
        this.tabbedPane=tabbedPane;
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


}
