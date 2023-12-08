package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;
import java.util.ArrayList;

public class Move implements State{
    Point start;

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public void misKlik(Point point, DiagramView diagramView) {

    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPusten(Point initPoint, Point endPoint, DiagramView diagramView) {
        //treba da se stavi na null xdiff i y diff u diag view
        diagramView.setxOffset(diagramView.getxDiff()+diagramView.getxOffset());//ako bi trebalo da radi ovako
        diagramView.setyOffset(diagramView.getyOffset()+diagramView.getyDiff());
        diagramView.setxDiff(0.0);



    }

    @Override
    public void misPrevucen(Point initPoint, Point endPoint, DiagramView diagramView) {

    }

    @Override
    public void misPrevucen(ArrayList<Point> points, DiagramView diagramView) {

    }

    @Override
    public void misPritisnut(Point initPoint, DiagramView diagramView) {
        this.setStart(initPoint);
    }

    @Override
    public void misPovucen(Point currPoint, DiagramView diagramView) {

    }

    @Override
    public void misPovucen(Point currPoint, int i, DiagramView diagramView) {
        diagramView.setxDiff(currPoint.getX()-this.getStart().getX());
        diagramView.setyDiff(currPoint.getY()-this.getStart().getY());
        diagramView.repaint();

    }
}
