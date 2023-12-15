package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;

public class ZoomIn implements State, Pubsliher {
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        diagramView.setZoom(diagramView.getZoom()*1.1);
      //  diagramView.repaint();

    }



    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {

    }
    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {

    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Object notification) {

    }
}
