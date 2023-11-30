package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

import static java.lang.Math.sqrt;

public abstract class ConnectionPainter extends ElementPainter{
    private Point startPoint;
    private Point endPoint;
    public ConnectionPainter(DiagramElement diagramElement) {
        super(diagramElement);
        //mozda treba this diagel =diagel
    }
  public  double dsquare(Point p1,Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return sqrt(dx * dx + dy * dy);
    }
    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {

        Connection connection=(Connection)diagramElement;
        Point cpgf=new Point((connection.getFrom().getPostition().x+connection.getFrom().getSize().width)/2,connection.getFrom().getPostition().y);
        Point cpdolf=new Point((connection.getFrom().getPostition().x+connection.getFrom().getSize().width)/2,connection.getFrom().getPostition().y+connection.getFrom().getSize().height);
        Point cplf=new Point(connection.getFrom().getPostition().x,(connection.getFrom().getPostition().y+connection.getFrom().getSize().height)/2);
        Point cpdesf=new Point(connection.getFrom().getPostition().x+connection.getFrom().getSize().width,(connection.getFrom().getPostition().y+connection.getFrom().getSize().height)/2);

        Point cpgt=new Point((connection.getTo().getPostition().x+connection.getTo().getSize().width)/2,connection.getTo().getPostition().y);
        Point cpdolt=new Point((connection.getTo().getPostition().x+connection.getTo().getSize().width)/2,connection.getTo().getPostition().y+connection.getTo().getSize().height);
        Point cplt=new Point(connection.getTo().getPostition().x,(connection.getTo().getPostition().y+connection.getTo().getSize().height)/2);
        Point cpdest=new Point(connection.getTo().getPostition().x+connection.getTo().getSize().width,(connection.getTo().getPostition().y+connection.getTo().getSize().height)/2);

        Point[] cpf={cpgf,cpdolf,cplf,cpdesf};
        Point[] cpt={cpgt,cpdolt,cplt,cpdest};

        Point minf=cpf[0];
        for(int i=0;i<4;i++){
            if(dsquare(cpf[i],this.startPoint)<dsquare(minf,this.startPoint))
                minf=cpf[i];
        }


        Point conpointform=minf;

        Point mint=cpt[0];
        for(int i=0;i<4;i++){
            if(dsquare(cpt[i],this.endPoint)<dsquare(mint,this.endPoint))
                mint=cpt[i];
        }

        Point conpointto=mint;
        Line2D line2D=new Line2D.Double(minf.x,minf.y,mint.x,mint.y);
       // Line2D line2D=new Line2D.Double(cpgf.x,cpgf.y,cpdolt.x,cpdolt.y);
        g.draw(line2D);
    }

    @Override
    public boolean elementAt(DiagramElement element, Point position, DiagramView diagramView) {
        return false;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
