package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import javax.swing.*;
import java.awt.*;


public class PackageView extends JPanel implements Subscriber {
    JLabel projekat;
    JLabel autor;
    DiagramView diagramView;
    Package paket;
    public PackageView(Package paket,JLabel projekat, JLabel autor){
        this.paket = paket;
        this.paket.addSubscriber(this);
        this.diagramView = new DiagramView();
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(projekat);
        this.add(autor);
        this.add(diagramView);
    }

    @Override
    public void update(Object notification) {

    }
}
