package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage img;
    public boolean msgOn = false;
    public String msg = "";
    public int msgCounter;
    public boolean levelComplete = false;


    double playTime;
    DecimalFormat df = new DecimalFormat("0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        OBJ_Key key = new OBJ_Key();
        img = key.image;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

    }

    public void showMessage(String msg){

        this.msg = msg;
        msgOn = true;
    }

    public void draw(Graphics2D g2){

        if(levelComplete){
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLen;
            int x;
            int y;

            text = "You found the treasure!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            text = "Your time is: " + df.format(playTime) + "!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 + (gp.tileSize * 4);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 + (gp.tileSize * 2);
            g2.drawString(text, x, y);



            gp.gameThread = null;
        }else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(img, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            //TIME
            playTime += (double) 1/60;
            g2.drawString("Time: " + df.format(playTime), gp.tileSize * 11, 65);


            //MESSAGE
            if (msgOn) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(msg, gp.tileSize / 2, gp.tileSize * 5);

                msgCounter++;

                if (msgCounter == 120) {
                    msgCounter = 0;
                    msgOn = false;

                }
            }
        }
    }
}
