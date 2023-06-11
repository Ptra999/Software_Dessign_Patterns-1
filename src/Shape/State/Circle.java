package Shape.State;

import javax.swing.*;
import java.awt.*;

import Dao.ShapeDao;

import java.awt.geom.Ellipse2D;

// Expert Pattern
public class Circle implements ShapeState {
    private int circleRadius;

    public Circle(int circleRadius){
        this.circleRadius = circleRadius;
    }

    @Override
    public boolean draw(JFrame frame, int xPosition, int yPosition) {
        if(xPosition-circleRadius < 75){
            JOptionPane.showMessageDialog(new JFrame(),"Please draw shape in valid space!!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Graphics2D graphics2D = (Graphics2D) frame.getGraphics();
        java.awt.Shape circle = new Ellipse2D.Double(xPosition-circleRadius,yPosition-circleRadius,circleRadius*2,circleRadius*2);
        graphics2D.draw(circle);

        ShapeDao.getInstance().addShape(circle);
        return true;
    }
}
