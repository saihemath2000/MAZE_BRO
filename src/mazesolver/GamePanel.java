/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import mazesolver.entity.Player;
import object.SuperObject;
import tile.TileManager;
/**
 *
 * @author hemanth
 */
public class GamePanel extends JPanel implements Runnable {
    
//SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale =3;
    public final int tileSize = originalTileSize * scale; //48 * 48
    public final int maxScreenCol = 16;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 px
    public final int screenHeight = tileSize * maxScreenRow;  //576 px
    
    
    //World settings 
    public  int maxWorldCol = 50;
    public  int maxWorldRow = 50;

    
    int FPS= 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);
    TileManager tileM = new TileManager(this);
    public CollisionChecker checker = new CollisionChecker(this);
    public SuperObject[] obj = new SuperObject[10];
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    Sound se = new Sound();
    Sound music = new Sound();
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        playMusic(0);
    }
    
    public void startGameThread(){
       gameThread = new Thread(this);
       gameThread.start();
    }
    
    @Override
    public void run(){
      double drawInterval = (double) 1000000000 /FPS;  //0.016666 sec
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      long timer=0;
      int drawCount=0;   
      while(gameThread!=null){
          
          currentTime= System.nanoTime();
          delta+= (currentTime-lastTime)/drawInterval;
          timer+=(currentTime-lastTime);
          lastTime = currentTime;
          if(delta>=1){
              update();
              repaint();
              delta--;
              drawCount++;
          }
          //update info of char pos
          
      }
    }
    public void update(){
    player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D  g2 = (Graphics2D)g;

        //tile
        tileM.draw(g2);
        //object
        for (SuperObject superObject : obj) {
            if (superObject != null) {
                superObject.draw(g2, this);
            }
        }
        //player
        player.draw(g2);
        //UI
        ui.draw(g2);
        g2.dispose();
    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
