package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.observer.Subscriber;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DiagramView extends JPanel implements Subscriber {
    private final Diagram diagram;
    private JPanel framework;
    private String name;


    private List<ElementPainter> painters;
    public void paint(Graphics g){
        for(ElementPainter p:painters){
            p.draw(g);
        }
    }
    private class MouseController extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }
    }



    public DiagramView(Diagram diagram){
        this.diagram = diagram;
        name = diagram.getName();
        this.diagram.addSubscriber(this);

        framework=new Framework();
        framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
        framework.setBackground(Color.WHITE);
        MainFrame.getInstance().getTabbedPane().add(framework,BorderLayout.CENTER);
        framework.addMouseListener(new MouseController());
    }
    @Override
    public void update(Object notification) {
        repaint();
    }

    @Override
    public String getName() {
        return name;
    }
    private class Framework extends JPanel{

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;


            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
           // for()//treba da se prodje kroz sve paintere

            System.out.println("Izvršena paintComponent metoda view-a");
        }

    }


}
