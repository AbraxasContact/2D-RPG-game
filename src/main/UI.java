package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font font;
    BufferedImage img;
    public boolean msgOn = false;
    public String msg = "";
    public int msgCounter;

    public UI(GamePanel gp){
        this.gp = gp;
        OBJ_Key key = new OBJ_Key();
        img = key.image;
        font = new Font("Arial", Font.BOLD, 40);
    }

    public void showMessage(String msg){

        this.msg = msg;
        msgOn = true;
    }

    public void draw(Graphics2D g2){


        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawImage(img, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasKey, 74, 65);

        //MESSAGE
        if(msgOn){
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(msg, gp.tileSize/2, gp.tileSize * 5);

            msgCounter++;

            if(msgCounter == 120){
                msgCounter = 0;
                msgOn = false;
            }
        }
    }
}
