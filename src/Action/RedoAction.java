package Action;

import  Dao.ShapeDao;

import javax.swing.*;

public class RedoAction implements Action{
    @Override
    public void doAction(JFrame frame) {
        ShapeDao.getInstance().redoAction();
        frame.repaint();
    }
}
