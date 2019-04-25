package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by admin on 18.04.2019.
 */
public class Enemy implements Structure {
    public int x =10;
    public int y = 300;
    public int speed;
    public Image img;
    public Image img0 = new ImageIcon("res/car1.png").getImage();
    public Image img1 = new ImageIcon("res/car2.png").getImage();
    public Image img2 = new ImageIcon("res/car3.png").getImage();
    public Image img3 = new ImageIcon("res/car4.png").getImage();
    public Image img4 = new ImageIcon("res/car5.png").getImage();
    public Image img5 = new ImageIcon("res/car6.png").getImage();
    public Enemy(int speed){
        this.speed = speed;
        Random random = new Random();
        int randomCar = random.nextInt(6);
        switch (randomCar){
            case 0:
                img = img0;
                break;
            case 1:
                img = img1;
                break;
            case 2:
                img = img2;
                break;
            case 3:
                img = img3;
                break;
            case 4:
                img = img4;
                break;
            case 5:
                img = img5;
                break;
        }
    }



    @Override
    public void upDate(int speedHero) {
        x = x - speedHero + speed;
    }
    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);
    }
}
