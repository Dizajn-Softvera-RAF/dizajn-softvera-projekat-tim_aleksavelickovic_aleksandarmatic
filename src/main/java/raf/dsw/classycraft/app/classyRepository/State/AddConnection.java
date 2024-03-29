package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.InterClass;
import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.connections.Dependency;
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
    private String type;
    private InterClass from;
    private InterClass to;
    private Point Initpoint;


    public Point getInitpoint() {
        return Initpoint;
    }

    public void setInitpoint(Point initpoint) {
        Initpoint = initpoint;
    }

    @Override
    public void misKlik(Point point, DiagramView diagramView) {}



    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {
        //treba da se napravi veza i painter sa from pa posle u dragu da se vidi dal je to ok a mozda i u relesed

        int t=0;

        for(ElementPainter ep:diagramView.getPainters()) {
            if (ep instanceof InterClassPainter) {
                if (ep.elementAt(ep.getDiagramElement(), initPoint, diagramView)) {
                    System.out.println("pocetne koridante klse" + initPoint);
                    from = (InterClass) ep.getDiagramElement();
                    this.setInitpoint(initPoint);
                    t++;
                    return;


                }
            }
        }
        if(t==0)
            from=null;
      /*  Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection("DEPENDENCY", "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, null);
        this.setConnection(veza);
        ConnectionPainter connectionPainter1=new DependencyPainter(veza);
        this.setConnectionPainter(connectionPainter1);
        diagramView.getPainters().add(connectionPainter1);


      */

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView)   {
        System.out.println(" i je "+i);
        if(from!=null) {
            if (i != 0) {
                //diagramView.removeConnectionPainter();
                Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection(type, "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, null);
                this.setConnection(veza);
                if (type.equalsIgnoreCase("DEPENDENCY")) {
                    ConnectionPainter connectionPainter1 = new DependencyPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("GENERALIZATION")) {
                    ConnectionPainter connectionPainter1 = new GeneralizationPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("COMPOSITION")) {
                    ConnectionPainter connectionPainter1 = new CompositionPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("AGREGATION")) {
                    ConnectionPainter connectionPainter1 = new AgregationPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                }

            } else {
                diagramView.removeConnectionPainter();
                Connection veza = ApplicationFramework.getInstance().getClassyManufacturer().createConnection(type, "DEPENDENCY" + i, diagramView.getDiagram(), Color.BLACK, new BasicStroke(), from, null);
                this.setConnection(veza);

                if (type.equalsIgnoreCase("DEPENDENCY")) {
                    ConnectionPainter connectionPainter1 = new DependencyPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("GENERALIZATION")) {
                    ConnectionPainter connectionPainter1 = new GeneralizationPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("COMPOSITION")) {
                    ConnectionPainter connectionPainter1 = new CompositionPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                } else if (type.equalsIgnoreCase("AGREGATION")) {
                    ConnectionPainter connectionPainter1 = new AgregationPainter(veza);
                    connectionPainter1.setStartPoint(this.getInitpoint());
                    connectionPainter1.setEndPoint(currPoint);
                    this.setConnectionPainter(connectionPainter1);
                    diagramView.getPainters().add(connectionPainter1);
                    diagramView.repaint();
                }
            }
        }

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
        for(ElementPainter ep:diagramView.getPainters()) {

                if(ep.elementAt(ep.getDiagramElement(),endPoint,diagramView)) {
                    if(!ep.getDiagramElement().equals(from)) {
                        System.out.println("zavrsne  koridante klase" + endPoint);//iz nekog razloga se povecava x u svakoj iteraciji vrv je to jedan
                        to = (InterClass) ep.getDiagramElement();

                    }
                }
            }
        diagramView.removeConnectionPainter();

        if(from!=null&&to!=null&&to!=from) {
            int br=0;
            connection.setTo(to);
            for(ElementPainter ep :diagramView.getPainters()){
                if(ep.getDiagramElement() instanceof Connection)
                    if(((Connection)ep.getDiagramElement()).getFrom().equals(from)&&((Connection)ep.getDiagramElement()).getTo().equals(to) )
                        br++;
            }
            if(br==0) {
                if (type.equalsIgnoreCase("DEPENDENCY")) {
                    ConnectionPainter cp = new DependencyPainter(connection);
                    cp.setFlag(1);
                    cp.setStartPoint(initPoint);
                    cp.setEndPoint(endPoint);
                    diagramView.getDiagram().addChild(connection);

                    MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(), diagramView.getDiagram(), connection);
                    diagramView.getPainters().add(cp);
                } else if (type.equalsIgnoreCase("GENERALIZATION")) {
                    ConnectionPainter cp = new GeneralizationPainter(connection);
                    cp.setFlag(1);
                    cp.setStartPoint(initPoint);
                    cp.setEndPoint(endPoint);
                    diagramView.getDiagram().addChild(connection);

                    MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(), diagramView.getDiagram(), connection);
                    diagramView.getPainters().add(cp);
                } else if (type.equalsIgnoreCase("COMPOSITION")) {
                    ConnectionPainter cp = new CompositionPainter(connection);
                    cp.setFlag(1);
                    cp.setStartPoint(initPoint);
                    cp.setEndPoint(endPoint);
                    diagramView.getDiagram().addChild(connection);

                    MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(), diagramView.getDiagram(), connection);
                    diagramView.getPainters().add(cp);
                } else if (type.equalsIgnoreCase("AGREGATION")) {
                    ConnectionPainter cp = new AgregationPainter(connection);
                    cp.setFlag(1);
                    cp.setStartPoint(initPoint);
                    cp.setEndPoint(endPoint);
                    diagramView.getDiagram().addChild(connection);

                    MainFrame.getInstance().getClassyTreeImplementation().addChild(diagramView.getDiagram().getParent(), diagramView.getDiagram(), connection);
                    diagramView.getPainters().add(cp);
                }
            }
            else{
                diagramView.repaint();
            }

            br=0;
            //OVO RESAVA TAJ PROBLEM SA PAINTEROM ALI PRAVI DOLE HAHAHA


            //MainFrame.getInstance().getClassyTreeImplementation().addChild(MainFrame.getInstance().getClassyTreeImplementation().getSelectedNode(),child);

            //NE RADI DOBRO JE SE REPAINT POZIVA KAD SE NAPRAVI NOVI ELEMENT A OVDE SE NE PRAVI
            for (ClassyNode cn : diagramView.getDiagram().getChildren()) {
                System.out.println("dete ovog dijagrama ju " + cn.getName());
            }
        }
        else {
            diagramView.repaint();
        }
        from=null;
        to=null;

    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
