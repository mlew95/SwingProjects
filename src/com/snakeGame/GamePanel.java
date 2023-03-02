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
    private int[] snakeX = new int[200];
    private int[] snakeY = new int[200];
    private char direction = 'R';
    private int appleX;
    private int appleY;
    private boolean running = true;
    private int score = 0;
    private JLabel label;
    private int bodyParts = 1;


    public GamePanel() {
        label = new JLabel("Score : " + score);
        label.setFont(new Font("Rockwell",Font.ITALIC,40));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(92,182,23));
        this.add(label);
        this.setFocusable(true);
        this.addKeyListener(this);
        snakeX[0] = 250;
        snakeY[0] = 250;

        timer = new Timer(70,this);
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


        for (int i = 0; i < bodyParts; i++) {
            g.fillRect(snakeX[i],snakeY[i],25,25);
        }

        if (!running) {
            label.setText("Game over, Score : " + score);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP :
                if (direction != 'D')
                    direction = 'U';
                break;

            case KeyEvent.VK_DOWN :
                if (direction != 'U')
                direction = 'D';
                break;

            case KeyEvent.VK_LEFT :
                if (direction != 'R')
                direction = 'L';
                break;

            case KeyEvent.VK_RIGHT :
                if (direction != 'L')
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
            checkCollision();
            repaint();
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }

        switch (direction) {
            case 'U':
                snakeY[0] -= 10;
                break;

            case 'D':
                snakeY[0] += 10;
                break;

            case 'R':
                snakeX[0] += 10;
                break;

            case 'L':
                snakeX[0] -= 10;
                break;
        }
    }

    public void checkApple() {
        if ((snakeX[0] / 30 == appleX/30) && (snakeY[0] / 30 == appleY/30)) {
            newApple();
            score++;
            bodyParts++;
        }
    }

    public void checkCollision() {
        if (snakeX[0] < 0) {
            gameOver();
        }

        if (snakeX[0] > 470) {
            gameOver();
        }

        if (snakeY[0] < 10) {
            gameOver();
        }

        if (snakeY[0] > 470) {
            gameOver();
        }
    }

    private void gameOver() {
        running = false;
        timer.stop();
    }
}
