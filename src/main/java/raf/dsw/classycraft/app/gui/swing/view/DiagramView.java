package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class DiagramView extends JPanel implements Subscriber{
    private final Diagram diagram;
    private JPanel framework;
    private String name;
    private DiagramView diagramView=this;



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
        for(ElementPainter ep:painters)
            ep.draw(g2,ep.getDiagramElement());

    }
    public Diagram getDiagram() {
        return diagram;
    }


    private class MouseController extends MouseAdapter{
        DiagramView dw = diagramView;
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            //System.out.println("mouse pressed");

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("mouse clicked");
            //ovde zoves stateove pa metode za kliknut itd sa pointom za poziciju i posle se prave klase itd u zavisnosti od stejta
            Point p = new Point(e.getX(),e.getY());
            System.out.println("mouse point"+p.getLocation().x+" "+p.getLocation().y);
         //   Point p=MouseInfo.getPointerInfo().getLocation();
            MainFrame.getInstance().getPackageView().misKlik(p,dw);

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }

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
