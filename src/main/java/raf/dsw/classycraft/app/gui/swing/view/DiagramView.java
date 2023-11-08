package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import javax.swing.*;

public class DiagramView extends JTabbedPane implements Subscriber {
    Diagram diagram;
    public DiagramView(){
        JTabbedPane dw = new JTabbedPane();
    }
    public DiagramView(Diagram diagram){
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
    }
    @Override
    public void update(Object notification) {

    }
}
