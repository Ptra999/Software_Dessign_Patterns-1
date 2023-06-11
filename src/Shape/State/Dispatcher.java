package Shape.State;

import Constants.Shapes;
import Shape.ShapeContext;

import javax.swing.*;

import static Constants.Shapes.Circle;

// Composite and Iterator pattern
public class Dispatcher {
    private ShapeContext shapeContext;
    private ShapeState lineState;
    private ShapeState circleState;
    private ShapeState boxState;

    public Dispatcher(){
        shapeContext = new ShapeContext();
        lineState = new Line(30);
        circleState = new Circle(25);
        boxState = new Box(25);
    }

    public void setState(Shapes shape){
        if(shape == null)
            shapeContext.setState(null);
        else if(shape.equals(Shapes.Line))
            shapeContext.setState(lineState);
        else if(shape.equals(Circle))
            shapeContext.setState(circleState);
        else if(shape.equals(Shapes.Box))
            shapeContext.setState(boxState);
    }

    public boolean drawShape(JFrame frame, int xPosition, int yPosition){
        return shapeContext.draw(frame,xPosition,yPosition);
    }
}
