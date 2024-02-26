
package GUI;

import javax.swing.JFrame;


public class Frame {

    public static void main(String[] args) {
        int boardwidth = 600;
        int boardheight = 600;
        JFrame frame=new JFrame("Snake");
        
        Panel panel=new Panel(boardwidth,boardheight);
        frame.add(panel);
        panel.requestFocus();
        
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
