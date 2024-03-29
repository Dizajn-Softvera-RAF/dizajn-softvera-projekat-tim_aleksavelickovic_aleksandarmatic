package raf.dsw.classycraft.app.classyRepository.State;

public class StateManager {
    private State currState;

    private AddInterclass addInterclass;
    private AddConnection addConnection;
    private AddElement addElement;
    private Delete delete;
    private Selected selected;
    private Edit edit;

    private ZoomIn zoomIn;
    private ZoomOut zoomOut;

    private Clone clone;
    public StateManager(){
        init();
    }

    public State getCurrState() {
        return currState;
    }

    public void setAddInterclass() {
        currState =  addInterclass;
    }

    public void setAddConnection() {
        currState =  addConnection;
    }

    public void setAddElement() {
        currState =  addElement;
    }

    public void setDelete() {
        currState =  delete;
    }

    public void setSelected() {
        currState =  selected;
    }
    public void setEdit(){currState = edit;}

    public void setClone(){currState=clone;}

    public void setZoomIn(){currState=zoomIn;}
    public void setZoomOut(){currState=zoomOut;}



    private void init() {
        addInterclass = new AddInterclass();
        addConnection = new AddConnection();
        addElement = new AddElement();
        delete = new Delete();
        selected = new Selected();
        edit = new Edit();
        clone=new Clone();
        zoomIn=new ZoomIn();
        zoomOut=new ZoomOut();
        currState =  addInterclass;


    }
}
