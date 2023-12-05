package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.GeneralPath;

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

        for(ElementPainter ep:diagramView.getPainters()){
            double x=((InterClass)ep.getDiagramElement()).getPostition().getX();
            double y=((InterClass)ep.getDiagramElement()).getPostition().getY();
            double classw=((InterClass)ep.getDiagramElement()).getSize().width;
            double classh=((InterClass)ep.getDiagramElement()).getSize().height;
            if(shape.contains(x,y)||shape.contains(x+classw,y)|| shape.contains(x,y+classh)|| shape.contains(x+classw,y+classh)){
                ep.getDiagramElement().setSelected(true);
                System.out.println("selektovani element je "+ep.getDiagramElement().getName());
            }


        }
        System.out.println("Start x " +start.x+" start y "+start.y);
        System.out.println("End x " +end.x+" End y "+end.y);






    }


}
