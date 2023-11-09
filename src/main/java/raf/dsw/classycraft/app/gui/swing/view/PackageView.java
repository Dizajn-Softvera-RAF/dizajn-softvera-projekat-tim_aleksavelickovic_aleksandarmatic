package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import javax.swing.*;
import java.awt.*;


public class PackageView extends JPanel implements Subscriber {
   // JLabel projekat;
   // JLabel autor;
   // DiagramView diagramView;
   // Package paket;
    private final InfoLine infoLine;
    private final TabbedPane tabbedPane;

    public PackageView(InfoLine infoLine,TabbedPane tabbedPane) {

        this.infoLine=infoLine;
        this.tabbedPane=tabbedPane;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(infoLine);
        add(tabbedPane);
    }
    public void view(Package opackage){

        this.tabbedPane.loadcpackage(opackage);
        this.infoLine.populate(tabbedPane.getproject().getName(),tabbedPane.getproject().getAuthorName());
        repaint();
    }
    public void clear(){
        this.infoLine.clear();
        this.tabbedPane.clear();
        this.tabbedPane.revalidate();
    }


    @Override
    public void update(Object notification) {

    }
}
