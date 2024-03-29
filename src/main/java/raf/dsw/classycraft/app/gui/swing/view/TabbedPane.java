package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.Package;
import raf.dsw.classycraft.app.classyRepository.implementation.Project;
import raf.dsw.classycraft.app.core.observer.interCommunicationNotification.InterCommunicationNotification;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TabbedPane extends JTabbedPane {
    private Project project;
    private Package cpackage;

    private final List<TabView> tabs = new ArrayList<>();

    private final List<TabView> tabstoSave = new ArrayList<>();

    private final List<DiagramView> diagrams = new ArrayList<>();

    private final List<DiagramView> diagramstoSave = new ArrayList<>();

    public TabbedPane() {

        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

    }

    public void loadcpackage(Package toLoad) {

        project = (Project) toLoad.findProject();
        cpackage  = toLoad;

        clear();
        loadDiagrams();
        addTabs();
        revalidate();


    }

    public void loadDiagrams() {

       /* for (ClassyNode cn : this.cpackage.getChildren()) {

            if (cn instanceof Diagram) {
                int f=0;
                for(DiagramView dv:diagrams){
                    System.out.println("imena diagarma i diagram viewa velicina diagramviewa "+cn.getName()+" "+dv.getDiagram().getName()+ " "+diagrams.size());
                   // if(dv.getDiagram().getName().equals(cn.getName())) {\
                        f = 1;

                    }
                 //   if(this.cpackage.getChildren().contains(dv.getDiagram()))
                   //     f=1;
                }

                //if(f==0)
                //if(this.cpackage.getChildren().contains(d))
                    this.diagrams.add(new DiagramView((Diagram) cn));
                System.out.println("louduje se dijagram");
            }
        }
        for(DiagramView dv:diagrams)
            System.out.println(dv.getName()+" velicina "+diagrams.size());

        */
      /*  for (ClassyNode cn : this.cpackage.getChildren()) {
            boolean exist=false;
            if (cn instanceof Diagram) {
                for(DiagramView dv : diagramstoSave){
                    if(dv.getDiagram().equals(cn)&&dv.getDiagram().getParent().equals(cn.getParent()))
                        exist=true;
                }
                if(exist){
                    for(DiagramView dv : diagramstoSave){
                        if(dv.getDiagram().equals(cn)&&dv.getDiagram().getParent().equals(cn.getParent())){
                            this.diagrams.add(dv);
                        }

                    }
                }
                else
                    this.diagrams.add(new DiagramView((Diagram) cn));
                    //  this.diagrams.add(((DiagramView) (new JScrollPane((new DiagramView((Diagram) cn)),22,22))));
            ((Diagram) cn).notifySubscribers(new InterCommunicationNotification("DIAGRAMVIEW_ADDED"));
            }
        }

       */
        for (ClassyNode cn : this.cpackage.getChildren()) {
            boolean exist=false;
            if (cn instanceof Diagram) {
                for(TabView tb : tabstoSave){
                    if(tb.getDiagramView().getDiagram().equals(cn)&&tb.getDiagramView().getDiagram().getParent().equals(cn.getParent()))
                        exist=true;
                }
                if(exist){
                    for(TabView tb : tabstoSave){
                        if(tb.getDiagramView().getDiagram().equals(cn)&&tb.getDiagramView().getDiagram().getParent().equals(cn.getParent())){
                            this.tabs.add(tb);
                        }

                    }
                }
                else
                    this.tabs.add(new TabView(new DiagramView((Diagram) cn)));
                //  this.diagrams.add(((DiagramView) (new JScrollPane((new DiagramView((Diagram) cn)),22,22))));
                ((Diagram) cn).notifySubscribers(new InterCommunicationNotification("DIAGRAMVIEW_ADDED"));
            }
        }
    }

    public List<TabView> getTabs() {
        return tabs;
    }

    public List<TabView> getTabstoSave() {
        return tabstoSave;
    }

    public List<DiagramView> getDiagramstoSave() {
        return diagramstoSave;
    }

    public void clear() {
        for (TabView tabElement : tabs){
            tabstoSave.add(tabElement);
            remove(tabElement);

        }
        this.tabs.clear();
        this.diagrams.clear();
    }

    public void addTabs() {
        for (TabView tabElement : tabs){
            addTab(tabElement.getDiagramView().getName(), tabElement);
        }
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
