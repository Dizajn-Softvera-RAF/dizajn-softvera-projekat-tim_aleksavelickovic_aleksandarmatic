package raf.dsw.classycraft.app.gui.swing.controller;



import raf.dsw.classycraft.app.classyRepository.State.ZoomIn;
import raf.dsw.classycraft.app.classyRepository.State.ZoomOut;

import javax.swing.*;
import java.net.URL;

public class ActionManager{

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private InfoAction aboutUs;
    private RemoveAction removeAction;
    private PackegeSelectedAction packegeSelectedAction;
    private DiagramSelectedAction diagramSelectedAction;
    private AuthorNameAction authorNameAction;
    private AuthorNameConfrimationAction authorNameConfrimationAction;
    private AddConnectionAction addConnectionAction;
    private AddElementAction addElementAction;
    private AddInterclassAction addInterclassAction;
    private DeleteAction deleteAction;
    private SelectedAction selectedAction;
    private EditAction editAction;
    private AgregationSelectionAction agregationSelectionAction;
    private  CompositionSelectionAction compositionSelectionAction;
    private DependencySelectionAction dependencySelectionAction;
    private GeneralizationSelectionAction generalizationSelectionAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private CloneAction cloneAction;
    private ClassButtonAction classButtonAction;
    private InterfaceButtonAction interfaceButtonAction;
    private EnumButtonAction enumButtonAction;
    private ConfirmAction confirmAction;
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

    public InfoAction getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(InfoAction aboutUs) {
        this.aboutUs = aboutUs;
    }

    public ClassButtonAction getClassButtonAction() {
        return classButtonAction;
    }

    public InterfaceButtonAction getInterfaceButtonAction() {
        return interfaceButtonAction;
    }

    public EnumButtonAction getEnumButtonAction() {
        return enumButtonAction;
    }

    public RemoveAction getRemoveAction() {
        return removeAction;
    }

    public PackegeSelectedAction getPackegeSelectedAction() {
        return packegeSelectedAction;
    }

    public void setPackegeSelectedAction(PackegeSelectedAction packegeSelectedAction) {
        this.packegeSelectedAction = packegeSelectedAction;
    }

    public DiagramSelectedAction getDiagramSelectedAction() {
        return diagramSelectedAction;
    }

    public void setDiagramSelectedAction(DiagramSelectedAction diagramSelectedAction) {
        this.diagramSelectedAction = diagramSelectedAction;
    }

    public void setRemoveAction(RemoveAction removeAction) {
        this.removeAction = removeAction;
    }

    public AuthorNameAction getAuthorNameAction() {
        return authorNameAction;
    }

    public void setAuthorNameAction(AuthorNameAction authorNameAction) {
        this.authorNameAction = authorNameAction;
    }

    public AuthorNameConfrimationAction getAuthorNameConfrimationAction() {
        return authorNameConfrimationAction;
    }

    public void setAuthorNameConfrimationAction(AuthorNameConfrimationAction authorNameConfrimationAction) {
        this.authorNameConfrimationAction = authorNameConfrimationAction;
    }

    public AddConnectionAction getAddConnectionAction() {
        return addConnectionAction;
    }

    public AddElementAction getAddElementAction() {
        return addElementAction;
    }

    public AddInterclassAction getAddInterclassAction() {
        return addInterclassAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public SelectedAction getSelectedAction() {
        return selectedAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public AgregationSelectionAction getAgregationSelectionAction() {
        return agregationSelectionAction;
    }

    public CompositionSelectionAction getCompositionSelectionAction() {
        return compositionSelectionAction;
    }

    public DependencySelectionAction getDependencySelectionAction() {
        return dependencySelectionAction;
    }

    public GeneralizationSelectionAction getGeneralizationSelectionAction() {
        return generalizationSelectionAction;
    }

    public ConfirmAction getConfirmAction() {
        return confirmAction;
    }

    public void setConfirmAction(JButton button) {
        this.confirmAction = new ConfirmAction(button);
    }

    public void setConfirmAction(JComboBox box) {
        this.confirmAction = new ConfirmAction(box);
    }

    public CloneAction getCloneAction() {
        return cloneAction;
    }
    public ZoomInAction getZoomInAction(){return zoomInAction;}
    public ZoomOutAction getZoomOutAction(){return zoomOutAction;}



    private void initialiseActions(){
        exitAction=new ExitAction();
        newProjectAction=new NewProjectAction();
        aboutUs = new InfoAction();
        removeAction=new RemoveAction();
        packegeSelectedAction=new PackegeSelectedAction();
        diagramSelectedAction=new DiagramSelectedAction();
        authorNameAction=new AuthorNameAction();
        authorNameConfrimationAction=new AuthorNameConfrimationAction();
        addConnectionAction = new AddConnectionAction();
        addElementAction = new AddElementAction();
        addInterclassAction = new AddInterclassAction();
        deleteAction = new DeleteAction();
        selectedAction = new SelectedAction();
        editAction = new EditAction();
        agregationSelectionAction = new AgregationSelectionAction();
        compositionSelectionAction = new CompositionSelectionAction();
        dependencySelectionAction = new DependencySelectionAction();
        generalizationSelectionAction = new GeneralizationSelectionAction();
        cloneAction=new CloneAction();
        zoomInAction=new ZoomInAction();
        zoomOutAction=new ZoomOutAction();

        enumButtonAction = new EnumButtonAction();
        classButtonAction = new ClassButtonAction();
        interfaceButtonAction = new InterfaceButtonAction();
        confirmAction = new ConfirmAction();
    }



}
