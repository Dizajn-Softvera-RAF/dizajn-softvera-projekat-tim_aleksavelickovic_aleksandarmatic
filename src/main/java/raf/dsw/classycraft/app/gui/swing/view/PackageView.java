package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
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


        if(notification instanceof InterCommunicationNotification){
            if(((InterCommunicationNotification) notification).getMessage().toString().equals("SHOW"))
                view((Package) ((InterCommunicationNotification) notification).getClassyNode());

            if(((InterCommunicationNotification) notification).getMessage().toString().equals("RENAME_AUTHOR")) {
                infoLine.setupAuthor(((InterCommunicationNotification) notification).getContent().toString());

            }
            if ( ((InterCommunicationNotification) notification).getMessage().toString().equals("RENAME_PROJECT"))
                infoLine.setupProjectName(((InterCommunicationNotification) notification).getContent().toString());
            if((((InterCommunicationNotification) notification).getMessage().toString().equals("DELETED")&&((InterCommunicationNotification) notification).getParent().equals(tabbedPane.getCpackage()) )||(((InterCommunicationNotification) notification).getMessage().toString().equals("ADDED")&&((InterCommunicationNotification) notification).getParent().equals(tabbedPane.getCpackage())))
                view(tabbedPane.getCpackage());
            if( ((InterCommunicationNotification) notification).getMessage().toString().equals("CLEAR")){
                if(((InterCommunicationNotification) notification).getContent().equals("PACKAGE")){


                    if(((InterCommunicationNotification) notification).getClassyNode().equals(tabbedPane.getCpackage())) {
                        System.out.println("Usto je u taj if");
                        clear();
                        System.out.println("Proso je klir");
                    }
                }
                System.out.println("Proso je svbe");
                if(((InterCommunicationNotification) notification).getContent().toString().equals("Project")) {
                    System.out.println("Poziva se u projectu nzm sto");
                    if ((((Project) ((InterCommunicationNotification) notification).getClassyNode()).getChildren().contains(tabbedPane.getCpackage()))) {

                        clear();
                    }
                }
            }
        }

        }


}
