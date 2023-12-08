package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractClassyAction{
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Remove tool");
        putValue(SHORT_DESCRIPTION, "Remove Tool");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPackageView().startDelete();
        for (int i =0;i<MainFrame.getInstance().getPackageView().getDiagramView().getPainters().size();i++){
            ElementPainter ep = MainFrame.getInstance().getPackageView().getDiagramView().getPainters().get(i);
            if (ep.getDiagramElement().isSelected()){
                MainFrame.getInstance().getPackageView().getDiagramView().getPainters().remove(ep);
                MainFrame.getInstance().getPackageView().getDiagramView().getDiagram().removeChild(ep.getDiagramElement());
                i--;
            }
        }
    }
}
