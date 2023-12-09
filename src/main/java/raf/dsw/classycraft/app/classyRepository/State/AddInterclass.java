package raf.dsw.classycraft.app.classyRepository.State;

import javafx.scene.shape.StrokeType;
import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.*;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Class;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements.Enum;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddInterclass implements State{
    private int i = 0;
    private InterClass interClass;
    private String type;
    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        boolean exist=false;
        if (type.equalsIgnoreCase("CLASS")){
            Class klasa1 = (Class) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass(type,"INTERFACE"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(200,100));
            InterClassPainter incp=new InterClassPainter(klasa1);
            for (ElementPainter ep : diagramView.getPainters()) {
                if (ep.elementAt(ep.getDiagramElement(), point, diagramView))
                    exist = true;
                Rectangle2D klasa=new Rectangle2D.Double((klasa1.getPostition().getX()),((InterClass) klasa1).getPostition().y,((InterClass) klasa1).getSize().width,((InterClass)klasa1).getSize().height);
                Shape shape;
                shape=new GeneralPath();
                ((GeneralPath)shape).moveTo(((InterClass) ep.getDiagramElement()).getPostition().x,((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height);
                ((GeneralPath)shape).closePath();

                if(shape.intersects(klasa))
                    exist=true;
                if(incp.elementAt(ep.getDiagramElement(),point,diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y),diagramView)){
                    exist=true;
                    continue;
                }

                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }


            }if(exist==false){
                diagramView.getDiagram().addChild(klasa1);
                this.setInterClass(klasa1);

                if(incp.getDiagramElement()==null)
                    System.out.println("null je na pocetku");
                diagramView.getPainters().add(incp);

                MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(),diagramView.getDiagram(),klasa1);
                for(ElementPainter ep:diagramView.getPainters()) {
                    if (ep instanceof InterClassPainter){
                        System.out.println(ep.getDiagramElement().getName());
                        if(ep.elementAt(ep.getDiagramElement(),point,diagramView))
                            System.out.println("jeste tu");
                    }

                }

            }else
                ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Class must be added outside of class", MessageType.ERROR, LocalDateTime.now());
        }
        if (type.equalsIgnoreCase("INTERFACE")){
            Interface klasa1 = (Interface) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass(type,"INTERFACE"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(200,100));
            InterClassPainter incp=new InterClassPainter(klasa1);
            for (ElementPainter ep : diagramView.getPainters()) {
                if (ep.elementAt(ep.getDiagramElement(), point, diagramView))
                    exist = true;
                Rectangle2D klasa=new Rectangle2D.Double((klasa1.getPostition().getX()),((InterClass) klasa1).getPostition().y,((InterClass) klasa1).getSize().width,((InterClass)klasa1).getSize().height);
                Shape shape;
                shape=new GeneralPath();
                ((GeneralPath)shape).moveTo(((InterClass) ep.getDiagramElement()).getPostition().x,((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height);
                ((GeneralPath)shape).closePath();

                if(shape.intersects(klasa))
                    exist=true;
                if(incp.elementAt(ep.getDiagramElement(),point,diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y),diagramView)){
                    exist=true;
                    continue;
                }

                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }

            }if(exist==false){
                diagramView.getDiagram().addChild(klasa1);
                this.setInterClass(klasa1);

                if(incp.getDiagramElement()==null)
                    System.out.println("null je na pocetku");
                diagramView.getPainters().add(incp);

                MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(),diagramView.getDiagram(),klasa1);
                for(ElementPainter ep:diagramView.getPainters()) {
                    if (ep instanceof InterClassPainter){
                        System.out.println(ep.getDiagramElement().getName());
                        if(ep.elementAt(ep.getDiagramElement(),point,diagramView))
                            System.out.println("jeste tu");
                    }

                }

            }else
                ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Class must be added outside of class", MessageType.ERROR, LocalDateTime.now());
        }
        if (type.equalsIgnoreCase("ENUM")){
            Enum klasa1 = (Enum) ApplicationFramework.getInstance().getClassyManufacturer().createInterClass(type,"INTERFACE"+i,diagramView.getDiagram(),Color.BLUE, new BasicStroke(), AccessModifier.PRIVATE,point, new Dimension(200,100));
            InterClassPainter incp=new InterClassPainter(klasa1);
            for (ElementPainter ep : diagramView.getPainters()) {
                if (ep.elementAt(ep.getDiagramElement(), point, diagramView))
                    exist = true;
                Rectangle2D klasa=new Rectangle2D.Double((klasa1.getPostition().getX()),((InterClass) klasa1).getPostition().y,((InterClass) klasa1).getSize().width,((InterClass)klasa1).getSize().height);
                Shape shape;
                shape=new GeneralPath();
                ((GeneralPath)shape).moveTo(((InterClass) ep.getDiagramElement()).getPostition().x,((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height);
                ((GeneralPath)shape).lineTo(((InterClass) ep.getDiagramElement()).getPostition().x, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height);
                ((GeneralPath)shape).closePath();

                if(shape.intersects(klasa))
                    exist=true;
                if(incp.elementAt(ep.getDiagramElement(),point,diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y),diagramView)){
                    exist=true;
                    continue;
                }

                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ep.getDiagramElement()).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(ep.elementAt(ep.getDiagramElement(),new Point(point.x+((InterClass) klasa1).getSize().width, point.y+((InterClass) klasa1).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }
                if(incp.elementAt(ep.getDiagramElement(),new Point(((InterClass) ep.getDiagramElement()).getPostition().x+((InterClass) ep.getDiagramElement()).getSize().width, ((InterClass) ep.getDiagramElement()).getPostition().y+((InterClass) ((InterClass) ep.getDiagramElement())).getSize().height),diagramView)){
                    exist=true;
                    continue;
                }

            }if(exist==false){
                diagramView.getDiagram().addChild(klasa1);
                this.setInterClass(klasa1);

                if(incp.getDiagramElement()==null)
                    System.out.println("null je na pocetku");
                diagramView.getPainters().add(incp);

                MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(),diagramView.getDiagram(),klasa1);
                for(ElementPainter ep:diagramView.getPainters()) {
                    if (ep instanceof InterClassPainter){
                        System.out.println(ep.getDiagramElement().getName());
                        if(ep.elementAt(ep.getDiagramElement(),point,diagramView))
                            System.out.println("jeste tu");
                    }

                }

            }else
                ApplicationFramework.getInstance().getMessageGeneratorImplementation().generate("Class must be added outside of class", MessageType.ERROR, LocalDateTime.now());
        }





    }

    public InterClass getInterClass() {
        return interClass;
    }

    public void setInterClass(InterClass interClass) {
        this.interClass = interClass;
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }

    public void setType(String type) {
        this.type = type;
    }
}
