import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample{
    public static void main(String[] args){
        JFrame frame = new JFrame("MouseListenerExample");
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini");
        label.setBounds(50, 50, 300, 30);

        label.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
                label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            public void mousePressed(MouseEvent e){
                label.setText("Mouse pressed at: (" + e.getX() + ", " + e.getY() + ")");
            }

            public void mouseReleased(MouseEvent e){
                label.setText("Mouse released at: (" + e.getX() + ", " + e.getY() + ")");
            }

            public void mouseEntered(MouseEvent e){
                label.setText("Mouse entered the area");
            }

            public void mouseExited(MouseEvent e){
                label.setText("Mouse exited the area");
            }

        });
        frame.add(label);

        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
