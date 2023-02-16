package com.snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private static final int SCREEN_HEIGHT = 500;
    private static final int SCREEN_WIDTH = 500;
    private Timer timer;
    private int x = 50;
    private int y = 50;


    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(92,182,23));
        this.setFocusable(true);
        this.addKeyListener(this);

        timer = new Timer(10,this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(x,y,25,25);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        repaint();
    }
}
