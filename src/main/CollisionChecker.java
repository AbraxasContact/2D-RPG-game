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

	public int checkObject(Entity entity, boolean player) {


		int index = 999;

		for(int i = 0; i < gp.obj.length; i++){

			if(gp.obj[i] != null){

				//Get entity's solid are position
				entity.solidArea.x = entity.worldx + entity.solidArea.x;
				entity.solidArea.y = entity.worldy + entity.solidArea.y;

				//Get the object's solid are position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;


				switch (entity.direction) {

					case "up":
						entity.solidArea.y -= entity.speed;

						if(entity.solidArea.intersects(gp.obj[i].solidArea)){

							if(gp.obj[i].collision){
								entity.collisionOn = true;
							}

							if(player){
								index = i;
							}

						}
						break;

					case "down":
						entity.solidArea.y += entity.speed;

						if(entity.solidArea.intersects(gp.obj[i].solidArea)){

							if(gp.obj[i].collision){
								entity.collisionOn = true;
							}

							if(player){
								index = i;
							}

						}
						break;

					case "left":

						entity.solidArea.x -= entity.speed;

						if(entity.solidArea.intersects(gp.obj[i].solidArea)){

							if(gp.obj[i].collision){
								entity.collisionOn = true;
							}

							if(player){
								index = i;
							}
					    }
						break;

					case "right":

						entity.solidArea.x += entity.speed;

						if(entity.solidArea.intersects(gp.obj[i].solidArea)){

							if(gp.obj[i].collision){
								entity.collisionOn = true;
							}

							if(player){
								index = i;
							}
						}
						break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}

		return index;
	}
}
