package Controller;

import Constants.Actions;

import javax.swing.*;
import Action.ActionHandler;
import Constants.Shapes;
import Dao.ShapeDao;
import Shape.State.Dispatcher;

// Controller pattern
// Mediator between GUI and backend
public class Mediator {
    private Dispatcher shapeDispatcher;
    private ActionHandler actionHandler;

    public Mediator(){
        shapeDispatcher = new Dispatcher();
        actionHandler = new ActionHandler();
    }

    public void doAction(Actions action, JFrame frame){
        actionHandler.executeAction(action,frame);
    }

    public void reDraw(JFrame frame){
        ShapeDao.getInstance().reDraw(frame);
    }

    public void setStateRequest(Shapes shape){
        shapeDispatcher.setState(shape);
    }

    public boolean drawShapeRequest(JFrame frame, int xPosition, int yPosition){
        return shapeDispatcher.drawShape(frame,xPosition,yPosition);
    }
}
