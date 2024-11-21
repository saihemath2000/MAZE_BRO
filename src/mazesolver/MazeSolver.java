/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mazesolver;
import javax.swing.JFrame;

/**
 *
 * @author hemanth
 */
public class MazeSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame window= new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2d Adventure");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();

        gamePanel.setupGame();
        gamePanel.startGameThread();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
}
