package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel  gp){
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {

		int entityLeftWorldX = entity.worldx + entity.solidArea.x;
		int entityRightWorldX = entity.worldx + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldy + entity.solidArea.y;
		int entityBottomWorldY = entity.worldy + entity.solidArea.y +  entity.solidArea.height;


		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;

		int tileNum1, tileNum2;

		switch(entity.direction){
			case "up":
				entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
				tileNum1 = gp.tiles.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tiles.mapTileNum[entityRightCol][entityTopRow];

				if(gp.tiles.tiles[tileNum1].collision || gp.tiles.tiles[tileNum2].collision){
					entity.collisionOn = true;
				}
				break;
			case "down":
				entityBottomRow =  (entityBottomWorldY + entity.speed)/gp.tileSize;
				tileNum1 = gp.tiles.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tiles.mapTileNum[entityRightCol][entityBottomRow];

				if(gp.tiles.tiles[tileNum1].collision || gp.tiles.tiles[tileNum2].collision){
					entity.collisionOn = true;
				}
				break;
			case "left":
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tiles.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tiles.mapTileNum[entityLeftCol][entityBottomRow];

				if(gp.tiles.tiles[tileNum1].collision || gp.tiles.tiles[tileNum2].collision){
					entity.collisionOn = true;
				}
				break;
			case "right":
				entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tiles.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tiles.mapTileNum[entityRightCol][entityBottomRow];

				if(gp.tiles.tiles[tileNum1].collision || gp.tiles.tiles[tileNum2].collision){
					entity.collisionOn = true;
				}
				break;
			default:
		}
	}
}
