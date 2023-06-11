package Shape;

import Shape.State.ShapeState;

import javax.swing.*;

public class ShapeContext implements ShapeState {
    private ShapeState state;

    public void setState(ShapeState state){
        this.state = state;
    }

    public ShapeState getState(){
        return this.state;
    }

    @Override
    public boolean draw(JFrame frame, int xPosition, int yPosition) {
        if(state == null){
            JOptionPane.showMessageDialog(new JFrame(),"Please select shape!!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        state.draw(frame,xPosition,yPosition);
        return true;
    }
}
