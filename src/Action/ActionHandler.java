package Action;

import Constants.Actions;

import javax.swing.*;

// Command Pattern
public class ActionHandler {
    private Action undoAction;
    private Action redoAction;

    public ActionHandler(){
        undoAction = new UndoAction();
        redoAction = new RedoAction();
    }

    public void executeAction(Actions action, JFrame frame){
        if(action.equals(Actions.Undo))
            undoAction.doAction(frame);
        else if (action.equals(Actions.Redo))
            redoAction.doAction(frame);
    }
}
