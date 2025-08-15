package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public int worldx,worldy;
	public int speed;
	
	public BufferedImage r1, r2, l1, l2, u1, u2, d1, d2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;

	public int solidAreaDefaultX, solidAreaDefaultY;
}
