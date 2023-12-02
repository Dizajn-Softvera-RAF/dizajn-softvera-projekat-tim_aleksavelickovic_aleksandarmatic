package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.*;

import java.awt.*;
import java.util.ArrayList;

public class AddConnection implements State{
    private int i = 0;
    private Connection connection;
    private ConnectionPainter connectionPainter;

    @Override
    public void misKlik(Point point, DiagramView diagramView) {}

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        /*InterClass from = null;
        InterClass to= null;
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                if(ep.elementAt(ep.getDiagramElement(),initPoint,diagramView)) {
                    System.out.println("pocetne koridante klse"+initPoint);
                    from = (InterClass) ep.getDiagramElement();
                }
                if(ep.elementAt(ep.getDiagramElement(),endPoint,diagramView)) {
                    if(!ep.getDiagramElement().equals(from)) {
                        System.out.println("zavrsne  koridante klase" + endPoint);//iz nekog razloga se povecava x u svakoj iteraciji vrv je to jedan
                        to = (InterClass) ep.getDiagramElement();
                    }
                }
            }
        }
        if(from!= null && to!=null) {
            Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("AGREGATION", "AGREGATION" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
            i++;

         */

          //  ConnectionPainter connectionPainter = new AgregationPainter(connection);
            // connectionPainter.getPoints().add() ovo je pre bilo zakom nema funk tren

            ConnectionPainter cp=new DependencyPainter(connection);
            cp.setFlag(1);
            cp.setStartPoint(initPoint);
            cp.setEndPoint(endPoint);
            diagramView.getDiagram().addChild(connection);//OVO RESAVA TAJ PROBLEM SA PAINTEROM ALI PRAVI DOLE HAHAHA
            diagramView.getPainters().add(cp);

           // diagramView.getDiagram().addChild(connection);
           // diagramView.getPainters().add(connectionPainter);

            //NE RADI DOBRO JE SE REPAINT POZIVA KAD SE NAPRAVI NOVI ELEMENT A OVDE SE NE PRAVI

    }

    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {

    }


    //   @Override
   /* public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {
        InterClass from = null;
        InterClass to= null;
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                if(ep.elementAt(ep.getDiagramElement(),initPoint,diagramView)) {
                     System.out.println("pocetne koridante klse"+initPoint);
                     from = (InterClass) ep.getDiagramElement();
                }
                if(ep.elementAt(ep.getDiagramElement(),endPoint,diagramView)) {
                    if(!ep.getDiagramElement().equals(from)) {
                        System.out.println("zavrsne  koridante klase" + endPoint);//iz nekog razloga se povecava x u svakoj iteraciji vrv je to jedan
                        to = (InterClass) ep.getDiagramElement();
                    }
                }
            }
        }
        if(from!= null && to!=null) {
            Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("AGREGATION", "AGREGATION" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
            i++;
            ConnectionPainter connectionPainter = new AgregationPainter(veza);
           // connectionPainter.getPoints().add()
            connectionPainter.setStartPoint(initPoint);
            connectionPainter.setEndPoint(endPoint);

            diagramView.getDiagram().addChild(veza);
            diagramView.getPainters().add(connectionPainter);

        }

    }



    */

    @Override
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView) {
        InterClass from = null;
        InterClass to= null;
        Point initPoint=points.get(0);
        Point endPoint=points.get(points.size()-1);
        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter){
                if(ep.elementAt(ep.getDiagramElement(),initPoint,diagramView)) {
                    System.out.println("pocetne koridante klse"+initPoint);
                    from = (InterClass) ep.getDiagramElement();
                }
                if(ep.elementAt(ep.getDiagramElement(),endPoint,diagramView)) {
                    if(!ep.getDiagramElement().equals(from)) {
                        System.out.println("zavrsne  koridante klase" + endPoint);//iz nekog razloga se povecava x u svakoj iteraciji vrv je to jedan
                        to = (InterClass) ep.getDiagramElement();
                    }
                }
            }

        }
        if(from!= null && to!=null) {
            Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("DEPENDENCY", "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
            i++;
            // ConnectionPainter connectionPainter = new AgregationPainter(veza);
            this.setConnection(veza);
            ConnectionPainter connectionPainter = new DependencyPainter(connection,diagramView);
            connectionPainter.setPoints(points);
            this.setConnectionPainter(connectionPainter);
            int t=0;
            System.out.println("kolko se put poziva ova funkcija "+i++);//svaki put kad se ovo pozove se pravi novi painter ne znam koliko je to dobro
           // diagramView.getDiagram().addChild(connection); OVO MOZDA TREBA DA SE VRATI ZOBG TOGA OVE NEMA REPAINT
            diagramView.getPainters().add(connectionPainter);

            // System.out.println("veza "+veza.getName());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ConnectionPainter getConnectionPainter() {
        return connectionPainter;
    }

    public void setConnectionPainter(ConnectionPainter connectionPainter) {
        this.connectionPainter = connectionPainter;
    }
}
