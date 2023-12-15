package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterClassPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.MultiSelectionPainter;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Selected implements State{
    private Point init;
    private boolean selected=false;

    private int t=0;

    public Point getInit() {
        return init;
    }

    public void setInit(Point init) {
        this.init = init;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        int k=0;
        Rectangle2D prav = new Rectangle2D.Double(point.getX()-5,point.getY()-5,10,10);

        if(selected==false) {

            for (ElementPainter ep : diagramView.getPainters()) {
                if (ep.elementAt(ep.getDiagramElement(), point, diagramView)) {
                    System.out.println(ep.getDiagramElement().getName());
                    k++;
                    System.out.println("jeste tu");
                    ep.getDiagramElement().setSelected(true);
                    ep.getDiagramElement().setColor(Color.red);
                    System.out.println(ep.getDiagramElement().getSelected());
                    this.setSelected(true);

                }
            }

            for (int i =0;i<diagramView.getPainters().size();i++) {
                ElementPainter ep = diagramView.getPainters().get(i);
                if (ep.getDiagramElement() instanceof Connection) {
                    Line2D line2D = new Line2D.Double(((ConnectionPainter) ep).getStartPoint().getX(), ((ConnectionPainter) ep).getStartPoint().getY(), ((ConnectionPainter) ep).getEndPoint().getX(), ((ConnectionPainter) ep).getEndPoint().getY());
                    if (prav.intersectsLine(line2D)) {
                        k++;
                        ep.getDiagramElement().setSelected(true);
                        ep.getDiagramElement().setColor(Color.red);
                        this.setSelected(true);

                    }
                }
            }
        }

            for(ElementPainter ep:diagramView.getPainters()) {
                ep.getDiagramElement().setSelected(false);
                if(ep.getDiagramElement() instanceof InterClass)
                ep.getDiagramElement().setColor(Color.BLUE);
                else
                    ep.getDiagramElement().setColor(Color.BLACK);
            }
        for (int i =0;i<diagramView.getPainters().size();i++) {
            ElementPainter ep = diagramView.getPainters().get(i);
                if (ep.elementAt(ep.getDiagramElement(), point, diagramView)) {
                    System.out.println(ep.getDiagramElement().getName());
                    k++;
                    System.out.println("jeste tu");
                    ep.getDiagramElement().setSelected(true);
                    ep.getDiagramElement().setColor(Color.red);
                    System.out.println(ep.getDiagramElement().getSelected());
                   // this.setSelected(true);

                }
            if (ep.getDiagramElement() instanceof Connection) {
                Line2D line2D = new Line2D.Double(((ConnectionPainter) ep).getStartPoint().getX(), ((ConnectionPainter) ep).getStartPoint().getY(), ((ConnectionPainter) ep).getEndPoint().getX(), ((ConnectionPainter) ep).getEndPoint().getY());
                if (prav.intersectsLine(line2D)) {
                    k++;
                    ep.getDiagramElement().setSelected(true);
                    ep.getDiagramElement().setColor(Color.red);
                    //this.setSelected(true);

                }
            }


        }
            this.setSelected(false);

    }



    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        diagramView.getMultiSelectionPainters().removeAll(diagramView.getMultiSelectionPainters());


        if(diagramView.getMultiSelectionPainters().isEmpty())
            System.out.println("prazna lista");
        for(ElementPainter ep: diagramView.getPainters()){





            if(ep.getDiagramElement().isSelected()==true){
                if(ep.getDiagramElement() instanceof InterClass){
                    ep.getDiagramElement().setColor(Color.red);
                }
                else if(ep.getDiagramElement() instanceof Connection){
                    ep.getDiagramElement().setColor(Color.red);

                }

            }
            else
                ep.getDiagramElement().setColor(ep.getDiagramElement().getColor());


        }




    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {
       // if(initPoint==null)

                for(ElementPainter ep:diagramView.getPainters()) {
                    ep.getDiagramElement().setSelected(false);
                    if(ep.getDiagramElement() instanceof InterClass)
                        ep.getDiagramElement().setColor(Color.BLUE);
                    else
                        ep.getDiagramElement().setColor(Color.BLACK);
                }


            System.out.println("jeste null");
              this.setInit(initPoint);
        this.setT(1);


    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }



    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
        System.out.println("uslo u drag");
        diagramView.removeMultiSelectionPainter();
        MultiSelectionPainter multiSelectionPainter=new MultiSelectionPainter(this.getInit(),currPoint,diagramView);
        diagramView.getMultiSelectionPainters().add(multiSelectionPainter);
        diagramView.repaint();
    }
}
