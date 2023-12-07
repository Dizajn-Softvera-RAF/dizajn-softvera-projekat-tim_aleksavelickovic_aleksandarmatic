package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Agregation;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Composition;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Generalization;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public abstract class ConnectionPainter extends ElementPainter{
    private Point startPoint;
    private Point endPoint;

    private int flag=0;

    private int i;

    private ArrayList<Point>points=new ArrayList<>();

    public ConnectionPainter(DiagramElement diagramElement) {
        super(diagramElement);
        //mozda treba this diagel =diagel
    }

    public ConnectionPainter(DiagramElement diagramElement, DiagramView diagramView) {
        super(diagramElement, diagramView);

    }

    public  double dsquare(Point p1, Point p2) {
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
 /* private Point2D getC(double a, Point2D toPoint) {
      double x1 = fromPointMin.getX(), y1 = fromPointMin.getY(), x2 = toPoint.getX(), y2 = toPoint.getY();
      double h = a * Math.sqrt(3) / 2;
      double AB = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

      double xC = (x1 + ((AB-h)/h) * x2) / (1 + (AB-h)/h);
      double yC = (y1 + ((AB-h)/h) * y2) / (1 + (AB-h)/h);

      return new Point2D.Double(xC, yC);
  }
  */
    private void drawArrowLine(Graphics2D g, int x1, int y1, int x2, int y2, double d, double h,DiagramElement diagramElement) {
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



       // g.setColor(Color.white);
      //  g.fillPolygon(xpoints, ypoints, 3);
        //g.drawPolygon(xpoints,ypoints,3);
       // g.drawLine(x2,y2,(int)xm,(int)ym);//iz ova dva dependency
        //g.drawLine(x2,y2,(int)xn,(int)yn);

        double xc=(xm+xn)/2;
        double yc=(ym+yn)/2;
        double dx1=xc-x1;
        double dy1=yc-y1;
        D = Math.sqrt(dx1*dx1 + dy1*dy1);

        double xC = (x1 + ((D-h)/h) * xc) / (1 + (D-h)/h);
        double yC = (y1 + ((D-h)/h) * yc) / (1 + (D-h)/h);



      //  g.drawLine((int)xc,(int)yc,(int)xc+20,(int)yc+20);

       // g.drawPolygon(xpoints, ypoints, 3);

        Shape shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(x2,y2);
        ((GeneralPath)shape).lineTo(xm,ym);
        ((GeneralPath)shape).lineTo(xC,yC);
        ((GeneralPath)shape).lineTo(xn,yn);
        ((GeneralPath)shape).closePath();


       // g.draw(shape);
       // g.draw(shape);


        //g.fill(shape);
       // g.fill(shape);
        int[] xpoints4 = {(int)x2, (int) xm, (int) xn,(int)xC};
        int[] ypoints4 = {(int)y2, (int) ym, (int) yn,(int)yC};
      //  g.drawPolygon(xpoints4,ypoints4,4);



        int[] xpoints3 = {(int)xC, (int) xm, (int) xn};
        int[] ypoints3 = {(int)yC, (int) ym, (int) yn};
        //g.fillPolygon(xpoints3,ypoints3,3);
      //  g.drawPolygon(xpoints3,ypoints3,3);

        int[] xpoints1 = {(int)xm, (int) xm+30, (int) xn+30};
        int[] ypoints2 = {(int)ym, (int) ym+30, (int) yn+30};
     //   g.drawPolygon(xpoints1, ypoints2, 3);


        if(diagramElement instanceof Agregation){
            g.drawLine(x1, y1,(int) xC, (int)yC);
            g.draw(shape);

        }

         if(diagramElement instanceof Composition){
            g.drawLine(x1, y1,(int) xC, (int)yC);
            g.setColor(Color.BLACK);
            g.fill(shape);


        }
        if(diagramElement instanceof Generalization){
            g.drawLine(x1, y1,(int) xc, (int)yc);
            g.drawPolygon(xpoints,ypoints,3);

        }
        if(diagramElement instanceof Dependency){
            g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            g.drawLine(x1, y1,x2,y2);
            g.setStroke(new BasicStroke());
            g.drawLine(x2,y2,(int)xm,(int)ym);//iz ova dva dependency
            g.drawLine(x2,y2,(int)xn,(int)yn);

        }

    }
    @Override
    public void draw(Graphics2D g, DiagramElement diagramElement) {
       // g.setColor(Color.black);
        if(flag==1){
           /*
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
            */
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
            Point mint=cpt[0];
            double min=dsquare(cpf[0],cpt[0]);
            for(int i=0;i<4;i++){

                for(int j=0;j<4;j++){
                    if(dsquare(cpf[i],cpt[j])<min) {
                        min = dsquare(cpf[i], cpt[j]);
                        minf = cpf[i];
                        mint = cpt[j];
                    }
                }
            }


            Point conpointform=minf;



            Point conpointto=mint;
            Line2D line=new Line2D.Double(minf.x,minf.y,mint.x,mint.y);


            //g.draw(line);
            //drawArrowHead2(g,line);
            this.setStartPoint(new Point(minf.x, minf.y));
            this.setEndPoint(new Point(mint.x, mint.y));
            double a=20;
            double h=a*sqrt(3)/2;
            drawArrowLine(g,minf.x,minf.y,mint.x,mint.y,a,h,diagramElement);
        }
       else{
            //ovde treba konstano da se dodaje moze diagramview .repaint
            int i=0;
            System.out.println("velicina lista je "+points.size());

            //if(points.size()>1)
          //  drawArrowLine(g,points.,minf.y,mint.x,mint.y,35,25);
           // drawArrowLine(,35,25);
            i++;
         //   drawArrowLine(g,this.startPoint.x,this.startPoint.y,this.endPoint.x,this.endPoint.y,35,25);
            Line2D line2D=new Line2D.Double(this.startPoint.x,this.startPoint.y,this.endPoint.x,this.endPoint.y);
            g.draw(line2D);
           // g.drawLine(this.startPoint.x,this.startPoint.y,this.endPoint.x,this.endPoint.y);

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

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
