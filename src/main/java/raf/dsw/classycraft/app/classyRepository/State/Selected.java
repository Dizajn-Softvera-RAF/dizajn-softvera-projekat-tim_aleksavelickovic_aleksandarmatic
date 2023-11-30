package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;

public class Selected implements State{

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter || ep instanceof ConnectionPainter){
                if(ep.elementAt(ep.getDiagramElement(),point,diagramView)) {
                    System.out.println(ep.getDiagramElement().getName());
                    System.out.println("jeste tu");
                    ep.getDiagramElement().setSelected(true);
                }
            else {ep.getDiagramElement().setSelected(false);
                    System.out.println("Nije selektovan element");}
            }

        }
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPrevucen() {

    }
}
