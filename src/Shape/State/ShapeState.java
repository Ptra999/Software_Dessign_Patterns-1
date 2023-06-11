package Shape.State;

import javax.swing.*;

// Use state pattern
public interface ShapeState {

    public boolean draw(JFrame frame, int xPosition, int yPosition);
}
