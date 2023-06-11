import Constants.Actions;
import Constants.Shapes;
import Controller.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationGUI extends JFrame{
    private JButton lineButton;
    private JButton redoButton;
    private JButton undoButton;
    private JButton circleButton;
    private JButton boxButton;
    private JPanel mainPanel;
    private static final Mediator mediator = new Mediator();
    private static final JFrame frame = new ApplicationGUI("HW1 GUI");

    public ApplicationGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.pack();

        // Button Listener
        redoButton.addActionListener(actionEvent -> mediator.doAction(Actions.Redo,frame));
        lineButton.addActionListener(actionEvent -> mediator.setStateRequest(Shapes.Line));
        undoButton.addActionListener(actionEvent -> mediator.doAction(Actions.Undo,frame));
        circleButton.addActionListener(actionEvent -> mediator.setStateRequest(Shapes.Circle));
        boxButton.addActionListener(actionEvent -> mediator.setStateRequest(Shapes.Box));
    }

    public void paint(Graphics g){
        super.paint(g);
        mediator.reDraw(frame);
    }

    public static void main(String[] args){

        frame.setBounds(300,200,800,400);
        frame.setVisible(true);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mediator.drawShapeRequest(frame,e.getX(),e.getY());
            }
        });
    }
}
