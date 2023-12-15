package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.Connection;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DeleteAction extends AbstractClassyAction{
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Delete.png"));
        putValue(NAME, "Remove tool");
        putValue(SHORT_DESCRIPTION, "Remove Tool");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<ConnectionPainter> delete=new ArrayList<>();
        MainFrame.getInstance().getPackageView().startDelete();
        for (int i =0;i<MainFrame.getInstance().getPackageView().getDiagramView().getPainters().size();i++) {
            ElementPainter ep = MainFrame.getInstance().getPackageView().getDiagramView().getPainters().get(i);
            if (ep.getDiagramElement().isSelected()) {
                MainFrame.getInstance().getClassyTreeImplementation().remove(((ep).getDiagramElement()));
                MainFrame.getInstance().getPackageView().getDiagramView().getPainters().remove(ep);
                MainFrame.getInstance().getPackageView().getDiagramView().getDiagram().removeChild(ep.getDiagramElement());
                for (ElementPainter el : MainFrame.getInstance().getPackageView().getDiagramView().getPainters()) {
                    if (el.getDiagramElement() instanceof Connection) {
                        if (((Connection) el.getDiagramElement()).getTo().equals(ep.getDiagramElement()) || ((Connection) el.getDiagramElement()).getFrom().equals(ep.getDiagramElement()))
                            delete.add((ConnectionPainter) el);
                    }
                }

            for (ConnectionPainter c : delete) {
                MainFrame.getInstance().getClassyTreeImplementation().remove(c.getDiagramElement());
                MainFrame.getInstance().getPackageView().getDiagramView().getPainters().remove(c);
                MainFrame.getInstance().getPackageView().getDiagramView().getDiagram().removeChild(c.getDiagramElement());
            }
            i--;

            }
        }
    }
}
