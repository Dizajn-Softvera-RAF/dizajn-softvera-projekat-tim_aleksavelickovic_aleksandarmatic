package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TabbedPane extends JTabbedPane {
    private Project project;
    private Package cpackage;
    private String author;
   private  JTabbedPane pane;
    private final List<DiagramView> diagrams = new ArrayList<>();

    public TabbedPane() {

        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

    }

    public void loadcpackage(Package toLoad) {
       // for(ClassyNode classyNode: cpackage.getChildren())
        System.out.println(toLoad.getName());
        project = (Project) toLoad.findProject();
        System.out.println(project.getName());
        cpackage  = toLoad;
        clear();
        loadDiagrams();
        addTabs();
        revalidate();
    }

    public void loadDiagrams() {
        for (ClassyNode cn : this.cpackage.getChildren()) {
            if (cn instanceof Diagram) {
                this.diagrams.add(new DiagramView((Diagram) cn));
            }
        }
    }

    public void clear() {
        for (DiagramView tabElement : diagrams)
            remove(tabElement);
        this.diagrams.clear();
    }

    public void addTabs() {
        for (DiagramView tabElement : this.diagrams)
            addTab(tabElement.getName(), tabElement);
    }

    public Project getproject() {
        return project;
    }

    public Package getCpackage() {
        return cpackage;
    }

    public List<DiagramView> getDiagrams() {
        return diagrams;
    }
}
