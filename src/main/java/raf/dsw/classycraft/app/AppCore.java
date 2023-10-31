package raf.dsw.classycraft.app;


import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.core.ApplicationFramework;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        appCore.initialize();
        ProjectExplorer projectExplorer = new ProjectExplorer();
        projectExplorer.addChild(new Diagram("d",projectExplorer));
    }
}