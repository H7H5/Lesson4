package com.company;

import javax.swing.*;
public class Main extends JPanel {
    public static JFrame jFrame;//обявляем обект JFrame
    public static final int WIDTH =1280;//количество клеток по шырине
    public static final int HEIGHT = 530;//количество клеток по высоте
    public static void main(String[] args) {
        jFrame = new JFrame("SNAKE");//установить  название окна
        jFrame.setSize(WIDTH,HEIGHT);//размеры окна
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//выход
        jFrame.setResizable(false);//запрет изменение размеров окна
        jFrame.setLocationRelativeTo(null);// разместить по центру
        jFrame.add(new Space());
        jFrame.setVisible(true);//сделать видимым
    }
}
