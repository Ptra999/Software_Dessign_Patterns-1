package Shape.State;

import Dao.ShapeDao;

import javax.swing.*;
import java.awt.*;
import java.awt.Shape;
import java.awt.geom.Line2D;

// Expert Pattern
public class Line implements ShapeState {
    private int lineHeight;

    public Line(int lineHeight){
        this.lineHeight = lineHeight;
    }

    @Override
    public boolean draw(JFrame frame, int xPosition, int yPosition) {
        if(xPosition < 75){
            JOptionPane.showMessageDialog(new JFrame(),"Please draw shape in valid space!!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Graphics2D graphics2D = (Graphics2D) frame.getGraphics();
        Shape line = new Line2D.Double(xPosition,yPosition,xPosition,yPosition-lineHeight);
        graphics2D.draw(line);

        ShapeDao.getInstance().addShape(line);
        return true;
    }
}
