package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class TabView extends JScrollPane{
    private DiagramView diagramView;
    private JScrollBar horizonal;
    private JScrollBar vertical;

    public TabView( DiagramView diagramView) {
        super(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.diagramView = diagramView;
        this.setViewportView(diagramView);
   //     this.horizonal=new JScrollBar();
     //   this.vertical=new JScrollBar();

    }



    public DiagramView getDiagramView() {
        return diagramView;
    }

    public void setDiagramView(DiagramView diagramView) {
        this.diagramView = diagramView;
    }
}
