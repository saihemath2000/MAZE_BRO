/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.*;
import java.util.Objects;
import javax.imageio.ImageIO;
import mazesolver.GamePanel;

/**
 *
 * @author hemanth
 */
public class TileManager {
    GamePanel gp;
    public Tile [] tile;
    public int[][] mapTileNum;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/home/hemanth/NetBeansProjects/MazeSolver/src/maps/world01.txt");
    }
    public void getTileImage(){
        try{
           tile[0]= new Tile();
           tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png")));
           
           tile[1]= new Tile();
           tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
           tile[1].collision=true;

           tile[2]= new Tile();
           tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));
           tile[2].collision=true;

           tile[3]= new Tile();
           tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/earth.png")));
           
           tile[4]= new Tile();
           tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree.png")));
           tile[4].collision=true;

           tile[5]= new Tile();
           tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sand.png")));
           
           
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filepath) {
        try {
            InputStream is = new FileInputStream(filepath); // Load files from filesystem
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0, col = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                if (line == null) break; // Prevent null pointer exceptions when reaching EOF
                String[] numbers = line.split(" ");

                while (col < gp.maxWorldCol && col < numbers.length) { // Safeguard for malformed lines
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace(); // Log errors for debugging
        }
    }

    public void draw(Graphics2D g2){
       int worldRow=0,worldCol=0;
       while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow){
           int tileNum= mapTileNum[worldCol][worldRow];
           int worldX = worldCol * gp.tileSize;
           int worldY = worldRow * gp.tileSize;
           int screenX = worldX - gp.player.Worldx+ gp.player.screenX;
           int screenY = worldY - gp.player.Worldy+ gp.player.screenY;
           
           if(worldX +gp.tileSize > gp.player.Worldx-gp.player.screenX &&
              worldX -gp.tileSize < gp.player.Worldx+gp.player.screenX &&
              worldY+gp.tileSize > gp.player.Worldy-gp.player.screenY &&
              worldY-gp.tileSize< gp.player.Worldy+ gp.player.screenY){
             g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);    
           }
           
           worldCol++;
           if(worldCol==gp.maxWorldCol){
               worldCol=0;
           
               worldRow++;
               
           }
       }
    }
}
