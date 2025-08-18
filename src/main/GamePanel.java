package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Constructor;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 16;
	final int scale = 3;
	public final int tileSize = originalTileSize *  scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;

	//SYSTEM
	Thread gameThread;
	TileManager tiles = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Sound music = new Sound();
    Sound se = new Sound();
	public CollisionChecker checker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);

	//ENTITY AND OBJECT
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[10];

	
	//FPS
	int fps = 60;
	
	
	//set player default player position
	GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setupGame() {

		aSetter.setObject();
		playMusic(0);
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//		double drawInterval = 1000000000/fps; // 0.01666 seconds
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		while(gameThread != null) {			
//			
//			update();
//			repaint();
//			
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				 
//				if(remainingTime < 0)
//					remainingTime = 0;
//				
//				Thread.sleep((long) remainingTime/ 1000000);
//				
//				nextDrawTime += drawInterval;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	public void run() {
	    double drawInterval = 1000000000 / fps; // Interval for each frame (in nanoseconds)
	    double delta = 0;

	    long lastTime = System.nanoTime();
	    long currentTime;

	    int drawTimes = 0;
	    long time = 0;

	    while (gameThread != null) {
	        currentTime = System.nanoTime();

	        // Calculate how much time has passed and add to delta
	        delta += (currentTime - lastTime) / drawInterval;
	        
	        time += currentTime - lastTime;

	        lastTime = currentTime;  // Update lastTime after the calculation
	        

	        if (delta >= 1) {
	            update();
	            repaint();

	            delta--;  // Decrease delta by 1 to indicate a frame has been drawn
	            drawTimes++; // Increase the draw counter
	        }

	        // Print FPS every second
//	        if (time >= 1000000000) {  // If a second has passed
//	            System.out.println("FPS: " + drawTimes);
//	            drawTimes = 0;  // Reset drawTimes for the next second
//	            time = 0;  // Reset time counter
//	        }
	    }
	}

	
	public void update() {
		
		player.update();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;

		//TILE
		tiles.draw(g2);

		//OBJECT
		for(int i = 0; i < obj.length; i++){
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}


		//PLAYER
		player.draw(g2);
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
