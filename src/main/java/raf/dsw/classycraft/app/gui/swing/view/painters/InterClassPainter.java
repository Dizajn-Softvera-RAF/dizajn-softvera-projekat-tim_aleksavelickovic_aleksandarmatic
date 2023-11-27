package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class InterClassPainter extends ElementPainter{

    public InterClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void draw(Graphics g) {

    }
    public void rectangle(DiagramElement diagramElement){//nije gotovo umesto interclass treba clas enum itd shape nioje dobar
        InterClass interClass = (InterClass) diagramElement;

       GeneralPath shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(interClass.getPostition().x,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).closePath();
    }
    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
