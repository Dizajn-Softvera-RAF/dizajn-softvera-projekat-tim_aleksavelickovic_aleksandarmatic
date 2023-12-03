package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.*;

import java.awt.*;
import java.util.ArrayList;

public class AddConnection implements State{
    private int i = 0;
    private Connection connection;
    private ConnectionPainter connectionPainter;
    private int t=0;

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
/* u poslednjem commitu je ovako i ne radi
            ConnectionPainter cp=new DependencyPainter(connection);
            cp.setFlag(1);
            cp.setStartPoint(initPoint);
            cp.setEndPoint(endPoint);

            diagramView.getDiagram().addChild(connection);//OVO RESAVA TAJ PROBLEM SA PAINTEROM ALI PRAVI DOLE HAHAHA
            diagramView.getPainters().add(cp);

           // diagramView.getDiagram().addChild(connection);
           // diagramView.getPainters().add(connectionPainter);


 */
        ConnectionPainter cp=new DependencyPainter(connection);
        cp.setFlag(1);
        cp.setStartPoint(initPoint);
        cp.setEndPoint(endPoint);
        diagramView.getDiagram().addChild(connection);//OVO RESAVA TAJ PROBLEM SA PAINTEROM ALI PRAVI DOLE HAHAHA

        ClassyTreeItem child=new ClassyTreeItem(connection);
        //MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),child);
        MainFrame.getInstance().getClassyTreeImplementation().addChild(null,diagramView.getDiagram(),child);
        diagramView.getPainters().add(cp);
            //NE RADI DOBRO JE SE REPAINT POZIVA KAD SE NAPRAVI NOVI ELEMENT A OVDE SE NE PRAVI
        for(ClassyNode cn :diagramView.getDiagram().getChildren()){
            System.out.println("dete ovog dijagrama ju "+cn.getName());
        }

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
       /* if(from!= null && to!=null) { u poslednjem komitu je ovako i ne radi
            if(t==0) {
                //ovde terab if else za tipove veeza
                connection = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("DEPENDENCY", "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
                i++;
                connectionPainter = new DependencyPainter(connection,diagramView);
                diagramView.getPainters().add(connectionPainter);
                diagramView.getDiagram().addChild(connection);
            }
            // ConnectionPainter connectionPainter = new AgregationPainter(veza);





            connectionPainter.setPoints(points);
           // this.setConnectionPainter(connectionPainter);

            System.out.println("kolko se put poziva ova funkcija "+i++);//svaki put kad se ovo pozove se pravi novi painter ne znam koliko je to dobro
           // diagramView.getDiagram().addChild(connection); OVO MOZDA TREBA DA SE VRATI ZOBG TOGA OVE NEMA REPAINT


            // System.out.println("veza "+veza.getName());
            t++;
        }

        */
        int k=0;
        if(from!= null && to!=null) {
            Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("DEPENDENCY", "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, to);
            i++;
            // ConnectionPainter connectionPainter = new AgregationPainter(veza);
            System.out.println("evo ga ime veze odma"+veza.getName());
            if(veza.equals(connection))
                System.out.println("sad je veza equal sa conn");
            this.setConnection(veza);
            ConnectionPainter connectionPainter = new DependencyPainter(connection);
            this.setConnectionPainter(connectionPainter);
            // diagramView.getDiagram().addChild(connection); OVO MOZDA TREBA DA SE VRATI ZOBG TOGA OVE NEMA REPAINT
            diagramView.getPainters().add(connectionPainter);

            // System.out.println("veza "+veza.getName());

            System.out.println("koliko puta se izvrski"+k);
            k++;
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
