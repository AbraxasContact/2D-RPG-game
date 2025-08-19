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
	public int hasKey = 0;


	public Player(GamePanel gp, KeyHandler keyH){
		
		this.gp = gp;
		this.keyH = keyH;
		
		
		screenX = gp.screenWidth/2 - gp.tileSize/2;
		screenY = gp.screenHeight/2 - gp.tileSize/2;
		
		setDefaultValues();

		solidArea = new Rectangle(8, 16,  32, 32);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
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
				direction = "down";
			}
			if(keyH.upPressed == true) {
				direction = "up";

			}
			
			if(keyH.leftPressed == true) {
				direction = "left";

			}
			if(keyH.rightPressed == true) {
				direction = "right";

			}

			//CHECK TILE COLLISION
			collisionOn = false;
			gp.checker.checkTile(this);

			//CHECK OBJECT COLLISION
			int objIndex = gp.checker.checkObject(this, true);
			pickObject(objIndex);

			//IF COLLISION IS FALSE THE PLAYER CAN MOVE
			if(!collisionOn){
				switch(direction){
					case "down":
						worldy += speed;
						break;
					case "up":
						worldy -= speed;
						break;
					case "left":
						worldx -= speed;
						break;
					case "right":
						worldx += speed;
						break;

				}
			}
			
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
	

	public void pickObject(int i){

		if(i != 999){

			String objectName = gp.obj[i].name;

			switch (objectName) {
				case "Key":
					gp.playSE(1);
					hasKey++;
					gp.obj[i] = null;
					gp.ui.showMessage("You got a key!");
					break;
				case "Door":
					if (hasKey > 0) {
						gp.playSE(3);
						gp.obj[i] = null;
						hasKey--;
						System.out.println(hasKey);
					}
					break;
				case "Boots":

					gp.playSE(2);
					speed += 1;
					gp.obj[i] = null;

					break;
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















