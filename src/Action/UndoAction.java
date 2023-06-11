package Action;

import Dao.ShapeDao;

import javax.swing.*;

public class UndoAction implements Action{
    @Override
    public void doAction(JFrame frame) {
        ShapeDao.getInstance().undoAction();
        frame.repaint();
    }
}
