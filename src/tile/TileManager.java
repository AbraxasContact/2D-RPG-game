package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tiles;
	public int[][] mapTileNum;
	
	public TileManager(GamePanel gp){
		
		this.gp = gp;
		tiles = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tiles[1].collision = true;
			
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tiles[2].collision = true;

			
			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tiles[4].collision = true;

			
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadMap(String map) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(map);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(row < gp.maxWorldRow && col < gp.maxWorldCol) {
				
				String[] numString = br.readLine().split(" ");
				
				while(col < gp.maxWorldCol) {
					int x = Integer.parseInt(numString[col]);
					mapTileNum[col][row] = x;
					col++;
				}
				
				if( col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
	
		int worldRow = 0;
		int worldCol = 0;
		
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldx + gp.player.screenX;
			int screenY = worldY - gp.player.worldy + gp.player.screenY;
			
			if(worldX  > gp.player.worldx- gp.player.screenX - gp.tileSize&& worldX < gp.player.worldx + gp.player.screenX + gp.tileSize
				&& worldY > gp.player.worldy - gp.player.screenY - gp.tileSize&& worldY < gp.player.worldy + gp.player.screenY + gp.tileSize) {
				g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,null);
			}
			
			worldCol++;
			
			
			if(worldCol == gp.maxWorldCol) {
				worldRow++;
				worldCol = 0;
			}
			
		}
		
		
	}
}
