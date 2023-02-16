package com.snakeGame;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
