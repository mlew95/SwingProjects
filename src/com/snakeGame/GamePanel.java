package com.snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private static final int SCREEN_HEIGHT = 500;
    private static final int SCREEN_WIDTH = 500;
    private Timer timer;
    private int x = 50;
    private int y = 50;
    private char direction = 'P';
    private int appleX;
    private int appleY;


    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(92,182,23));
        this.setFocusable(true);
        this.addKeyListener(this);

        timer = new Timer(50,this);
        startGame();
    }

    public void startGame() {
        newApple();
        timer.start();
    }

    private void newApple() {
        Random rand = new Random();
        appleX = rand.nextInt(478) + 1;
        appleY = rand.nextInt(478) + 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,20,20);
        g.setColor(Color.black);
        g.fillRect(x,y,25,25);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP :
                direction = 'U';
                break;

            case KeyEvent.VK_DOWN :
                direction = 'D';
                break;

            case KeyEvent.VK_LEFT :
                direction = 'L';
                break;

            case KeyEvent.VK_RIGHT :
                direction = 'R';
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (direction) {
            case 'U' :
                y -= 10;
                break;

            case 'D' :
                y += 10;
                break;

            case 'R' :
                x += 10;
                break;

            case 'L' :
                x -= 10;
                break;
        }

        repaint();
    }
}
