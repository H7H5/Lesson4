package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 15.04.2019.
 */
public class Hero {
    public int x = 100;
    public int y = 200;
    public int speed = 0;
    public int deltaSpeed = 0; //ускорение
    public int deltaMoveY = 0;
    public Image img = new ImageIcon("res/car2.png").getImage();
    public void upDate(){
        speed = speed + deltaSpeed;
        if (speed>=70){
            speed = 70;
        }
        if (speed<=0){
            speed=0;
        }
        if (speed >0) {
            y = y + deltaMoveY;
            if (y <= 10) {
                y = 10;
            }
            if (y >= 430) {
                y = 430;
            }
        }

    }
    public void paint (Graphics graphics){
        graphics.drawImage(img,x,y,img.getWidth(null)/2,img.getHeight(null)/2,null);

    }

    public void keyPressed(KeyEvent keyEvent){//событие на нажатие кнопки
        int event = keyEvent.getKeyCode();
        if (event == keyEvent.VK_UP) {
            deltaMoveY = -5;
        }
        if (event == keyEvent.VK_DOWN) {
            deltaMoveY = 5;
        }
        if (event == keyEvent.VK_LEFT) {
            deltaSpeed = -1;
        }
        if (event == keyEvent.VK_RIGHT) {
            deltaSpeed = 1;
        }
    }
    public void keyReleased(KeyEvent keyEvent){//событие на отжатие кнопки
        int event = keyEvent.getKeyCode();
        if (event == keyEvent.VK_UP) {
            deltaMoveY = 0;
        }
        if (event == keyEvent.VK_DOWN) {
            deltaMoveY = 0;
        }
        if (event == keyEvent.VK_LEFT) {
            deltaSpeed = 0;
        }
        if (event == keyEvent.VK_RIGHT) {
            deltaSpeed = 0;
        }
    }
}
