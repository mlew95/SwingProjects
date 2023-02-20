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
    private int snakeX = 50;
    private int snakeY = 50;
    private char direction = 'P';
    private int appleX;
    private int appleY;
    private boolean running = true;
    private int score = 0;
    private JLabel label;


    public GamePanel() {
        label = new JLabel("Score : " + score);
        label.setFont(new Font("Rockwell",Font.ITALIC,40));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(92,182,23));
        this.add(label);
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
        label.setText("Score : "  + score);
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,20,20);
        g.setColor(Color.black);
        g.fillRect(snakeX,snakeY,25,25);
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
        move();
        checkApple();
        repaint();
    }

    public void move() {
        switch (direction) {
            case 'U':
                snakeY -= 10;
                break;

            case 'D':
                snakeY += 10;
                break;

            case 'R':
                snakeX += 10;
                break;

            case 'L':
                snakeX -= 10;
                break;
        }
    }

    public void checkApple() {
        if ((snakeX / 30 == appleX/30) && (snakeY / 30 == appleY/30)) {
            newApple();
            score++;
        }
    }
}
