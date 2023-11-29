package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class InterClassPainter extends ElementPainter{
    protected Shape shape;
    private DiagramElement diagramElement;
    public InterClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
        System.out.println("ulazi u konstruktor");
        // draw();
    }

    @Override
    public void draw(Graphics2D g,DiagramElement diagramElement) {
        if(diagramElement instanceof Class) {
            System.out.println("poziva se rectangle ");
            rectangle((Class) diagramElement,g);
        }
        else if(diagramElement instanceof Enum)
            rectangle((Enum) diagramElement,g);
        else if(diagramElement instanceof Interface)
            rectangle((Interface) diagramElement,g);
    }
    public void rectangle(InterClass interClass,Graphics2D g){//nije gotovo umesto interclass treba clas enum itd shape nioje dobar mozda je i okej
       // g.drawRect(interClass.getPostition().x,interClass.getPostition().y,250,150);

      shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(interClass.getPostition().x,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).closePath();
        g.draw(shape);

    }
    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
