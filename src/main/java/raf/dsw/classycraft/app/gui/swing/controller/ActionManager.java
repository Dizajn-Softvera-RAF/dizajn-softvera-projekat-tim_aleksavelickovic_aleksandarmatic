package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.net.URL;

public class ActionManager{

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    public ActionManager() {
        initialiseActions();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    private void initialiseActions(){
        exitAction=new ExitAction();
        newProjectAction=new NewProjectAction();
    }



}
