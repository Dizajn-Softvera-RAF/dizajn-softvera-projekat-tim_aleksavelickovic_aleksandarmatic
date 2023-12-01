package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public abstract class ConnectionPainter extends ElementPainter{
    private Point startPoint;
    private Point endPoint;

    private int flag=0;

    private ArrayList<Point>points=new ArrayList<>();

    public ConnectionPainter(DiagramElement diagramElement) {
        super(diagramElement);
        //mozda treba this diagel =diagel
    }
  public  double dsquare(Point p1,Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return sqrt(dx * dx + dy * dy);
    }


  /*  public void drawArrowHead(Graphics2D g,Line2D line){

        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);

        tx.setToIdentity();
        double angle = Math.atan2(line.getY2()-line.getY1(), line.getX2()-line.getX1());
        tx.translate(line.getX2(), line.getY2());
        tx.rotate((angle-Math.PI/2d));

        g.setTransform(tx);
    }

   */
   /* public void drawArrowHead2(Graphics2D g,Line2D line){
        GeneralPath shape =new GeneralPath();

        shape.moveTo(line.getX2(),line.getY2());
        shape.lineTo(line.getX2()-45,line.getY2()-25);
        shape.moveTo(line.getX2(),line.getY2());
        shape.lineTo(line.getX2()-45,line.getY2()+25);
        //shape.lineTo(line.getX2(),line.getY2());
       // shape.closePath();
        double angle = Math.atan2(line.getY2()-line.getY1(), line.getX2()-line.getX1());
        tx.translate(line.getX2(), line.getY2());
        tx.rotate((angle-Math.PI/2d));

        g.setTransform(tx);
        g.draw(shape);



    }
    */

    private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }
    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {
        if(flag==1){
            Connection connection=(Connection)diagramElement;
            Point cpgf=new Point(connection.getFrom().getPostition().x+(connection.getFrom().getSize().width)/2,connection.getFrom().getPostition().y);
            Point cpdolf=new Point(connection.getFrom().getPostition().x+(connection.getFrom().getSize().width)/2,connection.getFrom().getPostition().y+connection.getFrom().getSize().height);
            Point cplf=new Point(connection.getFrom().getPostition().x,connection.getFrom().getPostition().y+(connection.getFrom().getSize().height)/2);
            Point cpdesf=new Point(connection.getFrom().getPostition().x+connection.getFrom().getSize().width,connection.getFrom().getPostition().y+(connection.getFrom().getSize().height)/2);

            Point cpgt=new Point(connection.getTo().getPostition().x+(connection.getTo().getSize().width)/2,connection.getTo().getPostition().y);
            Point cpdolt=new Point(connection.getTo().getPostition().x+(connection.getTo().getSize().width)/2,connection.getTo().getPostition().y+connection.getTo().getSize().height);
            Point cplt=new Point(connection.getTo().getPostition().x,connection.getTo().getPostition().y+(connection.getTo().getSize().height)/2);
            Point cpdest=new Point(connection.getTo().getPostition().x+connection.getTo().getSize().width,connection.getTo().getPostition().y+(connection.getTo().getSize().height)/2);


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
            Line2D line=new Line2D.Double(minf.x,minf.y,mint.x,mint.y);


            //g.draw(line);
            //drawArrowHead2(g,line);
            drawArrowLine(g,minf.x,minf.y,mint.x,mint.y,35,25);
        }
       else{
            //ovde treba konstano da se dodaje moze diagramview .repaint

        }


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

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
