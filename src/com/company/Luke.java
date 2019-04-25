package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by admin on 15.04.2019.
 */
public class Luke {
    public int x = 400;
    public int y = 200;
    public Image img = new ImageIcon("res/luke.png").getImage();
    public void upDate(int speed){
        x = x - speed;
        if (x <=-150){
            x = 1400;
            Random random = new Random();
            y = random.nextInt(380-img.getHeight(null)/2)+70;
        }
    }
    public void paint (Graphics graphics){
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);

    }
}
