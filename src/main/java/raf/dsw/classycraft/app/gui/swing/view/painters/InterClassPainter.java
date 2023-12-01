package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Interface;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class InterClassPainter extends ElementPainter{
    protected Shape shape;
    private DiagramElement diagramElement;
    private int fontSize;

    public InterClassPainter(DiagramElement diagramElement) {
        super(diagramElement);
        this.diagramElement=diagramElement;
     //   System.out.println("ulazi u konstruktor");
        // draw();
    }

    @Override
    public void draw(Graphics2D g,DiagramElement diagramElement) {
        if(diagramElement instanceof Class) {
        //    System.out.println("poziva se rectangle ");
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
     //  System.out.println (interClass.getAccessModifier().name().length());
        fontSize=g.getFont().getSize();
        if((g.getFont().getSize()*interClass.getName().length()+g.getFont().getSize()*interClass.getAccessModifier().name().length()+65)>(interClass.getSize().width)) {
            interClass.setSize(new Dimension(interClass.getSize().width + ((g.getFont().getSize() * interClass.getName().length() + g.getFont().getSize() * interClass.getAccessModifier().name().length() + 65) - (interClass.getSize().width)),interClass.getSize().height));
            System.out.println("setuje se size ");
            g.drawRect(interClass.getPostition().getLocation().x, interClass.getPostition().getLocation().y,interClass.getSize().width , interClass.getSize().height);
        }
        else
            g.drawRect(interClass.getPostition().getLocation().x, interClass.getPostition().getLocation().y, interClass.getSize().width,interClass.getSize().height);

        g.drawString(interClass.getAccessModifier().name(),interClass.getPostition().x+10,interClass.getPostition().y+10);
        g.drawString(interClass.getName(),interClass.getPostition().x+75,interClass.getPostition().y+10);

    }

    @Override
    public boolean elementAt(DiagramElement element, Point position, DiagramView diagramView) {
        InterClass interClass= (InterClass)element;
        InterClassPainter icp=null;
        if(diagramView.getPainters().isEmpty())
            System.out.println("prazno");
        for(ElementPainter ep:diagramView.getPainters()){
            if(ep.getDiagramElement()==null)
                System.out.println("nekako je  null");
            if(ep.getDiagramElement().equals(interClass)) {
                icp = (InterClassPainter) ep;

            }
        }
        if(icp==null)
            return false;

     //   if((icp.getFontSize()*interClass.getName().length()+ icp.getFontSize()*interClass.getAccessModifier().name().length()+65)>(interClass.getSize().width)){
        if((interClass.getPostition().x<position.x)&&(interClass.getPostition().y<position.y)&&(interClass.getPostition().x+interClass.getSize().width>position.x)&&(interClass.getPostition().y+interClass.getSize().height> position.y))
            return true;
                //mislim da treba bez -interclass.width
      //  }
       // else if((interClass.getPostition().x<position.x)&&(interClass.getPostition().y<position.y)&&(interClass.getPostition().y+interClass.getSize().height> position.y)&&(interClass.getPostition().x+interClass.getSize().width> position.x))
          //  return true;

        return false;

    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public DiagramElement getDiagramElement() {
        return diagramElement;
    }

    @Override
    public void setDiagramElement(DiagramElement diagramElement) {
        this.diagramElement = diagramElement;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
