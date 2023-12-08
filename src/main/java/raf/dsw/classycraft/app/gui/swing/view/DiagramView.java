package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.MultiSelectionPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class DiagramView extends JPanel implements Subscriber, MouseMotionListener,MouseListener {
    private final Diagram diagram;
    private JPanel framework;
    private String name;
    private DiagramView diagramView=this;
    private Point endPoint;
    private Point initPoint;
    private double xOffset=0;
    private double yOffset=0;
    private ArrayList<Point>points=new ArrayList<>();

    private double zoom=1;
    private double prevzoom=1;

    private double xDiff;
    private double yDiff;
    private double startzoom;

    public double getStartzoom() {
        return startzoom;
    }

    public void setStartzoom(double startzoom) {
        this.startzoom = startzoom;
    }


    private ArrayList<ElementPainter> painters=new ArrayList<>();
    private ArrayList<MultiSelectionPainter> multiSelectionPainters=new ArrayList<>();
    public void paint(Graphics2D g){
        for(ElementPainter p:painters){
            System.out.println("prolazi kroz listu");
            p.draw(g,p.getDiagramElement());
        }
    }
    void transform( Graphics2D g){
        Dimension dimension=this.getSize();
        Rectangle2D r=this.getBounds();

        AffineTransform at=new AffineTransform();
        double ScaleX=(dimension.width/r.getWidth())*zoom;
        double ScaleY=(dimension.height/r.getHeight())*zoom;
        System.out.println("zoom je "+zoom);
        //AffineTransform zoom =AffineTransform.getScaleInstance(zoom,zoom);

        double xPos=MouseInfo.getPointerInfo().getLocation().getX()- getLocationOnScreen().getX();;
        double yPos=MouseInfo.getPointerInfo().getLocation().getY()- getLocationOnScreen().getY();;
        double zoomDiv=zoom/prevzoom;

        xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xPos;
        yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yPos;
      //  at.translate(-r.getMinX(),-r.getMinY());//pise da se dodaju unazad
       // at.scale(ScaleX,ScaleY);
       //
        if(xDiff !=0.0)
            at.translate(xOffset + xDiff, yOffset + yDiff);
        //at.translate(xOffset,yOffset);
        at.scale(zoom,zoom);
        prevzoom=zoom;

        g.transform(at);


    }
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        transform(g2);

      //  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        // for()//treba da se prodje kroz sve paintere
       // DiagramView.this.paint(g2);
        //paint(g2);to ne radi ali tako treba da se radi
      //  System.out.println("Izvršena paintComponent metoda view-a");

        for(ElementPainter ep:painters) {
          g2.setColor(ep.getDiagramElement().getColor());
            ep.draw(g2, ep.getDiagramElement());
            ep.getDiagramElement().addSubscriber(this);
            if(ep.getDiagramElement()instanceof InterClass)
                ((InterClass)ep.getDiagramElement()).addSubscriber(this);

        }
        for(MultiSelectionPainter mp: multiSelectionPainters){
            mp.draw(g2);
        }
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public double getxDiff() {
        return xDiff;
    }

    public void setxDiff(double xDiff) {
        this.xDiff = xDiff;
    }

    public double getyDiff() {
        return yDiff;
    }

    public void setyDiff(double yDiff) {
        this.yDiff = yDiff;
    }

    public void drawRect(Rectangle2D rectangle2D){
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.drawRect((int) rectangle2D.getX(), (int) rectangle2D.getY(), (int) rectangle2D.getWidth(), (int) rectangle2D.getHeight());
    }
    public Diagram getDiagram() {
        return diagram;
    }

    public ArrayList<MultiSelectionPainter> getMultiSelectionPainters() {
        return multiSelectionPainters;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      //  System.out.println("prikazu je se dragged"+e.getX()+" "+e.getY());
    //    endPoint = new Point(e.getX(),e.getY());
        int i=0;
        Point point =new Point(e.getX(),e.getY());

        Point zoom=new Point((int)(e.getX()/this.getZoom()),(int) (e.getY()/this.getZoom()));
        Point off=new Point((int)(xOffset), (int)(yOffset ));
        points.add(point);
        points.set(0,initPoint);
        if(point.equals(initPoint))
            System.out.println("pocetak je isti");

       // MainFrame.getInstance().getPackageView().misPrevucen(points,diagramView);
       // MainFrame.getInstance().getPackageView().misPovucen(point,diagramView);
        MainFrame.getInstance().getPackageView().misPovucen(zoom,i,diagramView);
        //i++;



    }
    public void removeConnectionPainter(){
      /*  for(ElementPainter ep:painters) {
            if(ep instanceof ConnectionPainter) {
                painters.remove(ep);
                System.out.println("uslo je u remove if");
            }
        }
        */
        if(painters.get(painters.size()-1)instanceof ConnectionPainter &&((Connection)painters.get(painters.size()-1).getDiagramElement()).getTo()==null )
       painters.remove(painters.size()-1);



    }
    public void removeMultiSelectionPainter(){
        if(multiSelectionPainters.size()>0) {
            if (multiSelectionPainters.get(multiSelectionPainters.size() - 1) instanceof MultiSelectionPainter)
                multiSelectionPainters.remove(multiSelectionPainters.size() - 1);
        }




    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("detektuje klik");


        Point p = new Point(e.getX(),e.getY());
        Point zoom=new Point((int)(e.getX()/this.getZoom()),(int) (e.getY()/this.getZoom()));
        System.out.println("mouse point"+p.getLocation().x+" "+p.getLocation().y);
            p=MouseInfo.getPointerInfo().getLocation();
       // Point off=new Point((int)(xOffset), (int)(yOffset ));
        MainFrame.getInstance().getPackageView().misKlik(zoom,diagramView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.initPoint = new Point(e.getX(),e.getY());
        //this.setInitPoint(new Point(e.getX(),e.getY()));
        Point zoom=new Point((int)(e.getX()/this.getZoom()),(int) (e.getY()/this.getZoom()));
        this.setInitPoint(zoom);
        Point off=new Point((int)(xOffset), (int)(yOffset ));//ovo treba da se obrise
        Point p=MouseInfo.getPointerInfo().getLocation();
       // this.setInitPoint(off);//ovo vrv treba da se obrise
        System.out.println("Initpoint je "+initPoint);
        if(!points.isEmpty())
            System.out.println("nije prazan points u pressedu");

        MainFrame.getInstance().getPackageView().misPritisnut(initPoint,diagramView);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(),e.getY());
        System.out.println("mouse released koordinate su "+e.getX()+" "+e.getY());
        Point zoom=new Point((int)(e.getX()/this.getZoom()),(int) (e.getY()/this.getZoom()));
        endPoint=zoom;

       /* if(!points.isEmpty()) {
            System.out.println("poslednja svar u listi"+points.get(points.size()-1).getX()+" "+points.get(points.size()-1).getY());
            if (endPoint.getX()==points.get(points.size()-1).getX()&&endPoint.getY()==points.get(points.size()-1).getY()) {         //mozda ovaj equals nije ok
                System.out.println("po<vao se mis pusten");
                MainFrame.getInstance().getPackageView().misPusten(initPoint, endPoint, diagramView);

            }

        }

        */
        MainFrame.getInstance().getPackageView().misPusten(initPoint, endPoint, diagramView);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    private class MouseController extends MouseAdapter{
        DiagramView dw = diagramView;
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);


        }

       // @Override
       /* public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("mouse clicked");
            //ovde zoves stateove pa metode za kliknut itd sa pointom za poziciju i posle se prave klase itd u zavisnosti od stejta
            Point p = new Point(e.getX(),e.getY());
            System.out.println("mouse point"+p.getLocation().x+" "+p.getLocation().y);
         //   Point p=MouseInfo.getPointerInfo().getLocation();
            MainFrame.getInstance().getPackageView().misKlik(p,dw);

        }*/

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            System.out.println("mis pomeren");

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);

            MainFrame.getInstance().getPackageView().misPrevucen(initPoint,endPoint,dw);
        }
        //@Override
       /* public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            System.out.println("Mis pusten");
            MainFrame.getInstance().getPackageView().misPusten();
        }*/



    }

    public List<ElementPainter> getPainters() {
        return painters;
    }

    public DiagramView(Diagram diagram){
        //this.setMinimumSize();
        System.out.println("evo su kordinate"+this.getSize().width+this.getSize().height);
        this.setMinimumSize(new Dimension(500,500));
        this.diagram = diagram;
        name = diagram.getName();
        this.diagram.addSubscriber(this);

        this.addMouseListener(new MouseController());
        this.diagramView = this;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //framework=new Framework();
       // framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //framework.setBackground(Color.WHITE);
     //   MainFrame.getInstance().getTabbedPane().add(framework,BorderLayout.CENTER);
     //   framework.addMouseListener(new MouseController());
      //  paintComponent(Graphics g);

    }
    @Override
    public void update(Object notification) {
      //  System.out.println("uslo u update");
        repaint();
    }

    public Point getInitPoint() {
        return initPoint;
    }

    public void setInitPoint(Point initPoint) {
        this.initPoint = initPoint;
    }

    @Override
    public String getName() {
        return name;
    }
/*    private class Framework extends JPanel{

        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;


            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
           // for()//treba da se prodje kroz sve paintere
            DiagramView.this.paint(g2);
            //paint(g2);to ne radi ali tako treba da se radi
            System.out.println("Izvršena paintComponent metoda view-a");
            for(ElementPainter ep:painters)
                ep.draw(g2,ep.getDiagramElement());
        }

    }
    */


}
