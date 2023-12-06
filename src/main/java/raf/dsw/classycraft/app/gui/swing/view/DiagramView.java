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
    private ArrayList<MultiSelectionPainter> multiSelectionPainters=new ArrayList<>();
    public void paint(Graphics2D g){
        for(ElementPainter p:painters){
            System.out.println("prolazi kroz listu");
            p.draw(g,p.getDiagramElement());
        }
    }
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


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
        points.add(point);
        points.set(0,initPoint);
        if(point.equals(initPoint))
            System.out.println("pocetak je isti");
       // MainFrame.getInstance().getPackageView().misPrevucen(points,diagramView);
       // MainFrame.getInstance().getPackageView().misPovucen(point,diagramView);
        MainFrame.getInstance().getPackageView().misPovucen(point,i,diagramView);
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
        System.out.println("mouse point"+p.getLocation().x+" "+p.getLocation().y);
        //   Point p=MouseInfo.getPointerInfo().getLocation();
        MainFrame.getInstance().getPackageView().misKlik(p,diagramView);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.initPoint = new Point(e.getX(),e.getY());
        this.setInitPoint(new Point(e.getX(),e.getY()));

        System.out.println("Initpoint je "+initPoint);
        if(!points.isEmpty())
            System.out.println("nije prazan points u pressedu");

        MainFrame.getInstance().getPackageView().misPritisnut(initPoint,diagramView);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(),e.getY());
        System.out.println("mouse released koordinate su "+e.getX()+" "+e.getY());

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
