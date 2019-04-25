package com.company;

import javax.swing.*;                //подключаем библиотеку
import java.awt.*;                   //подключаем библиотеку
import java.awt.event.ActionEvent;   //подключаем библиотеку
import java.awt.event.ActionListener;//подключаем библиотеку
import java.awt.event.KeyAdapter;    //подключаем библиотеку
import java.awt.event.KeyEvent;      //подключаем библиотеку
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by admin on 15.03.2019.//коментарий
 */
public class Space  extends JPanel implements ActionListener,Runnable {//обявляем класс Space насленик JPanel
    public int roadX = 0;
    public int roadX1 = 1280;
    public Image img = new ImageIcon("res/road2.png").getImage();
    public Hero hero = new Hero();
    public Luke luke = new Luke();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Thread enemiesFactory = new Thread(this);
    // который должен реализовать методы из ActionListener
    Timer t = new Timer(20,this);//создаем обект Timer
    public Space(){ // конструктор который создает обект  Space
        t.start();//запускаем таймер
        addKeyListener(new MyKeyAdapter());// создаем об'ект типа MyKeyAdapter
        enemiesFactory.start();
        setFocusable(true); // устанавливаем фокус окна
    }

    private class MyKeyAdapter extends KeyAdapter { // встроеный класс MyKeyAdapter для работы с кнопками
        public void keyPressed(KeyEvent keyEvent){//событие на нажатие кнопки
            hero.keyPressed(keyEvent);
        }
        public void keyReleased(KeyEvent keyEvent){//событие на отжатие кнопки
            hero.keyReleased(keyEvent);
        }
    }
    public void upDate(){
        hero.upDate();
        roadX = roadX - hero.speed;
        roadX1 = roadX1 -hero.speed;
        if(roadX1<=0){
            roadX = 0;
            roadX1 = 1280;
        }
        luke.upDate(hero.speed);
        for(int i =0 ; i < enemies.size();i++){
            enemies.get(i).upDate(hero.speed);
        }

    }
    public void paint (Graphics graphics){//здесь рисуем
        graphics.drawImage(img,roadX,0,img.getWidth(null),500,null);
        graphics.drawImage(img,roadX1,0,img.getWidth(null),500,null);
        luke.paint(graphics);
        for(int i =0 ; i < enemies.size();i++){
            enemies.get(i).paint(graphics);
        }
        hero.paint(graphics);
        //graphics.drawLine(0,70,1200,70);
        //graphics.drawLine(0,450,1200,450);



    }
    @Override
    public void actionPerformed(ActionEvent e) {//этот метод будет работать по таймеру
        upDate();
        repaint();
    }
    @Override
    public void run() {
        while (true){
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(2000));
                enemies.add(new Enemy(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
