package raf.dsw.classycraft.app.classyRepository.State;

import javafx.scene.shape.StrokeType;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;

public class AddInterclass implements State{
    private int i = 0;
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        System.out.println("misKlik");

        System.out.println(diagramView.getDiagram().getName());
       Class klasa = (Class) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass("CLASS","klasa"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(150,100));
        i++;
        diagramView.getDiagram().addChild(klasa);

        System.out.println(klasa.getName());
        InterClassPainter icp = new InterClassPainter(klasa);
        diagramView.getPainters().add(icp);



    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPrevucen() {

    }
}