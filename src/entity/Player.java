package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH){
		
		this.gp = gp;
		this.keyH = keyH;
		
		
		screenX = gp.screenWidth/2 - gp.tileSize/2;
		screenY = gp.screenHeight/2 - gp.tileSize/2;
		
		setDefaultValues();
		
		solidArea = new Rectangle(worldx-8, worldy-16,  32, 32);
		
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		
		
		try {
			u1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			u2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));

			d1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			d2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));

			l1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			l2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));

			r1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			r2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDefaultValues() {
		worldx= gp.tileSize * 23;
		worldy= gp.tileSize * 21;
		speed= 4;	
		direction = "down";
	}
	
	public void update() {
		
		
		if(keyH.downPressed == true || keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			
			if(keyH.downPressed == true) {
				worldy += speed;
				direction = "down";
			}
			if(keyH.upPressed == true) {
				worldy -= speed;
				direction = "up";

			}
			
			if(keyH.leftPressed == true) {
				worldx -= speed;
				direction = "left";

			}
			if(keyH.rightPressed == true) {
				worldx += speed;
				direction = "right";

			}
			
			
			collisionOn = false;
			gp.checker.checkTile(this);
			
			
			
			
			spriteCounter ++;
			
			if (spriteCounter > 8) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				
				else 
					if(spriteNum == 2) {
					spriteNum =1;
				}
				
				spriteCounter = 0;
			}
			
		}
		
		
		
	}
	
	
	
	public void draw( Graphics2D g2){
		
	
//		g2.setColor(Color.white);
//		g2.fillRect( x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1)
				image = u1;
			if(spriteNum == 2)
				image = u2;
			break;
		case "down":
			if(spriteNum == 1)
				image = d1;
			if(spriteNum == 2)
				image = d2;
			break;
		case "left":
			if(spriteNum == 1)
				image = l1;
			if(spriteNum == 2)
				image = l2;
			break;
		case "right":
			if(spriteNum == 1)
				image = r1;
			if(spriteNum == 2)
				image = r2;
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
		
	}
}















