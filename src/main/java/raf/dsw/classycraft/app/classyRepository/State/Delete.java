package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.EditFrame;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Delete implements State{

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        ArrayList<ConnectionPainter> delete=new ArrayList<>();
        Rectangle2D prav = new Rectangle2D.Double(point.getX()-5,point.getY()-5,10,10);
        for (int i =0;i<diagramView.getPainters().size();i++) {
            ElementPainter ep = diagramView.getPainters().get(i);
            if (ep.getDiagramElement() instanceof Connection){
                Line2D line2D = new Line2D.Double(((ConnectionPainter) ep).getStartPoint().getX(),((ConnectionPainter) ep).getStartPoint().getY(),((ConnectionPainter) ep).getEndPoint().getX(),((ConnectionPainter) ep).getEndPoint().getY());
                if (prav.intersectsLine(line2D)){
                    MainFrame.getInstance().getClassyTreeImplementation().remove((((ConnectionPainter)ep).getDiagramElement()));
                    diagramView.getPainters().remove(ep);
                    diagramView.getDiagram().removeChild(ep.getDiagramElement());
                }
            }
            if (ep.elementAt(ep.getDiagramElement(), point, diagramView)) {
                diagramView.getPainters().remove(ep);
                diagramView.getDiagram().removeChild(ep.getDiagramElement());
                MainFrame.getInstance().getClassyTreeImplementation().remove(((ep).getDiagramElement()));
                for(ElementPainter el:diagramView.getPainters()){
                    if(el.getDiagramElement() instanceof Connection){
                        if(((Connection)el.getDiagramElement()).getTo().equals(ep.getDiagramElement())||((Connection)el.getDiagramElement()).getFrom().equals(ep.getDiagramElement()))
                           delete.add((ConnectionPainter) el);
                    }
                }
            }
            for(ConnectionPainter c:delete){
                MainFrame.getInstance().getClassyTreeImplementation().remove(c.getDiagramElement());
                diagramView.getPainters().remove(c);
                diagramView.getDiagram().removeChild(c.getDiagramElement());
            }
        }
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


}
