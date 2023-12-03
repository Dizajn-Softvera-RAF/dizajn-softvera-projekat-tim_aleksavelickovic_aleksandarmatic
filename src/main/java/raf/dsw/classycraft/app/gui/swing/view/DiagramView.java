package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    private ArrayList<Point>points=new ArrayList<>();



    private ArrayList<ElementPainter> painters=new ArrayList<>();
    public void paint(Graphics2D g){
        for(ElementPainter p:painters){
            System.out.println("prolazi kroz listu");
            p.draw(g,p.getDiagramElement());
        }
    }
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        // for()//treba da se prodje kroz sve paintere
       // DiagramView.this.paint(g2);
        //paint(g2);to ne radi ali tako treba da se radi
        System.out.println("Izvršena paintComponent metoda view-a");
        for(ElementPainter ep:painters) {
            ep.draw(g2, ep.getDiagramElement());
            ep.getDiagramElement().addSubscriber(this);
            if(ep.getDiagramElement()instanceof InterClass)//ne znam da li za ovim ima potrebe
                ((InterClass)ep.getDiagramElement()).addSubscriber(this);
        }
    }
    public Diagram getDiagram() {
        return diagram;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("prikazu je se dragged"+e.getX()+" "+e.getY());
    //    endPoint = new Point(e.getX(),e.getY());
        Point point =new Point(e.getX(),e.getY());
        points.add(point);
        points.set(0,initPoint);
        MainFrame.getInstance().getPackageView().misPrevucen(points,diagramView);


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("detektuje klik");


        Point p = new Point(e.getX(),e.getY());
        System.out.println("mouse point"+p.getLocation().x+" "+p.getLocation().y);
        //   Point p=MouseInfo.getPointerInfo().getLocation();
        MainFrame.getInstance().getPackageView().misKlik(p,diagramView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.initPoint = new Point(e.getX(),e.getY());
        this.setInitPoint(new Point(e.getX(),e.getY()));
        System.out.println("Initpoint je "+initPoint);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(),e.getY());
        System.out.println("mouse released koordinate su "+e.getX()+" "+e.getY());

        if(!points.isEmpty()) {
            System.out.println("poslednja svar u listi"+points.get(points.size()-1).getX()+" "+points.get(points.size()-1).getY());
            if (endPoint.getX()==points.get(points.size()-1).getX()&&endPoint.getY()==points.get(points.size()-1).getY()) {         //mozda ovaj equals nije ok
                System.out.println("po<vao se mis pusten");
                MainFrame.getInstance().getPackageView().misPusten(initPoint, endPoint, diagramView);

            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
     //   framework.setBackground(Color.RED);
     //   MainFrame.getInstance().getTabbedPane().add(framework,BorderLayout.CENTER);
     //   framework.addMouseListener(new MouseController());
      //  paintComponent(Graphics g);

    }
    @Override
    public void update(Object notification) {
        System.out.println("uslo u update");
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
