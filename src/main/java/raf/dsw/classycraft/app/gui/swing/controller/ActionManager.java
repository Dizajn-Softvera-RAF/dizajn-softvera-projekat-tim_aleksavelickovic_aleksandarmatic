package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.net.URL;
@Getter
@Setter
public class ActionManager{
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    public ActionManager() {initialiseActions();}
    private void initialiseActions(){
        exitAction=new ExitAction();
        newProjectAction=new NewProjectAction();
    }



}
