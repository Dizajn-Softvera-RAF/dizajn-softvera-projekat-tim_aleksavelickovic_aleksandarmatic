package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import javax.swing.*;

public class DiagramView extends JPanel implements Subscriber {
    private final Diagram diagram;
    private String name;
    public DiagramView(Diagram diagram){
        this.diagram = diagram;
        name = diagram.getName();
        this.diagram.addSubscriber(this);
        System.out.println("Ime u konstruktoiru"+name);
    }
    @Override
    public void update(Object notification) {

    }

    @Override
    public String getName() {
        return name;
    }
}
