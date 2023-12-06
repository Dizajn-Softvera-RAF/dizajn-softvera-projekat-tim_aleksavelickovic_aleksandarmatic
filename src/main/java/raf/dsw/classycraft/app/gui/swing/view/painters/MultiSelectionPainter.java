package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class MultiSelectionPainter {

    private Dimension dimension;
    private Point start;

    private Point end;
    private DiagramView diagramView;

    private Shape shape;


    public MultiSelectionPainter(Point start, Point end, DiagramView diagramView) {
        this.start = start;
        this.end = end;
        this.diagramView = diagramView;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public DiagramView getDiagramView() {
        return diagramView;
    }

    public void setDiagramView(DiagramView diagramView) {
        this.diagramView = diagramView;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }




    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        int w=end.x-start.x;
        int h=end.y-start.y;
      //  dimension.setSize(new Dimension(w,h));
        this.setDimension(new Dimension(w,h));

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(start.x,start.y);

        ((GeneralPath)shape).lineTo(start.x+dimension.getSize().width,start.y);

        ((GeneralPath)shape).lineTo(start.x+dimension.getSize().width,start.y+dimension.getSize().height);

        ((GeneralPath)shape).lineTo(start.x,start.y+dimension.getSize().height);

        ((GeneralPath)shape).closePath();

        g.draw(shape);

        Line2D line1 = new Line2D.Float(start.x,start.y,start.x+dimension.getSize().width,start.y);
        Line2D line2 = new Line2D.Float(start.x+dimension.getSize().width,start.y,start.x+dimension.getSize().width,start.y+dimension.getSize().height);
        Line2D line3 = new Line2D.Float(start.x+dimension.getSize().width,start.y+dimension.getSize().height,start.x,start.y+dimension.getSize().height);
        Line2D line4 = new Line2D.Float(start.x,start.y+dimension.getSize().height,start.x,start.y);


        Rectangle2D rectangle2D=new Rectangle2D.Double(start.getX(),start.getY(),dimension.getSize().width,dimension.getSize().height);

        for(ElementPainter ep:diagramView.getPainters()){
            if (ep instanceof InterClassPainter){
                double x=((InterClass)ep.getDiagramElement()).getPostition().getX();
                double y=((InterClass)ep.getDiagramElement()).getPostition().getY();
                double classw=((InterClass)ep.getDiagramElement()).getSize().width;
                double classh=((InterClass)ep.getDiagramElement()).getSize().height;
                Rectangle2D recc=new Rectangle2D.Double(x,y,classw,classh);
                Line2D l1=new Line2D.Double(x,y,x+classw,y);
                Line2D l2=new Line2D.Double(x,y,x,y+classh);
                Line2D l3=new Line2D.Double(x+classw,y,x+classw,y+classh);
                Line2D l4=new Line2D.Double(x,y+classh,x+classw,y+classh);

                if(shape.contains(x,y)||shape.contains(x+classw,y)|| shape.contains(x,y+classh)|| shape.contains(x+classw,y+classh) ){
                    ep.getDiagramElement().setSelected(true);
                    System.out.println("selektovani element je "+ep.getDiagramElement().getName());
                }
                else if(l1.intersectsLine(line1)||l1.intersectsLine(line2)||l1.intersectsLine(line3)||l1.intersectsLine(line4)||l2.intersectsLine(line1)||l2.intersectsLine(line2)||l2.intersectsLine(line3)||l2.intersectsLine(line4)
                        ||l3.intersectsLine(line1)||l3.intersectsLine(line2)||l3.intersectsLine(line3)||l3.intersectsLine(line4)||l4.intersectsLine(line1)||l4.intersectsLine(line2)||l4.intersectsLine(line3)||l4.intersectsLine(line4)){
                    ep.getDiagramElement().setSelected(true);
                    System.out.println("selektovani element je "+ep.getDiagramElement().getName());
                }
                else if(recc.contains(rectangle2D)){
                    ep.getDiagramElement().setSelected(true);
                    System.out.println("selektovani element je "+ep.getDiagramElement().getName());
                }//ovde treba unutar klase kad je
                else {
                    ep.getDiagramElement().setSelected(false);
                }
            }
            if (ep instanceof ConnectionPainter){
                Line2D line2D = new Line2D.Double(((ConnectionPainter) ep).getStartPoint().getX(),((ConnectionPainter) ep).getStartPoint().getY(),((ConnectionPainter) ep).getEndPoint().getX(),((ConnectionPainter) ep).getEndPoint().getY());


                double xs1=((ConnectionPainter)ep).getStartPoint().x;
                double ys1=((ConnectionPainter)ep).getStartPoint().y;
                double xe1=((ConnectionPainter)ep).getEndPoint().x;
                double ye1=((ConnectionPainter)ep).getEndPoint().y;
                double w1=xs1-xe1;
                double h1=ys1-ye1;
                Rectangle2D rect=new Rectangle2D.Double(xs1,ys1,w1,h1);
               // g.draw(rect);
                if (line2D.intersectsLine(line1)||line2D.intersectsLine(line2)||line2D.intersectsLine(line3)||line2D.intersectsLine(line4)){
                    ep.getDiagramElement().setSelected(true);
                    System.out.println("veza je selektovana");
                }



                else if(shape.contains(line2D.getBounds2D())) {
                    ep.getDiagramElement().setSelected(true);
                    System.out.println("veza je selcetovana");
                }


                else{
                    ep.getDiagramElement().setSelected(false);
                    System.out.println("veza nije selectovan");
                }






            }







        }
        System.out.println("Start x " +start.x+" start y "+start.y);
        System.out.println("End x " +end.x+" End y "+end.y);






    }


}
