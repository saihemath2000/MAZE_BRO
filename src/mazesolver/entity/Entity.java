/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author hemanth
 */
public class Entity {
    public int Worldx,Worldy;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;
    
    public int spriteCounter=0;
    public int spriteNum =1;
    public Rectangle solidArea;
    public boolean collisionOn= false;
    public int solidAreaDefaultX,solidAreaDefaultY;
}
