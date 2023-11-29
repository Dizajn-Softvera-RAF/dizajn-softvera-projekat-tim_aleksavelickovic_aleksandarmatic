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
        g.setStroke(interClass.getStroke());
        g.setColor(interClass.getColor());



     /* shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(interClass.getPostition().x,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x+interClass.getSize().width,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).lineTo(interClass.getPostition().x,interClass.getPostition().y+interClass.getSize().height);

        ((GeneralPath)shape).closePath();
        g.draw(shape);
        */
       System.out.println (interClass.getAccessModifier().name().length());

        if((g.getFont().getSize()*interClass.getName().length()+g.getFont().getSize()*interClass.getAccessModifier().name().length()+65)>(interClass.getSize().width))
            g.drawRect(interClass.getPostition().getLocation().x, interClass.getPostition().getLocation().y, interClass.getSize().width+((g.getFont().getSize()*interClass.getName().length()+g.getFont().getSize()*interClass.getAccessModifier().name().length()+65)-(interClass.getSize().width)),interClass.getSize().height);
        else
            g.drawRect(interClass.getPostition().getLocation().x, interClass.getPostition().getLocation().y, interClass.getSize().width,interClass.getSize().height);

        g.drawString(interClass.getAccessModifier().name(),interClass.getPostition().x+10,interClass.getPostition().y+10);
        g.drawString(interClass.getName(),interClass.getPostition().x+75,interClass.getPostition().y+10);

    }
    @Override
    public boolean elementAt(DiagramElement element, Point position) {
        return false;
    }
}
