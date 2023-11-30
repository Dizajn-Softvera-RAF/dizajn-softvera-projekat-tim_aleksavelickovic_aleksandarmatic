package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.AgregationPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;

public class AddConnection implements State{
    private int i = 0;
    @Override
    public void misKlik(Point point, DiagramView diagramView) {}

    @Override
    public void misPusten() {}

    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {
        InterClass from = null;
        InterClass to= null;
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                if(ep.elementAt(ep.getDiagramElement(),initPoint,diagramView)) {
                     System.out.println("pocetne koridante klse"+initPoint);
                     from = (InterClass) ep.getDiagramElement();
                }
                if(ep.elementAt(ep.getDiagramElement(),endPoint,diagramView)) {
                    System.out.println("zavrsne  koridante klase"+endPoint);
                     to = (InterClass) ep.getDiagramElement();
                }}}
        if(from!= null && to!=null) {
            Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("AGREGATION", "AGREGATION" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
            i++;
            ConnectionPainter connectionPainter = new AgregationPainter(veza);
            connectionPainter.setStartPoint(initPoint);
            connectionPainter.setEndPoint(endPoint);

            diagramView.getDiagram().addChild(veza);
            diagramView.getPainters().add(connectionPainter);

        }

    }


}
