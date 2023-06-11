package Shape.State;

import javax.swing.*;
import java.awt.*;
import java.awt.Shape;

import Dao.ShapeDao;
import java.awt.geom.Rectangle2D;

// Expert Pattern
public class Box implements ShapeState {
    private int boxLength;

    public Box(int boxLength){
        this.boxLength = boxLength;
    }

    @Override
    public boolean draw(JFrame frame, int xPosition, int yPosition) {
        if(xPosition < 75){
            JOptionPane.showMessageDialog(new JFrame(),"Please draw shape in valid space!!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Graphics2D graphics2D = (Graphics2D) frame.getGraphics();
        Shape box = new Rectangle2D.Double(xPosition,yPosition,boxLength,boxLength);
        graphics2D.draw(box);

        ShapeDao.getInstance().addShape(box);
        return true;
    }
}
