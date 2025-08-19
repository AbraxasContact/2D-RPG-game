package main;

import java.awt.*;

public class UI {

    GamePanel gp;
    Font font;
    public UI(GamePanel gp){
        this.gp = gp;
        font = new Font("Arial", Font.BOLD, 40);
    }

    public void draw(Graphics2D g2){


        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawString("Key = " + gp.player.hasKey, 70, 70);
    }
}
