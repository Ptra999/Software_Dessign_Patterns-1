package Dao;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

// Data layer to interact with application data
public class ShapeDao {
    private static ShapeDao instance;

    Stack<Shape> undoStack = new Stack<>();
    Stack<Shape> redoStack = new Stack<>();

    private ShapeDao(){}

    public static ShapeDao getInstance(){
        if(instance == null){
            instance = new ShapeDao();
        }
        return instance;
    }

    public void addShape(Shape shape){
        undoStack.push(shape);
    }

    public void undoAction(){
        if(undoStack.empty())
            return;
        redoStack.push(undoStack.pop());
    }

    public void redoAction(){
        if(redoStack.empty())
            return;
        undoStack.push(redoStack.pop());
    }

    public void reDraw(JFrame frame){
        Graphics2D graphics2D = (Graphics2D) frame.getGraphics();
        for (Shape shape:undoStack) {
            graphics2D.draw(shape);
        }
    }

}
