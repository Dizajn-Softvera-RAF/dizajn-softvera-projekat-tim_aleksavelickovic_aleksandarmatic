package raf.dsw.classycraft.app.classyRepository.State;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.*;

public class AddConnection implements State{

    @Override
    public void misKlik(Point point, DiagramView diagramView) {
        System.out.println("Connection print");
    }

    @Override
    public void misPusten() {

    }

    @Override
    public void misPrevucen() {

    }
}
